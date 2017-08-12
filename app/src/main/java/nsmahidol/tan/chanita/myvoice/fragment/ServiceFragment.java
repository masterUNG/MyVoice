package nsmahidol.tan.chanita.myvoice.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import nsmahidol.tan.chanita.myvoice.R;

/**
 * Created by masterung on 8/12/2017 AD.
 */

public class ServiceFragment extends Fragment{

    private ImageView backImageView, genderImageView;
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
    }   // onCreateView

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //Initial View
        initialView();

        //Get Integer From MainFragment
        getInteger();

        //Show Gender
        showGender();

        //Back Controller
        backController();

        //Gender Controller
        genderController();


    }   // onActivityCreate

    private void genderController() {
        genderImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (genderAnInt == 0) {
                    genderAnInt = 1;
                    showGender();
                } else if (genderAnInt == 1) {
                    genderAnInt = 0;
                    showGender();
                }

            }
        });
    }

    private void backController() {
        backImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager()
                        .popBackStack();
            }
        });
    }

    private void showGender() {
        genderImageView.setImageResource(genderInts[genderAnInt]);
    }

    private void getInteger() {
        genderAnInt = getArguments().getInt("Gender");
    }

    private void initialView() {
        backImageView = getView().findViewById(R.id.imvBack);
        genderImageView = getView().findViewById(R.id.imvGender);
    }

}   // Class