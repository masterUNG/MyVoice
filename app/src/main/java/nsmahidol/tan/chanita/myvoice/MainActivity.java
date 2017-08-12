package nsmahidol.tan.chanita.myvoice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import nsmahidol.tan.chanita.myvoice.fragment.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Add Fragment to Activity
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.myContent, new MainFragment())
                    .commit();
        }

    } // Main method

} // Main Class
