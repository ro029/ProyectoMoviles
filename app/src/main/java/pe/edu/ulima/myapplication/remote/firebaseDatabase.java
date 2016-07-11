package pe.edu.ulima.myapplication.remote;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import pe.edu.ulima.myapplication.Interface.PromocionesView;
import pe.edu.ulima.myapplication.beans.Promociones;

/**
 * Created by CarlosGabriel on 11/07/2016.
 */
public class firebaseDatabase  {
    private static FirebaseDatabase database;
    private static DatabaseReference ref;
    private static List<Promociones> promociones;
    //private static List<Item> items;

    public static void init(){
        if (database == null) {
            database = FirebaseDatabase.getInstance();
            database.setPersistenceEnabled(false);
        }
    }

        public static void obtenerPromociones(final PromocionesView promocionesView){
        ref = database.getReference("platos");
        promociones = new ArrayList<>();

        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot data: dataSnapshot.getChildren()){
                    promociones.add(data.getValue(Promociones.class));
                }
                //PromocionesView.obtenerLista(promociones);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                //Snackbar.make(coordinatorLayout, "onCancelled", Snackbar.LENGTH_SHORT).show();
            }
        });
    }
}
