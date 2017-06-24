package bottom.tab.android.bottomtab;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SubNewsFragment extends Fragment {
    public static final String ARG_TITLE = "ARG_TITLE";
    private String tabTitle;

    public static SubNewsFragment newInstance(String title) {

        Bundle args = new Bundle();
        args.putString(ARG_TITLE, title);
        SubNewsFragment fragment = new SubNewsFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tabTitle = getArguments().getString(ARG_TITLE);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.screen_sub_news, container, false);
        ( (TextView) view.findViewById(R.id.newsText) ).setText(tabTitle);
        return view;
    }
}
