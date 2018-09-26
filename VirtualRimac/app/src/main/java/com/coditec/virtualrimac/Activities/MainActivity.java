package com.coditec.virtualrimac.Activities;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.coditec.virtualrimac.Fragments.HomeFragment;
import com.coditec.virtualrimac.Fragments.PlaceListFragment;
import com.coditec.virtualrimac.Fragments.RestaurantsListFragment;
import com.coditec.virtualrimac.Fragments.SongListFragment;
import com.coditec.virtualrimac.Fragments.ToursFragment;
import com.coditec.virtualrimac.Fragments.botVR;
import com.coditec.virtualrimac.Fragments.destinosFragment;
import com.coditec.virtualrimac.Fragments.historiaFragment;
import com.coditec.virtualrimac.IquitosVirtual;
import com.coditec.virtualrimac.R;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        cargarFramento(new HomeFragment());
        navigationView.getMenu().getItem(0).setChecked(true);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {

            new AlertDialog.Builder(this)
                    .setTitle("¿Deseas salir de la aplicación?")
                    .setMessage("Virtual Rimac te va a extrañar!")
                    .setNegativeButton("No", null).setPositiveButton("Si", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    MainActivity.super.finishAffinity();
                }
            }).create().show();

            super.finishAffinity();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            //Iquitos virtual
            cargarFramento(new IquitosVirtual());
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
            cargarFramento(new HomeFragment());
        } else if (id == R.id.nav_rutas) {
            cargarFramento(new PlaceListFragment());
        } else if (id == R.id.nav_destinos) {
            cargarFramento(new destinosFragment());
        } else if (id == R.id.nav_canciones) {
            cargarFramento(new SongListFragment());
        } else if (id == R.id.nav_gastronomia) {
            cargarFramento(new RestaurantsListFragment());
        } else if (id == R.id.nav_bot) {
            cargarFramento(new botVR());
        }else if (id == R.id.nav_tours) {
            cargarFramento(new ToursFragment());
        }else if (id == R.id.nav_history) {
            cargarFramento(new historiaFragment());
        }

        getSupportActionBar().setTitle(item.getTitle());

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void cargarFramento(Fragment fragment){
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.containerFrag,fragment).addToBackStack(null).commit();
    }
}
