package bottom.tab.android.bottomtab;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AboutFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState)
    {
//        View view = inflater.inflate(R.layout.screen_news, container, false);
//        TextView textView = (TextView) view;
//        textView.setText("Main Category: NEWS");
//        return view;
        return inflater.inflate(R.layout.screen_about, container, false);
    }
}