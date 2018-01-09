package com.example.developerjohn.soka;


import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.developerjohn.soka.fragments.MatchFragment;
import com.example.developerjohn.soka.fragments.NewsFragment;
import com.example.developerjohn.soka.fragments.StatsFragment;
import com.example.developerjohn.soka.fragments.VideosFragment;


public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bottomNavigationView = findViewById(R.id.navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;
                switch (item.getItemId()) {
                    case R.id.news:
                        selectedFragment = NewsFragment.newInstance();
                        break;
                    case R.id.match:
                        selectedFragment = MatchFragment.newInstance();
                        break;
                    case R.id.videos:
                        selectedFragment = VideosFragment.newInstance();
                        break;
                    case R.id.stats:
                        selectedFragment = StatsFragment.newInstance();
                        break;
                }
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_layout, selectedFragment);
                transaction.commit();
                return true;
            }
        });
        //Manually displaying the first fragment - one time only
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, NewsFragment.newInstance());
        transaction.commit();
    }
}
