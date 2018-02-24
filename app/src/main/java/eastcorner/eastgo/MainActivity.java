package eastcorner.eastgo;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;

import eastcorner.eastgo.fragment.HomeFragment;
import eastcorner.eastgo.fragment.MyAccountFragment;
import eastcorner.eastgo.fragment.OrdersFragment;

public class MainActivity extends AppCompatActivity implements AHBottomNavigation.OnTabSelectedListener {

    private final int DEFAULT_NAVIGATION = 0;

    private AHBottomNavigation mBottomNavigation;

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();

        mBottomNavigation = (AHBottomNavigation) findViewById(R.id.bottom_navigation);

        init();
    }

    private void init() {
        //Init Main Fragment
        fragmentManager.beginTransaction().add(R.id.main_frame_layout, new HomeFragment()).commit();

        //Bottom Setup Navigation Setup
        createBottomNavigationItems();
        setDefaultPositionBottomNavigation(DEFAULT_NAVIGATION);
        setColorAccentBottomNavigation(Color.parseColor(getString(R.color.colorPrimary)));
        setAlwaysFixedAtBottom(false);

        mBottomNavigation.setOnTabSelectedListener(this);
    }

    private void createBottomNavigationItems() {
        AHBottomNavigationItem mHome = new AHBottomNavigationItem(getString(R.string.home_navigation), R.drawable.ic_home_navigation);
        AHBottomNavigationItem mOrders = new AHBottomNavigationItem(getString(R.string.orders_nagivation), R.drawable.ic_orders_navigation);
        AHBottomNavigationItem mAccount = new AHBottomNavigationItem(getString(R.string.account_navigation), R.drawable.ic_account_navigation);

        mBottomNavigation.addItem(mHome);
        mBottomNavigation.addItem(mOrders);
        mBottomNavigation.addItem(mAccount);
    }


    private void setDefaultPositionBottomNavigation(int default_navigation) {
        mBottomNavigation.setDefaultBackgroundColor(default_navigation);
    }

    private void setColorAccentBottomNavigation(int color) {
        mBottomNavigation.setAccentColor(color);
    }


    private void setAlwaysFixedAtBottom(boolean b) {
        mBottomNavigation.setTranslucentNavigationEnabled(b);
    }

    @Override
    public boolean onTabSelected(int position, boolean wasSelected) {
        Log.d("AHBottomNavigation", "Position: " + position + " | wasSelected: " + wasSelected);

        // No need to refresh if selected
        if (wasSelected)
            return true;

        Fragment fragment;
        String tagFragment;

        switch (position) {
            case 1:
                fragment = new OrdersFragment();
                tagFragment = "orders_fragment";
                break;
            case 2:
                fragment = new MyAccountFragment();
                tagFragment = "account_fragment";
                break;
            default:
                fragment = new HomeFragment();
                tagFragment = "home_fragment";
                break;
        }

        fragmentManager.beginTransaction().replace(R.id.main_frame_layout, fragment, tagFragment).commit();
        return true;
    }
}
