package pe.edu.ulima.myapplication.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import pe.edu.ulima.myapplication.R;
import pe.edu.ulima.myapplication.adapter.Adapter;
import pe.edu.ulima.myapplication.beans.Cultura;

/**
 * Created by Rossy on 14/07/2016.
 */
public class DeportesActivity extends Fragment {
    ArrayList<Cultura> culturas=new ArrayList<>();
    private static DatabaseReference ref;
    Adapter adapter;
    ListView lista;
    Cultura cultura;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_deportes,container,false);
        lista= (ListView) v.findViewById(R.id.listaDeportes);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        ref=database.getReference("promociones");
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot data : dataSnapshot.getChildren()){
                    culturas.add(data.getValue(Cultura.class));
                    Log.e("error",data.getValue()+ "");
                }

                adapter=new Adapter(culturas,getContext());
                lista.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("DeporteActivity", "getUser:onCancelled", databaseError.toException());
            }
        });

    }

}
