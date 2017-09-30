package nsmahidol.tan.chanita.myvoice.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
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
    private int genderAnInt = 0, myVoiceGenderAnInt;    // 0 ==> Male, 1 ==> Female


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

        //Get Value From Preference
        getGenderFromPreference();

        //Show Gender
        showGender();

        //Back Controller
        backController();

        //Gender Controller
        //genderController();

        //Request Controller
        requestController();

        //Feeling Controller

        //Question Controller

        //Emergency Controller


    }   // onActivityCreate

    private void requestController() {
        ImageView imageView = getView().findViewById(R.id.imvIcon1);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.myContent, new RequestFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

    private void getGenderFromPreference() {
        SharedPreferences sharedPreferences = getActivity()
                .getSharedPreferences("MyVoice", Context.MODE_PRIVATE);
        myVoiceGenderAnInt = sharedPreferences.getInt("Gender", 0);
        Log.d("30SepV1", "ค่าที่รับได้จาก Preference ==> " + myVoiceGenderAnInt);
    }

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