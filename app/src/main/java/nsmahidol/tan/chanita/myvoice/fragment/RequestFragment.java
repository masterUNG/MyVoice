package nsmahidol.tan.chanita.myvoice.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import nsmahidol.tan.chanita.myvoice.MainActivity;
import nsmahidol.tan.chanita.myvoice.R;
import nsmahidol.tan.chanita.myvoice.ultility.MyConstant;

/**
 * Created by masterung on 30/9/2017 AD.
 */

public class RequestFragment extends Fragment {

    //Explicit
    private int genderAnInt, titleIndex;
    private String[] titleStrings = new String[]{"ความต้องการ", "ความรู้สึก", "คำถาม", "เร่งด่วน"};
    private ImageView icon1ImageView, icon2ImageView, icon3ImageView, icon4ImageView;


    public static RequestFragment requestInstance(int index) {

        RequestFragment requestFragment = new RequestFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("Index", index);
        requestFragment.setArguments(bundle);
        return requestFragment;

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_request, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //Setup Gender
        setupGender();

        //Toolbar Controller
        toolbarController();

        //Create ListView
        createListView();

//        Image Controller
        imageController();
    }

    private void imageController() {
        icon1ImageView = getView().findViewById(R.id.imvIcon1);
        icon2ImageView = getView().findViewById(R.id.imvIcon2);
        icon3ImageView = getView().findViewById(R.id.imvIcon3);
        icon4ImageView = getView().findViewById(R.id.imvicon4);

        icon1ImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                titleIndex = 0;
                createListView();
                toolbarController();
            }
        });

        icon2ImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                titleIndex = 1;
                createListView();
                toolbarController();
            }
        });

        icon3ImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                titleIndex = 2;
                createListView();
                toolbarController();
            }
        });

        icon4ImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                titleIndex = 3;
                createListView();
                toolbarController();
            }
        });

    }


    private void createListView() {
        ListView listView = getView().findViewById(R.id.listviewRequest);
        final String[] strings = findStringArray();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                strings
        );
        listView.setAdapter(stringArrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                getActivity().getSupportFragmentManager()
                        .beginTransaction().replace(R.id.myContent, DisplayFragment.displayInstance(strings[i]))
                        .addToBackStack(null)
                        .commit();

            }
        });
    }

    private String[] findStringArray() {

        String[] strings = null;
        MyConstant myConstant = new MyConstant();
        switch (titleIndex) {
            case 0:
                strings = myConstant.getRequestStrings();
                break;
            case 1:
                strings = myConstant.getFeelingStrings();
                break;
            case 2:
                strings = myConstant.getQuestionStrings();
                break;
            case 3:
                strings = myConstant.getEmergencyStrings();
                break;

        }

        return strings;
    }

    private void setupGender() {
        SharedPreferences sharedPreferences = getActivity()
                .getSharedPreferences("MyVoice", Context.MODE_PRIVATE);
        genderAnInt = sharedPreferences.getInt("Gender", 0);

        titleIndex = getArguments().getInt("Index", 0);


    }

    private void toolbarController() {

        Toolbar toolbar = getView().findViewById(R.id.toolbarRequest);
        ((MainActivity) getActivity()).setSupportActionBar(toolbar);


        ((MainActivity) getActivity()).getSupportActionBar()
                .setTitle(titleStrings[titleIndex]);

        ((MainActivity) getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
        ((MainActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationIcon(R.drawable.ic_action_home);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.myContent, new MainFragment()).commit();
            }
        });

        //Setup Image Gender
        ImageView imageView = getView().findViewById(R.id.imvGender);
        int[] ints = new int[]{R.drawable.boy, R.drawable.girl};
        imageView.setImageResource(ints[genderAnInt]);


    }
}   // Main Class
