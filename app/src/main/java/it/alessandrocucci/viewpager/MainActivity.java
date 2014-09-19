package it.alessandrocucci.viewpager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.Locale;


public class MainActivity extends FragmentActivity {


    SectionsPagerAdapter mSectionsPagerAdapter;


    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView esci = (ImageView) findViewById(R.id.buttonexit);
        esci.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, LauncherActivity.class);
                startActivity(intent);

            }
        });


        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());


        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);

    }




    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            Fragment fragment = new SectionFragment();
            Bundle args = new Bundle();
            args.putInt(SectionFragment.ARG_SECTION_NUMBER, position + 1);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public int getCount() {

            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Locale l = Locale.getDefault();
            switch (position) {
                case 0:
                    return getString(R.string.section1).toUpperCase(l);
                case 1:
                    return getString(R.string.section2).toUpperCase(l);
                case 2:
                    return getString(R.string.section3).toUpperCase(l);
                case 3:
                    return getString(R.string.section4).toUpperCase(l);
            }
            return null;
        }
    }


    public static class SectionFragment extends Fragment {

        public static final String ARG_SECTION_NUMBER = "section_number";

        public SectionFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            ImageView image = (ImageView) rootView.findViewById(R.id.imageView);
            int i = getArguments().getInt(ARG_SECTION_NUMBER);
            switch (i){
                case 1:
                    image.setImageResource(R.drawable.schermata1);
                    break;
                case 2:
                    image.setImageResource(R.drawable.schermata2);
                    break;
                case 3:
                    image.setImageResource(R.drawable.schermata3);
                    break;
                case 4:
                    image.setImageResource(R.drawable.schermata4);
                    break;
            }

            return rootView;
        }
    }

}