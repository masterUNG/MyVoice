package nsmahidol.tan.chanita.myvoice.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import nsmahidol.tan.chanita.myvoice.MainActivity;
import nsmahidol.tan.chanita.myvoice.R;
import nsmahidol.tan.chanita.myvoice.ultility.MyConstant;

/**
 * Created by masterung on 30/9/2017 AD.
 */

public class RequestFragment extends Fragment{

    //Explicit
    private int genderAnInt;

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


    }

    private void createListView() {
        ListView listView = getView().findViewById(R.id.listviewRequest);
        MyConstant myConstant = new MyConstant();
        String[] strings = myConstant.getRequestStrings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                strings
        );
        listView.setAdapter(stringArrayAdapter);
    }

    private void setupGender() {
        SharedPreferences sharedPreferences = getActivity()
                .getSharedPreferences("MyVoice", Context.MODE_PRIVATE);
        genderAnInt = sharedPreferences.getInt("Gender", 0);
    }

    private void toolbarController() {
        Toolbar toolbar = getView().findViewById(R.id.toolbarRequest);
        ((MainActivity) getActivity()).setSupportActionBar(toolbar);
        ((MainActivity)getActivity()).getSupportActionBar()
                .setTitle(getResources().getString(R.string.label6));

        ((MainActivity)getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
        ((MainActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationIcon(R.mipmap.ic_back);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });

        //Setup Image Gender
        ImageView imageView = getView().findViewById(R.id.imvGender);
        int[] ints = new int[]{R.drawable.boy, R.drawable.girl};
        imageView.setImageResource(ints[genderAnInt]);




    }
}   // Main Class
