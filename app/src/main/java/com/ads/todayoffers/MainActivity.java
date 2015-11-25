package com.ads.todayoffers;


import android.graphics.Camera;
import android.graphics.Matrix;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

import drawer.AutoMobileFragment;
import drawer.DiagnosticFragment;
import drawer.FashionFragment;
import drawer.FinanceFragment;
import drawer.FoodnDiningFragment;
import drawer.HospitalsFragment;
import drawer.HotelsNResortsFragment;
import drawer.RealEstateFragment;
import drawer.SuperMarketsFragment;
import drawer.TravelFragment;


public class MainActivity extends AppCompatActivity implements SuperInterface {
    DrawerLayout mDrawerLayout;
    NavigationView mNavigationView;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;
    public static Bundle deatailsBundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        deatailsBundle = new Bundle();
        /**
         *Setup the DrawerLayout and NavigationView
         */

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mNavigationView = (NavigationView) findViewById(R.id.shitstuff);

        /**
         * Lets inflate the very first fragment
         * Here , we are inflating the TabFragment as the first Fragment
         */

        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.containerView, new TabFragment()).commit();
        /**
         * Setup click events on the Navigation View Items.
         */



        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                mDrawerLayout.closeDrawers();

                switch (menuItem.getItemId()) {
                    case R.id.nav_item_Fashion:
                        FragmentTransaction fragmentTransactionFashion = mFragmentManager.beginTransaction();
                        fragmentTransactionFashion.replace(R.id.containerView, new FashionFragment());
                        fragmentTransactionFashion.addToBackStack(null);
                        getSupportFragmentManager().popBackStack();
                        fragmentTransactionFashion.commit();
                        break;

                    case R.id.nav_item_Electronics:
                        FragmentTransaction fragmentTransactionEnt = mFragmentManager.beginTransaction();
                        fragmentTransactionEnt.replace(R.id.containerView, new EntertainmentFragment());
                        fragmentTransactionEnt.addToBackStack(null);
                        getSupportFragmentManager().popBackStack();
                        fragmentTransactionEnt.commit();
                        break;


                    case R.id.nav_item_Food_n_Dining:
                        FragmentTransaction fragmentTransactionFood = mFragmentManager.beginTransaction();
                        fragmentTransactionFood.replace(R.id.containerView, new FoodnDiningFragment());
                        fragmentTransactionFood.addToBackStack(null);
                        getSupportFragmentManager().popBackStack();
                        fragmentTransactionFood.commit();
                        break;


                    case R.id.nav_item_Travel:
                        FragmentTransaction fragmentTransactionTravel = mFragmentManager.beginTransaction();
                        fragmentTransactionTravel.replace(R.id.containerView, new TravelFragment());
                        fragmentTransactionTravel.addToBackStack(null);
                        getSupportFragmentManager().popBackStack();
                        fragmentTransactionTravel.commit();
                        break;


                    case R.id.nav_item_Hospitals:
                        FragmentTransaction fragmentTransactionHospital = mFragmentManager.beginTransaction();
                        fragmentTransactionHospital.replace(R.id.containerView, new HospitalsFragment());
                        fragmentTransactionHospital.addToBackStack(null);
                        getSupportFragmentManager().popBackStack();
                        fragmentTransactionHospital.commit();
                        break;
                    case R.id.nav_item_Diagnostics:
                        FragmentTransaction fragmentTransactionDiagnostics = mFragmentManager.beginTransaction();
                        fragmentTransactionDiagnostics.replace(R.id.containerView, new DiagnosticFragment());
                        fragmentTransactionDiagnostics.addToBackStack(null);
                        getSupportFragmentManager().popBackStack();
                        fragmentTransactionDiagnostics.commit();
                        break;

                    case R.id.nav_item_Hotels_n_Resorts:
                        FragmentTransaction fragmentTransactionHotels = mFragmentManager.beginTransaction();
                        fragmentTransactionHotels.replace(R.id.containerView, new HotelsNResortsFragment());
                        fragmentTransactionHotels.addToBackStack(null);
                        getSupportFragmentManager().popBackStack();
                        fragmentTransactionHotels.commit();
                        break;


                    case R.id.nav_item_Supermarkets:
                        FragmentTransaction fragmentTransactionSupermarkets = mFragmentManager.beginTransaction();
                        fragmentTransactionSupermarkets.replace(R.id.containerView, new SuperMarketsFragment());
                        fragmentTransactionSupermarkets.addToBackStack(null);
                        getSupportFragmentManager().popBackStack();
                        fragmentTransactionSupermarkets.commit();
                        break;


                    case R.id.nav_item_RealEstate:
                        FragmentTransaction fragmentTransactionRealEstate = mFragmentManager.beginTransaction();
                        fragmentTransactionRealEstate.replace(R.id.containerView, new RealEstateFragment());
                        fragmentTransactionRealEstate.addToBackStack(null);
                        getSupportFragmentManager().popBackStack();
                        fragmentTransactionRealEstate.commit();
                        break;


                    case R.id.nav_item_Finance:
                        FragmentTransaction fragmentTransactionFinance = mFragmentManager.beginTransaction();
                        fragmentTransactionFinance.replace(R.id.containerView, new FinanceFragment());
                        fragmentTransactionFinance.addToBackStack(null);
                        getSupportFragmentManager().popBackStack();
                        fragmentTransactionFinance.commit();
                        break;
                    case R.id.nav_item_AutoMobile:
                        FragmentTransaction fragmentTransactionAutoMobile = mFragmentManager.beginTransaction();
                        fragmentTransactionAutoMobile.replace(R.id.containerView, new AutoMobileFragment());
                        fragmentTransactionAutoMobile.addToBackStack(null);
                        getSupportFragmentManager().popBackStack();
                        fragmentTransactionAutoMobile.commit();
                        break;


                }


                /*if (menuItem.getItemId() == R.id.nav_item_Entertainment) {
                    FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.containerView, new EntertainmentFragment());
                    fragmentTransaction.addToBackStack(null);
                    getSupportFragmentManager().popBackStack();
                    fragmentTransaction.commit();


                }

                if (menuItem.getItemId() == R.id.nav_item_Fashion) {
                    FragmentTransaction xfragmentTransaction = mFragmentManager.beginTransaction();
                    xfragmentTransaction.replace(R.id.containerView, new TabFragment());
                    xfragmentTransaction.addToBackStack(null);
                    getSupportFragmentManager().popBackStack();
                    xfragmentTransaction.commit();

                }*/

                return false;
            }

        });

        /**
         * Setup Drawer Toggle of the Toolbar
         */

        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.app_name,
                R.string.app_name);

        mDrawerLayout.setDrawerListener(mDrawerToggle);

        mDrawerToggle.syncState();

    }

    @Override
    public void primaryDetails() {
        Fragment newFragment = new PrimaryDetailsFragment();
        this.startNewFragment(newFragment, "hai");

    }

    @Override
    public void mapView() {
        Fragment newFragment = new MapViewFragment();
        this.startNewFragment(newFragment, "hai");
    }


    void startNewFragment(final Fragment frag, final String tag) {
        final FragmentTransaction ftr = this.getSupportFragmentManager()
                .beginTransaction();
        if (this.getSupportFragmentManager().findFragmentById(R.id.containerView) != null) {

            ftr.replace(R.id.containerView, frag, tag);
            ftr.addToBackStack(null);


        } else {
            ftr.add(R.id.containerView, frag, tag);

        }
        ftr.commit();
    }

    public static class Rotate3dAnimation extends Animation {
        private final float mFromDegrees;
        private final float mToDegrees;
        private final float mDepthZ;
        private final View mView;
        private final boolean mReverse;
        private Camera mCamera;

        public Rotate3dAnimation(float fromDegrees, float toDegrees, float depthZ, boolean reverse, View view) {
            mFromDegrees = fromDegrees;
            mToDegrees = toDegrees;
            mDepthZ = depthZ;
            mReverse = reverse;
            mView = view;
        }

        @Override
        public void initialize(int width, int height, int parentWidth, int parentHeight) {
            super.initialize(width, height, parentWidth, parentHeight);
            mCamera = new Camera();
        }

        @Override
        protected void applyTransformation(float interpolatedTime, Transformation t) {
            final float fromDegrees = mFromDegrees;
            float degrees = fromDegrees + ((mToDegrees - fromDegrees) * interpolatedTime);

            final float centerX = mView.getWidth() / 2;
            final float centerY = mView.getHeight() / 2;
            final Camera camera = mCamera;

            final Matrix matrix = t.getMatrix();

            camera.save();
            if (mReverse) {
                camera.translate(0.0f, 0.0f, mDepthZ * interpolatedTime);
            } else {
                camera.translate(0.0f, 0.0f, mDepthZ * (1.0f - interpolatedTime));
            }
            camera.rotateX(degrees);
            camera.getMatrix(matrix);
            camera.restore();

            matrix.preTranslate(-centerX, -centerY);
            matrix.postTranslate(centerX, centerY);
        }


    }
}