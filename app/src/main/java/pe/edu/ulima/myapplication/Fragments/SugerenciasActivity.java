package pe.edu.ulima.myapplication.Fragments;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;

import pe.edu.ulima.myapplication.R;
import pe.edu.ulima.myapplication.adapter.Adapter;

public class SugerenciasActivity extends Fragment {
    //ArrayList<Cultura> cultura=new ArrayList<>();
    private static DatabaseReference ref;
    Adapter adapter;
    ListView lista;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_sugerencias,container,false);

        return v;
    }
}
