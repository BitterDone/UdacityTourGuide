package com.example.danielbitter.udacitytourguide;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

import java.util.ArrayList;

/**
 * Created by danielbitter on 12/13/16.
 * http://blog.teamtreehouse.com/beginners-guide-location-android
 * http://www.androidrey.com/android-location-settings-dialog-tutorial/
 * https://developer.android.com/training/location/change-location-settings.html#prompt
 * http://stackoverflow.com/questions/18752202/check-if-application-is-installed-android
 * http://stackoverflow.com/questions/17324757/how-to-launch-apps-like-facebook-or-yelp-from-browser
 * https://developer.android.com/reference/android/location/Location.html#distanceTo%28android.location.Location%29
 * http://stackoverflow.com/questions/13675535/how-to-launch-apps-facebook-twitter-etc-from-mobile-browser-but-fall-back-to-h
 */

public class ListItemAdapter extends ArrayAdapter<ListItemDO> {
    private final Context context;
    private final ArrayList<ListItemDO> values;
    private GoogleApiClient mGoogleApiClient = null;

    //Two constructers allows testing of dist calcs to each place w/o breaking everything
    public ListItemAdapter(Context context, ArrayList<ListItemDO> values) {
        super(context, 0, values);
        this.context = context;
        this.values = values;
    }

    public ListItemAdapter(Context context, ArrayList<ListItemDO> values, GoogleApiClient mgac) {
        super(context, 0, values);
        this.mGoogleApiClient = mgac;
        this.context = context;
        this.values = values;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null) {
            listItem = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        ImageView listItemImage = (ImageView) listItem.findViewById(R.id.image);
        TextView listItemWord = (TextView) listItem.findViewById(R.id.list_item_word);
        ListItemDO listItemDO = values.get(position);
        final String title = listItemDO.getTitle();
        final String address = listItemDO.getAddress();
        final String webAddress = listItemDO.getWebAddress();

        if(listItemDO.getHasImage()){
            listItemImage.setImageResource(listItemDO.getImageId());
        }
        listItemWord.setText(title);
        listItemWord.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String entryItem = title;
                PackageManager pm = context.getPackageManager();
                boolean isInstalled = isPackageInstalled(context.getString(R.string.packageYelp), pm);

                Log.v("ListItemAdapter", "Current listItemDO: " + entryItem);
                Log.v("ListItemAdapter", "Yelp installed: " + isInstalled);

                if(!webAddress.equalsIgnoreCase("") && webAddress != null){
                   Intent i = new Intent(Intent.ACTION_VIEW);
                   i.setData(Uri.parse(webAddress));
                   context.startActivity(i);
                }
            }
        });

        ImageView navImage = (ImageView) listItem.findViewById(R.id.distanceNavIcon);
        navImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String entryItem = title;
                Log.v("ListItemAdapter", "Current nav: " + entryItem);
                Uri gmmIntentUri = Uri.parse(context.getString(R.string.urlGoogleMaps)+address);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage(context.getString(R.string.packageGoogle));
                context.startActivity(mapIntent);
            }
        });

        float distance = calculateDistanceTo(listItemDO);
        if(distance >= 0f){
            TextView navigation = (TextView) listItem.findViewById(R.id.distanceDisplay);
            navigation.setVisibility(View.VISIBLE);
            navigation.setText(String.valueOf(distance));
        }

        return listItem;
    }

    private boolean isPackageInstalled(String packagename, PackageManager packageManager) {
        try {
            packageManager.getPackageInfo(packagename, PackageManager.GET_ACTIVITIES);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    public float calculateDistanceTo(ListItemDO lido){
        float[] results = new float[]{0.0f, 0.0f, 0.0f};
        boolean havePermission = checkExternalPermission();
        if(havePermission && mGoogleApiClient != null){
            Location loc = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
            Location.distanceBetween(
                    loc.getLatitude(), loc.getLongitude(),
                    lido.getLatitude(), lido.getLongitude(),
                    results);

            return results[0];
        }
        return -1f;
    }

    private boolean checkExternalPermission(){
        String permission = context.getString(R.string.permissionLocationFine);
        int res = context.checkCallingOrSelfPermission(permission);
        return (res == PackageManager.PERMISSION_GRANTED);
    }
}
