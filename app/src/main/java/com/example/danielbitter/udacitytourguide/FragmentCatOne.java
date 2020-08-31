package com.example.danielbitter.udacitytourguide;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentCatOne extends Fragment {

    private GoogleApiClient mGoogleApiClient;

    public FragmentCatOne() {
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
                getString(R.string.one_title_one),
                getString(R.string.one_title_two),
                getString(R.string.one_title_three),
                getString(R.string.one_title_four),
                getString(R.string.one_title_five),
                getString(R.string.one_title_six),
                getString(R.string.one_title_seven),
                getString(R.string.one_title_eight),
                getString(R.string.one_title_nine),
                getString(R.string.one_title_ten)
        };

        int[] imageArray = new int[]{
                R.drawable.capitalgrille,
                R.drawable.carnevor,
                R.drawable.cubanitas,
                R.drawable.wardshouseofprime,
                R.drawable.maders,
                R.drawable.wickedhop,
                R.drawable.oddduck,
                R.drawable.rodizio,
                R.drawable.wolfpeach,
                R.drawable.smokeshack
        };

        String[] addrStrings= new String[]{
                getString(R.string.one_addr_one),
                getString(R.string.one_addr_two),
                getString(R.string.one_addr_three),
                getString(R.string.one_addr_four),
                getString(R.string.one_addr_five),
                getString(R.string.one_addr_six),
                getString(R.string.one_addr_seven),
                getString(R.string.one_addr_eight),
                getString(R.string.one_addr_nine),
                getString(R.string.one_addr_ten)
        };


        String[] coordStrings= new String[]{
                getString(R.string.one_coords_one),
                getString(R.string.one_coords_two),
                getString(R.string.one_coords_three),
                getString(R.string.one_coords_four),
                getString(R.string.one_coords_five),
                getString(R.string.one_coords_six),
                getString(R.string.one_coords_seven),
                getString(R.string.one_coords_eight),
                getString(R.string.one_coords_nine),
                getString(R.string.one_coords_ten)
        };
        
        String[] webAddrStrings= new String[]{
                getString(R.string.one_web_one),
                getString(R.string.one_web_two),
                getString(R.string.one_web_three),
                getString(R.string.one_web_four),
                getString(R.string.one_web_five),
                getString(R.string.one_web_six),
                getString(R.string.one_web_seven),
                getString(R.string.one_web_eight),
                getString(R.string.one_web_nine),
                getString(R.string.one_web_ten)
        };
        
        final ArrayList<ListItemDO> listItemDOs = new ArrayList<ListItemDO>();
        
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

        ListItemAdapter adapter
                = new ListItemAdapter(getActivity(), listItemDOs, mGoogleApiClient);
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        return rootView;
    }

}
