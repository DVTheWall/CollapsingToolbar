package com.peacock.collapsingtoolbar;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    DrawerLayout drawerLayout;
    CollapsingToolbarLayout collapsingToolbarLayout;
    Toolbar toolbar;
    TabLayout tabLayout;
    FloatingActionButton fab_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab_button = (FloatingActionButton) findViewById(R.id.fab);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }

        // Show menu icon
        final ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_menu_48px);
        ab.setDisplayHomeAsUpEnabled(true);


        if (tabLayout == null) {
            return;
        }

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.addTab(tabLayout.newTab().setText("Tab 1"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 2"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 3"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 4"));

        setupCollapsingToolbarLayout();

        if (fab_button != null)
            fab_button.setOnClickListener(this);

    }


    private void setupCollapsingToolbarLayout() {

        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);

        if (collapsingToolbarLayout != null) {
            collapsingToolbarLayout.setTitle(toolbar.getTitle());
            collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.ExpandedAppBar);
            collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapsedAppBar);
            //collapsingToolbarLayout.setCollapsedTitleTextColor(0xED1C24);
            //collapsingToolbarLayout.setExpandedTitleColor(0xED1C24);
        }
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.fab) {

            Snackbar
                    .make(findViewById(R.id.coordinatorLayout), "This is Snackbar", Snackbar.LENGTH_LONG)
                    .setAction("Action", this)
                    .show(); // Don’t forget to show!
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.action_find_location:

                Toast.makeText(this, "Location selected", Toast.LENGTH_SHORT).show();
                break;
            // action with ID action_settings was selected
            case R.id.action_settings:

                Toast.makeText(this, "Settings selected", Toast.LENGTH_SHORT).show();
                break;
            case android.R.id.home:

                if (drawerLayout != null)
                    drawerLayout.openDrawer(GravityCompat.START);

                Toast.makeText(this, "NavigationBar  selected", Toast.LENGTH_SHORT).show();

                return true;

            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}
