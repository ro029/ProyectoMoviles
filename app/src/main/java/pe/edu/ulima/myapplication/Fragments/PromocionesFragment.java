package pe.edu.ulima.myapplication.Fragments;

import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class PromocionesFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    ArrayList<Cultura> culturas=new ArrayList<>();
    private static DatabaseReference ref;
    SwipeRefreshLayout mSwipeRefreshLayout;
    Adapter adapter;
    ListView lista;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_cultura,container,false);
        mSwipeRefreshLayout = (SwipeRefreshLayout) v.findViewById(R.id.swiper);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        lista= (ListView) v.findViewById(R.id.listaCultura);
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
                Log.w("PromocionesActivity", "getUser:onCancelled", databaseError.toException());
            }
        });

    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(false);
            }
        },5000);
    }
}
