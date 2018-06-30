package com.task1;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;
import android.widget.Toolbar;

import static android.view.View.INVISIBLE;

public class MainActivity extends AppCompatActivity  {

    private DrawerLayout mdrawer;
    private ActionBarDrawerToggle toggle;
    private NavigationView nv;
    private ProfileFragment profileFragment;
    private SettingsFragment settingsFragment;
    private ResetFragment resetFragment;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mdrawer = findViewById(R.id.drawerLayout);
        android.support.v7.widget.Toolbar toolbar=findViewById(R.id.toolbar4);
        toggle=new ActionBarDrawerToggle(this,mdrawer,toolbar,R.string.open,R.string.close);
        mdrawer.addDrawerListener(toggle);
        toggle.syncState();

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        profileFragment = new ProfileFragment();
        settingsFragment = new SettingsFragment();
        resetFragment = new ResetFragment();


        setFragment(profileFragment);


        nv = findViewById(R.id.navigationView);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.profile:
                        setFragment(profileFragment);
                        mdrawer.closeDrawers();
                        return true;
                    case R.id.settings:
                        setFragment(settingsFragment);
                        mdrawer.closeDrawers();
                        return true;
                    case R.id.reset:
                        setFragment(resetFragment);
                        mdrawer.closeDrawers();
                        return true;
                    default:
                        return false;

                }
            }
        });



    }
    public void setFragment(Fragment fragment){
   FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
   fragmentTransaction.replace(R.id.frame_layout,fragment);
   fragmentTransaction.commit();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(toggle.onOptionsItemSelected(item)){
            return  true;
        }
        return super.onOptionsItemSelected(item);
    }

}
