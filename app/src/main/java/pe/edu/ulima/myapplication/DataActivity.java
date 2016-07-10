package pe.edu.ulima.myapplication;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DataActivity extends Fragment {
    public static final String ARG_ARTICLES_NUMBER = "articles_number";

    public DataActivity() {
        // Constructor vacío
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_promocioneslist, container, false);
        int i = getArguments().getInt(ARG_ARTICLES_NUMBER);
        String article = getResources().getStringArray(R.array.Tags)[i];

        getActivity().setTitle(article);

        return rootView;
    }
}
