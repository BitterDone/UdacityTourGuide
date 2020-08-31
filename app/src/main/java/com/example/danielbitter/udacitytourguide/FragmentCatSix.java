package com.example.danielbitter.udacitytourguide;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentCatSix extends Fragment {
    private GoogleApiClient mGoogleApiClient;

    public FragmentCatSix() {
        // Required empty public constructor
    }

    public void setGoogleApiClient(GoogleApiClient mgac) {
        this.mGoogleApiClient = mgac;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);
        //Normally all this data importing would use a database, but we haven't learned that yet
        String[] wordsArray = new String[]{
                getString(R.string.six_title_one),
                getString(R.string.six_title_two),
                getString(R.string.six_title_three),
                getString(R.string.six_title_four),
                getString(R.string.six_title_five)
        };

        int[] imageArray = new int[]{
                R.drawable.benelux,
                R.drawable.wickedhop,
                R.drawable.loadedslate,
                R.drawable.jacksons,
                R.drawable.sobelmans
        };

        String[] addrStrings= new String[]{
                getString(R.string.six_addr_one),
                getString(R.string.six_addr_two),
                getString(R.string.six_addr_three),
                getString(R.string.six_addr_four),
                getString(R.string.six_addr_five)
        };

        String[] coordStrings= new String[]{
                getString(R.string.six_coords_one),
                getString(R.string.six_coords_two),
                getString(R.string.six_coords_three),
                getString(R.string.six_coords_four),
                getString(R.string.six_coords_five)
        };

        String[] webAddrStrings= new String[]{
                getString(R.string.six_web_one),
                getString(R.string.six_web_two),
                getString(R.string.six_web_three),
                getString(R.string.six_web_four),
                getString(R.string.six_web_five)
        };

        ArrayList<ListItemDO> listItemDOs = new ArrayList<ListItemDO>();

        for(int i=0;i<wordsArray.length;++i){
            ListItemDO listItemDO = new ListItemDO(wordsArray[i], getContext());
            listItemDO.setImageId(imageArray[i]);
            listItemDO.setAddress(addrStrings[i]);
            listItemDO.setWebAddress(webAddrStrings[i]);
            String splitter = getContext().getString(R.string.constant_comma).concat(
                    getContext().getString(R.string.constant_space)
            );
            String[] coords = coordStrings[i].split(splitter); //should result in ", "
            listItemDO.setLatitude(Double.valueOf(coords[0]));
            listItemDO.setLongitude(Double.valueOf(coords[1].trim()));

            listItemDOs.add(i, listItemDO);
        }

        ListItemAdapter adapter = new ListItemAdapter(getActivity(), listItemDOs);
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        return rootView;
    }

}
