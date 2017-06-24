package bottom.tab.android.bottomtab;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    private TabLayout tabContainer;
    private List<Fragment> fragmentCollection;
    private String[] tabNameCollection;
    private int[] iconCollection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //hideToolBar();
        initStaticData();
        setupView();
        setClickTabDetector();
        setupTab(); // Dont move this line before setClickTabDetector()
    }

    private void initStaticData() {
        iconCollection = new int[] {
                R.drawable.ic_recents_selector,
                R.drawable.ic_favorite_selector,
                R.drawable.ic_place_selector
        };
        tabNameCollection = new String[]{"News", "Program", "About"};
        fragmentCollection = new ArrayList<>();
        collectBottomTabScreen();
    }

    private void setupView() {
        tabContainer = (TabLayout) findViewById(R.id.tab_layout);
    }

    private void setClickTabDetector() {
        tabContainer.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switchTabScreen(  fragmentCollection.get(tab.getPosition())  );
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}
            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });
    }

    private void setupTab() {
        for (int i = 0; i < tabNameCollection.length; i++) {
            tabContainer.addTab(
                    tabContainer.newTab()
                            .setText(tabNameCollection[i])
                            .setIcon(iconCollection[i])
            );
        }
    }

    private void collectBottomTabScreen() {
        fragmentCollection.add(new NewsFragment());
        fragmentCollection.add(new ProgramFragment());
        fragmentCollection.add(new AboutFragment());
    }

    private void switchTabScreen(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
            .replace(R.id.tab_screen_container,fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit();
    }
    /**
     * The Bar which just below the Status Bar
     */
    private void hideToolBar() {
        getSupportActionBar().hide();
    }
}