package com.example.noteapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.noteapp.Data.Data;
import com.example.noteapp.domain.Note;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements Drawer {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);

        initDrawer();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainerView, new ListFragment())
                .commit();

        Data.getInstance().add(new Note("Title1", "Text1"));
        Data.getInstance().add(new Note("Title2", "Text2"));
        Data.getInstance().add(new Note("Title3", "Text3"));
        Data.getInstance().add(new Note("Title4", "Text4"));
    }

    private void initDrawer() {

        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.menu_add:
                        openAddFragment();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        return true;
                    case R.id.menu_sort:
                        Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        return true;
                }
                return false;
            }
        });
    }

    @Override
    public void setToolbar(Toolbar toolbar) {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,
                drawerLayout,
                toolbar,
                R.string.drawer_open,
                R.string.drawer_close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    private void openAddFragment() {
        getSupportFragmentManager().beginTransaction()
                .addToBackStack("")
                .replace(R.id.fragmentContainerView, new AddNoteFragment())
                .commit();
    }


}