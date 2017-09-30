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

public class RequestFragment extends Fragment{

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

        //Toolbar Controller
        toolbarController();


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




    }
}   // Main Class
