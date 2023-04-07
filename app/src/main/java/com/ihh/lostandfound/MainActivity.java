package com.ihh.lostandfound;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ihh.lostandfound.fragment.FindFragment;
import com.ihh.lostandfound.fragment.LostFragment;
import com.ihh.lostandfound.fragment.MyFragment;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottom_navigation);



        fragmentSetting();

    }

    private void fragmentSetting() {
        //시작을 lostFragment로
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new LostFragment()).commit();

         BottomNavigationView.OnNavigationItemSelectedListener navListener =
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment selectedFragment = null;

                        switch (item.getItemId()) {
                            case R.id.navigation_lost:
                                selectedFragment = new LostFragment();
                                break;
                            case R.id.navigation_find:
                                selectedFragment = new FindFragment();
                                break;
                            case R.id.navigation_my:
                                selectedFragment = new MyFragment();
                                break;
                        }

                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                selectedFragment).commit();

                        return true;

                    }
                };
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
    }
}
