package com.company.mynotes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.company.mynotes.fragment.NotesFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity
        extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private FragmentBackStack fragmentBackStack;

    private ActionBar actionBar;
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();

        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        drawer = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
        );

        drawer.addDrawerListener(toggle);
        toggle.syncState();

        fragmentBackStack = new FragmentBackStack(getSupportFragmentManager(), R.id.fl_content);
        fragmentBackStack.replace(new NotesFragment());
    }

    void toolbar(String title) {
        if (actionBar != null) {
            actionBar.setTitle(title);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int id = menuItem.getItemId();

        Log.i("tag", "options");

        switch (id) {
            case android.R.id.home:
                super.onBackPressed();
                break;
        }

        return super.onOptionsItemSelected(menuItem);
    }

    FragmentBackStack getFragmentStack() {
        return fragmentBackStack;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
