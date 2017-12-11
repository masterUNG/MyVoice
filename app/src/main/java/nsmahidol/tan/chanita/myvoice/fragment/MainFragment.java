package nsmahidol.tan.chanita.myvoice.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import nsmahidol.tan.chanita.myvoice.MainActivity;
import nsmahidol.tan.chanita.myvoice.R;

/**
 * Created by ADMIN on 12/8/2560.
 */

public class MainFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        return  view;
    } // omCreateView

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        Create Toolbar
        createToolbar();


//        เริ่มใช้งาน
        icon1Controller();

//      คู่มือการใช้งาน
        tutorialController();

//        กิตติกรรมประกาศ
        icon3Controller();

//        ประเมินความพึงพอใจ
        icon4Controller();

//        ออกจากแอพพลิเคชัน
        exitController();

    } // onActivityCreate

    private void createToolbar() {
        Toolbar toolbar = getView().findViewById(R.id.toolbarMain);
        ((MainActivity)getActivity()).setSupportActionBar(toolbar);

        ((MainActivity) getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
        ((MainActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationIcon(R.drawable.ic_action_home);

        ((MainActivity) getActivity()).getSupportActionBar().setTitle(getString(R.string.title_main));

    }

    private void icon4Controller() {
        ImageView imageView = getView().findViewById(R.id.imvicon4);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void icon3Controller() {
        ImageView imageView = getView().findViewById(R.id.imvIcon3);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void exitController() {
        ImageView imageView = getView().findViewById(R.id.imvIcon5);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
            }
        });
    }

    private void tutorialController() {
        ImageView imageView = getView().findViewById(R.id.imvIcon2);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



            } //onClick
        });
    }

    private void icon1Controller() {
        ImageView imageView = getView().findViewById(R.id.imvIcon1);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Show Dialog
                CharSequence[] charSequences = new CharSequence[]{"เพศชาย", "เพศหญิง"};
                final int[] intGender = {0};


                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setCancelable(false);
                builder.setIcon(R.mipmap.ic_alert);
                builder.setTitle(R.string.chose_gender);
                builder.setSingleChoiceItems(charSequences, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        intGender[0] = i;

                        Log.d("30SepV1", "เพศที่เลือก ==> " + intGender[0]);
                        saveGender(intGender[0]);

                        getActivity().getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.myContent, ServiceFragment.serviceInstance(intGender[0]))
                                .commit();
                        dialogInterface.dismiss();
                    }
                });
                builder.show();



            } //onClick
        });
    }

    private void saveGender(int intGender) {

        SharedPreferences sharedPreferences = getActivity()
                .getSharedPreferences("MyVoice", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("Gender", intGender);
        editor.commit();

    }
} // Main Class
