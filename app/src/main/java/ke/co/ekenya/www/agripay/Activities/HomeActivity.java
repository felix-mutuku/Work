package ke.co.ekenya.www.agripay.Activities;

import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import ke.co.ekenya.www.agripay.Fragments.DashboardFragment;
import ke.co.ekenya.www.agripay.Fragments.ShopFragment;
import ke.co.ekenya.www.agripay.Fragments.WalletFragment;
import ke.co.ekenya.www.agripay.Helper.BottomNavigationViewBehaviour;
import ke.co.ekenya.www.agripay.Helper.BottomNavigationViewHelper;
import ke.co.ekenya.www.agripay.R;

public class HomeActivity extends AppCompatActivity {
    TextView home_highlight, text_wallet, text_dashboard;
    ImageView text_wallet_highlight, text_dashboard_highlight, top_background, center_background;
    LinearLayout linear_wallet_dashboard;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_wallet:
                    initialize();
                    return true;

                case R.id.navigation_shop:
                    initializeViewsDisappear();
                    ShopFragment fragmentS = new ShopFragment();
                    android.support.v4.app.FragmentTransaction fragmentTransactionS = getSupportFragmentManager().beginTransaction();
                    fragmentTransactionS.replace(R.id.content, fragmentS);
                    fragmentTransactionS.commit();
                    return true;

                case R.id.navigation_transactions:
                    //MyAdsFragment fragment2 = new MyAdsFragment();
                    //android.support.v4.app.FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                    // fragmentTransaction2.replace(R.id.Content, fragment2);
                    // fragmentTransaction2.commit();
                    return true;

                case R.id.navigation_settings:
                    // ProfileFragment fragment3 = new ProfileFragment();
                    //android.support.v4.app.FragmentTransaction fragmentTransaction3 = getSupportFragmentManager().beginTransaction();
                    //fragmentTransaction3.replace(R.id.Content, fragment3);
                    //fragmentTransaction3.commit();
                    return true;

            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        home_highlight = findViewById(R.id.home_highlight);
        text_wallet = findViewById(R.id.text_wallet);
        text_dashboard = findViewById(R.id.text_dashboard);
        text_wallet_highlight = findViewById(R.id.text_wallet_highlight);
        text_dashboard_highlight = findViewById(R.id.text_dashboard_highlight);
        top_background = findViewById(R.id.top_background);
        center_background = findViewById(R.id.center_background);
        linear_wallet_dashboard = findViewById(R.id.linear_wallet_dashboard);

        BottomNavigationView navigation = findViewById(R.id.bottom_navigation);
        BottomNavigationViewHelper.removeShiftMode(navigation);

        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) navigation.getLayoutParams();
        layoutParams.setBehavior(new BottomNavigationViewBehaviour());

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        initialize();

        text_wallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initialize();
            }
        });

        text_dashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initializeDashboard();
            }
        });

    }

    private void initializeDashboard() {
        DashboardFragment fragmentD = new DashboardFragment();
        android.support.v4.app.FragmentTransaction fragmentTransactionD = getSupportFragmentManager().beginTransaction();
        fragmentTransactionD.replace(R.id.content, fragmentD);
        fragmentTransactionD.commit();

        Typeface ubuntu_light = Typeface.createFromAsset(getAssets(), "fonts/ubuntu_light.ttf");
        Typeface ubuntu_medium = Typeface.createFromAsset(getAssets(), "fonts/ubuntu_medium.ttf");

        home_highlight.setText("Dashboard");
        text_wallet.setTypeface(ubuntu_light);
        text_wallet_highlight.setVisibility(View.INVISIBLE);

        text_dashboard.setTypeface(ubuntu_medium);
        text_dashboard_highlight.setVisibility(View.VISIBLE);
    }

    private void initialize() {
        WalletFragment fragmentW = new WalletFragment();
        android.support.v4.app.FragmentTransaction fragmentTransactionW = getSupportFragmentManager().beginTransaction();
        fragmentTransactionW.replace(R.id.content, fragmentW);
        fragmentTransactionW.commit();

        Typeface ubuntu_light = Typeface.createFromAsset(getAssets(), "fonts/ubuntu_light.ttf");
        Typeface ubuntu_medium = Typeface.createFromAsset(getAssets(), "fonts/ubuntu_medium.ttf");

        home_highlight.setText("Wallet");
        text_wallet.setTypeface(ubuntu_medium);
        text_wallet_highlight.setVisibility(View.VISIBLE);

        text_dashboard.setTypeface(ubuntu_light);
        text_dashboard_highlight.setVisibility(View.INVISIBLE);

        initializeViewsAppear();
    }

    private void initializeViewsAppear() {
        linear_wallet_dashboard.setVisibility(View.VISIBLE);
        home_highlight.setVisibility(View.VISIBLE);
        center_background.setVisibility(View.VISIBLE);
        top_background.setVisibility(View.VISIBLE);
    }

    private void initializeViewsDisappear() {
        linear_wallet_dashboard.setVisibility(View.GONE);
        home_highlight.setVisibility(View.GONE);
        center_background.setVisibility(View.GONE);
        top_background.setVisibility(View.GONE);
    }
}
