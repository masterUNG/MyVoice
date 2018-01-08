package nsmahidol.tan.chanita.myvoice.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import nsmahidol.tan.chanita.myvoice.R;

/**
 * Created by masterung on 8/1/2018 AD.
 */

public class FoodWaterFragment extends Fragment{

    private int genderAnInt = 0;
    private ImageView drinkImageView, eatImageView;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        Setup Constant
        setupConstant(savedInstanceState);

//        Show Image
        showImage();

    }    // onActivity

    private void showImage() {
        drinkImageView = getView().findViewById(R.id.imvDrink);
        eatImageView = getView().findViewById(R.id.imvEat);

        if (genderAnInt == 1) {
            drinkImageView.setImageResource(R.drawable.drink_girl);
            eatImageView.setImageResource(R.drawable.eat_girl);
        }
    }

    private void setupConstant(@Nullable Bundle savedInstanceState) {
        SharedPreferences sharedPreferences = getActivity()
                .getSharedPreferences("MyVoice", Context.MODE_PRIVATE);
        genderAnInt = sharedPreferences.getInt("Gender", 0);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_food_water, container, false);
        return view;
    }
}   // Main Class
