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
public class FragmentCatFive extends Fragment {
    private GoogleApiClient mGoogleApiClient;

    public FragmentCatFive() {
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
                getString(R.string.five_title_one),
                getString(R.string.five_title_two),
                getString(R.string.five_title_three),
                getString(R.string.five_title_four),
                getString(R.string.five_title_five),
                getString(R.string.five_title_six),
                getString(R.string.five_title_seven),
                getString(R.string.five_title_eight),
                getString(R.string.five_title_nine),
                getString(R.string.five_title_ten),
                getString(R.string.five_title_eleven),
                getString(R.string.five_title_twelve)
        };

        int[] imageArray = new int[]{
                R.drawable.publicmarket,
                R.drawable.benelux,
                R.drawable.wickedhop,
                R.drawable.colectivo,
                R.drawable.colectivo,
                R.drawable.anodyne,
                R.drawable.riverwalk,
                R.drawable.oldworldthird,
                R.drawable.marquette,
                R.drawable.uwm,
                R.drawable.cathedralsquare,
                R.drawable.redarrowpark
        };

        String[] addrStrings= new String[]{
                getString(R.string.five_addr_one),
                getString(R.string.five_addr_two),
                getString(R.string.five_addr_three),
                getString(R.string.five_addr_four),
                getString(R.string.five_addr_five),
                getString(R.string.five_addr_six),
                getString(R.string.five_addr_seven),
                getString(R.string.five_addr_eight),
                getString(R.string.five_addr_nine),
                getString(R.string.five_addr_ten),
                getString(R.string.five_addr_eleven),
                getString(R.string.five_addr_twelve)
        };

        String[] coordStrings= new String[]{
                getString(R.string.five_coords_one),
                getString(R.string.five_coords_two),
                getString(R.string.five_coords_three),
                getString(R.string.five_coords_four),
                getString(R.string.five_coords_five),
                getString(R.string.five_coords_six),
                getString(R.string.five_coords_seven),
                getString(R.string.five_coords_eight),
                getString(R.string.five_coords_nine),
                getString(R.string.five_coords_ten),
                getString(R.string.five_coords_eleven),
                getString(R.string.five_coords_twelve)
        };

        String[] webAddrStrings= new String[]{
                getString(R.string.five_web_one),
                getString(R.string.five_web_two),
                getString(R.string.five_web_three),
                getString(R.string.five_web_four),
                getString(R.string.five_web_five),
                getString(R.string.five_web_six),
                getString(R.string.five_web_seven),
                getString(R.string.five_web_eight),
                getString(R.string.five_web_nine),
                getString(R.string.five_web_ten),
                getString(R.string.five_web_eleven),
                getString(R.string.five_web_twelve)
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
