package com.example.dotslash;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private ActionBar toolbar;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {

                case R.id.navigation_home:
                    toolbar.setTitle("Compose");
                    fragment=new Compose();
                    loadFragment(fragment);
                    mTextMessage.setText(R.string.title_compose);
                    return true;
                case R.id.navigation_dashboard:
                    toolbar.setTitle("Messages");
                    fragment=new Messages();
                    loadFragment(fragment);
                    mTextMessage.setText(R.string.title_messages);
                    return true;
                case R.id.navigation_notifications:
                    toolbar.setTitle("Profile");
                    fragment=new Profile();
                    loadFragment(fragment);
                    mTextMessage.setText(R.string.title_profile);
                    return true;
            }
            return false;
        }
    };

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    toolbar=getSupportActionBar();
        toolbar.setTitle("Compose");


        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
