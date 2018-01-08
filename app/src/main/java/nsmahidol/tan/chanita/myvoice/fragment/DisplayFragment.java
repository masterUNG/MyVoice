package nsmahidol.tan.chanita.myvoice.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import nsmahidol.tan.chanita.myvoice.MainActivity;
import nsmahidol.tan.chanita.myvoice.R;

/**
 * Created by masterung on 30/9/2017 AD.
 */

public class DisplayFragment extends Fragment {

    //    Explicit
    private String detailString;
    private String tag = "8JanV1";
    private int genderAnInt = 0;

    public static DisplayFragment displayInstance(String detailString) {

        DisplayFragment displayFragment = new DisplayFragment();
        Bundle bundle = new Bundle();
        bundle.putString("Detail", detailString);
        displayFragment.setArguments(bundle);

        return displayFragment;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        Setup Contant
        setupContant();

//        Create Toolbal
        createToolbal();




//        Create ExtraFragment
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.contentExtraFragment, new FoodWaterFragment())
                .commit();


    }   // Main Method



    private void setupContant() {

        detailString = getArguments().getString("Detail");
        Log.d(tag, "detailString ==> " + detailString);

        SharedPreferences sharedPreferences = getActivity()
                .getSharedPreferences("MyVoice", Context.MODE_PRIVATE);
        genderAnInt = sharedPreferences.getInt("Gender", 0);


    }

    private void createToolbal() {
        Toolbar toolbar = getView().findViewById(R.id.toolbarDetail);
        ((MainActivity) getActivity()).setSupportActionBar(toolbar);
        ((MainActivity) getActivity()).getSupportActionBar().setTitle(detailString);

        ((MainActivity) getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
        ((MainActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().popBackStack();

            }
        });

//        Show Gender
        ImageView imageView = getView().findViewById(R.id.imvGender);
        if (genderAnInt == 1) {
            imageView.setImageResource(R.drawable.girl);
        }


    }   // create Toolbar

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        return view;
    }


}   // Main class
