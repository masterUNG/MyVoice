package nsmahidol.tan.chanita.myvoice.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import nsmahidol.tan.chanita.myvoice.R;

/**
 * Created by ADMIN on 12/8/2560.
 */

public class ServiceFragment extends Fragment{

    private ImageView backImageView, genderImgeView;
    private int[] genderInts = new int[]{R.drawable.boy, R.drawable.girl};
    private int genderAnInt = 0;

    public static ServiceFragment serviceInstance(int intGender) {

        ServiceFragment serviceFragment = new ServiceFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("Gender", intGender);
        serviceFragment.setArguments(bundle);

        return serviceFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_service, container, false);
        return view;
    } //onCreateview

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //Initial View
        initialView();

        //Get Integer From MainFragment
        getinteger();

        //Show Gender
        showGender();

    } //onActivityCreate

    private void showGender() {
        genderImgeView.setImageResource(genderInts[genderAnInt]);
    }

    private void getinteger() {
        genderAnInt = getArguments().getInt("Gender");
    }

    private void initialView() {
        backImageView = getView().findViewById(R.id.imvBack);
        genderImgeView = getView().findViewById(R.id.imvGender);
    }
} // Class
