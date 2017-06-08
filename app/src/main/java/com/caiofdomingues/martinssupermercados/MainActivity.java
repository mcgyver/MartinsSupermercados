package com.caiofdomingues.martinssupermercados;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.support.v7.widget.Toolbar;
import android.support.v7.app.ActionBarDrawerToggle;

public class MainActivity extends AppCompatActivity {

    private EditText sobre;

    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
    }

    private void findViews() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        //set up navigation drawer
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);

        navigationView = (NavigationView) findViewById(R.id.navigation_view);

        //is in findView instead of setActions because the
        //other views use this
        initNavigationDrawer();

    }


    // Initialize and add Listener to NavigationDrawer
    public void initNavigationDrawer(){


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

                int id = item.getItemId();

                switch (id){
                    case R.id.nav_home:
                        drawerLayout.closeDrawers();
                        Intent intent = new Intent(MainActivity.this, MainActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.gallery:
                        drawerLayout.closeDrawers();
                        Intent intentgal = new Intent(MainActivity.this, GaleriaActivity.class);
                        startActivity(intentgal);
                        break;
                    case R.id.cart:
                        drawerLayout.closeDrawers();
                        Intent intentcart = new Intent(MainActivity.this, CartActivity.class);
                        startActivity(intentcart);
                        break;
                    case R.id.contacts:
                        drawerLayout.closeDrawers();
                        Intent intentcontacts = new Intent(MainActivity.this, ContactsActivity.class);
                        startActivity(intentcontacts);
                        break;
                    case R.id.location:
                        drawerLayout.closeDrawers();
                        Intent intentlocal = new Intent(MainActivity.this, MapsActivity.class);
                        startActivity(intentlocal);
                        break;
                    case R.id.about_app:
                        drawerLayout.closeDrawers();
                        Intent intentaboutapp = new Intent(MainActivity.this, SobreAppActivity.class);
                        startActivity(intentaboutapp);
                        break;
                    case R.id.nav_exit:
                        finish();
                        drawerLayout.closeDrawers();
                        break;
                }
                return false;
            }
        });


        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout, toolbar, 0,  0){
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

}
