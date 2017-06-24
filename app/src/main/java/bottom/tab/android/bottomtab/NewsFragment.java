package bottom.tab.android.bottomtab;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class NewsFragment extends Fragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Integer totalAmountOfTopic = 10;
    private String[] subTabNameCollection = {
            "ONE",
            "TWO",
            "THREE",
            "FOUR",
            "FIVE",
            "SIX",
            "SEVEN",
            "EIGHT",
            "NINE",
            "TEN"
    };

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.screen_news, container, false);
        tabLayout = (TabLayout) view.findViewById(R.id.newsTabs);
        viewPager = (ViewPager) view.findViewById(R.id.newsPager);
        setupPager();
        integrateTabWithPager();
        return view;
    }

    private void setupPager() {
        viewPager.setAdapter( new fragmentPagerAdapter(getChildFragmentManager()) );
    }

    private void integrateTabWithPager() {
        tabLayout.setupWithViewPager(viewPager);
    }

    // FragmentPagerAdapter: represents each page as a Fragment in Pager
    class fragmentPagerAdapter extends FragmentPagerAdapter {

        // All Fragment instance are keep in Fragment Manager
        public fragmentPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        // create a new Fragment and return it with a specified position.
        @Override
        public Fragment getItem(int position) {
            return SubNewsFragment.newInstance(subTabNameCollection[position]);
        }

        // Return the total number of fragment.
        @Override
        public int getCount() { // number of views
            return totalAmountOfTopic;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return subTabNameCollection[position];
        }
    }

}
