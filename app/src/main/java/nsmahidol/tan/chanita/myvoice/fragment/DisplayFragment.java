package nsmahidol.tan.chanita.myvoice.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nsmahidol.tan.chanita.myvoice.MainActivity;
import nsmahidol.tan.chanita.myvoice.R;

/**
 * Created by masterung on 30/9/2017 AD.
 */

public class DisplayFragment extends Fragment{

    //    Explicit
    private String detailString;

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

        detailString = getArguments().getString("Detail");

//        Create Toolbal
        createToolbal();


    }   // Main Method

    private void createToolbal() {
        Toolbar toolbar = getView().findViewById(R.id.toolbarDetail);
        ((MainActivity)getActivity()).setSupportActionBar(toolbar);
        ((MainActivity) getActivity()).getSupportActionBar().setTitle(detailString);

        ((MainActivity) getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
        ((MainActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().popBackStack();


            }
        });


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        return view;
    }


}   // Main class
