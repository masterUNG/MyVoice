package nsmahidol.tan.chanita.myvoice.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
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

//        ChoosedImage Controller
        chooseImageController();

    }    // onActivity

    private void chooseImageController() {

        final int[] drinkInts = new int[]{R.drawable.drink_boy, R.drawable.drink_girl};
        final int[] eatInts = new int[]{R.drawable.eat_boy, R.drawable.eat_girl};
        final int[] choosedInts = new int[]{R.drawable.drink_boy};

        final int[] soundDrinkInts = new int[]{R.raw.drink_boy, R.raw.drink_girl};
        final int[] soundEatInts = new int[]{R.raw.eat_boy, R.raw.eat_girl};
        final int[] choosedSoundInts = new int[]{R.raw.drink_boy};

        drinkImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choosedInts[0] = drinkInts[genderAnInt];
                choosedSoundInts[0] = soundDrinkInts[genderAnInt];
                showChoose(choosedInts[0], choosedSoundInts[0]);
            }
        });

        eatImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choosedInts[0] = eatInts[genderAnInt];
                choosedSoundInts[0] = soundEatInts[genderAnInt];
                showChoose(choosedInts[0], choosedSoundInts[0]);
            }
        });

    }   // chooseImage

    private void showChoose(int choosedInt, int soundChoosedInt) {

        ImageView imageView = getView().findViewById(R.id.imvChoosed);
        imageView.setImageResource(choosedInt);
        imageView.setVisibility(View.VISIBLE);

        MediaPlayer mediaPlayer = MediaPlayer.create(getActivity(), soundChoosedInt);
        mediaPlayer.start();

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.release();
            }
        });

    }

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
