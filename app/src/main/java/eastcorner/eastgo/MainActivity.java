package eastcorner.eastgo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;

public class MainActivity extends AppCompatActivity {

    private final int DEFAULT_NAVIGATION = 0;

    private AHBottomNavigation mBottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBottomNavigation = (AHBottomNavigation) findViewById(R.id.bottom_navigation);

        init();
    }

    private void init() {
        //Bottom Setup Navigation Setup
        createBottomNavigationItems();
        setDefaultPositionBottomNavigation(DEFAULT_NAVIGATION);
        setColorAccentBottomNavigation(Color.parseColor(getString(R.color.colorPrimary)));
        setAlwaysFixedAtBottom(false);
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
}
