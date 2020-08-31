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
public class FragmentCatFour extends Fragment {
    private GoogleApiClient mGoogleApiClient;

    public FragmentCatFour() {
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
                getString(R.string.four_title_one),
                getString(R.string.four_title_two),
                getString(R.string.four_title_three),
                getString(R.string.four_title_four),
                getString(R.string.four_title_fourpointfive),
                getString(R.string.four_title_five),
                getString(R.string.four_title_six),
                getString(R.string.four_title_seven),
                getString(R.string.four_title_eight),
                getString(R.string.four_title_nine),
                getString(R.string.four_title_ten),
                getString(R.string.four_title_eleven),
                getString(R.string.four_title_twelve),
                getString(R.string.four_title_thirteen),
                getString(R.string.four_title_fourteen),
                getString(R.string.four_title_fifteen),
                getString(R.string.four_title_sixteen),
                getString(R.string.four_title_seventeen),
                getString(R.string.four_title_eighteen),
                getString(R.string.four_title_nineteen),
                getString(R.string.four_title_twenty),
                getString(R.string.four_title_twentyone),
                getString(R.string.four_title_twentytwo)
        };

        int[] imageArray = new int[]{
                R.drawable.redrock,
                R.drawable.brothers,
                R.drawable.barlouie,
                R.drawable.uglys,
                R.drawable.loadedslate,
                R.drawable.pubclub,
                R.drawable.ogbh,
                R.drawable.evolution,
                R.drawable.hihat,
                R.drawable.jacks,
                R.drawable.taylors,
                R.drawable.badgenie,
                R.drawable.plum,
                R.drawable.flannerys,
                R.drawable.whiskeybar,
                R.drawable.vontrier,
                R.drawable.vituccis,
                R.drawable.gdaddys,
                R.drawable.rosatis,
                R.drawable.alehouse,
                R.drawable.lacage,
                R.drawable.stenys,
                R.drawable.fluid
        };

        String[] addrStrings= new String[]{
                getString(R.string.four_addr_one),
                getString(R.string.four_addr_two),
                getString(R.string.four_addr_three),
                getString(R.string.four_addr_four),
                getString(R.string.four_addr_fourpointfive),
                getString(R.string.four_addr_five),
                getString(R.string.four_addr_six),
                getString(R.string.four_addr_seven),
                getString(R.string.four_addr_eight),
                getString(R.string.four_addr_nine),
                getString(R.string.four_addr_ten),
                getString(R.string.four_addr_eleven),
                getString(R.string.four_addr_twelve),
                getString(R.string.four_addr_thirteen),
                getString(R.string.four_addr_fourteen),
                getString(R.string.four_addr_fifteen),
                getString(R.string.four_addr_sixteen),
                getString(R.string.four_addr_seventeen),
                getString(R.string.four_addr_eighteen),
                getString(R.string.four_addr_nineteen),
                getString(R.string.four_addr_twenty),
                getString(R.string.four_addr_twentyone),
                getString(R.string.four_addr_twentytwo)
        };

        String[] coordStrings= new String[]{
                getString(R.string.four_coords_one),
                getString(R.string.four_coords_two),
                getString(R.string.four_coords_three),
                getString(R.string.four_coords_four),
                getString(R.string.four_coords_fourpointfive),
                getString(R.string.four_coords_five),
                getString(R.string.four_coords_six),
                getString(R.string.four_coords_seven),
                getString(R.string.four_coords_eight),
                getString(R.string.four_coords_nine),
                getString(R.string.four_coords_ten),
                getString(R.string.four_coords_eleven),
                getString(R.string.four_coords_twelve),
                getString(R.string.four_coords_thirteen),
                getString(R.string.four_coords_fourteen),
                getString(R.string.four_coords_fifteen),
                getString(R.string.four_coords_sixteen),
                getString(R.string.four_coords_seventeen),
                getString(R.string.four_coords_eighteen),
                getString(R.string.four_coords_nineteen),
                getString(R.string.four_coords_twenty),
                getString(R.string.four_coords_twentyone),
                getString(R.string.four_coords_twentytwo)
        };


        String[] webAddrStrings= new String[]{
                getString(R.string.four_web_one),
                getString(R.string.four_web_two),
                getString(R.string.four_web_three),
                getString(R.string.four_web_four),
                getString(R.string.four_web_fourpointfive),
                getString(R.string.four_web_five),
                getString(R.string.four_web_six),
                getString(R.string.four_web_seven),
                getString(R.string.four_web_eight),
                getString(R.string.four_web_nine),
                getString(R.string.four_web_ten),
                getString(R.string.four_web_eleven),
                getString(R.string.four_web_twelve),
                getString(R.string.four_web_thirteen),
                getString(R.string.four_web_fourteen),
                getString(R.string.four_web_fifteen),
                getString(R.string.four_web_sixteen),
                getString(R.string.four_web_seventeen),
                getString(R.string.four_web_eighteen),
                getString(R.string.four_web_nineteen),
                getString(R.string.four_web_twenty),
                getString(R.string.four_web_twentyone),
                getString(R.string.four_web_twentytwo)
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
