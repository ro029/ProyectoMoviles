package pe.edu.ulima.myapplication.remote;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pe.edu.ulima.myapplication.Interface.PromocionesView;
import pe.edu.ulima.myapplication.beans.Cultura;
import pe.edu.ulima.myapplication.beans.Promociones;

public class Services {
    private static FirebaseDatabase database;
    private static DatabaseReference ref;
    private static List<Promociones> items;
    public static String userUid;
    public boolean tarjeta;

    public static void init() {
        if (database == null) {
            database = FirebaseDatabase.getInstance();
            database.setPersistenceEnabled(false);
        }
    }

    public static void obtenerPlatos(final PromocionesView promocionesView) {
        ref = database.getReference("platos");
        items = new ArrayList<>();

        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    items.add(data.getValue(Promociones.class));
                }
                promocionesView.obtenerLista(items);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                //Snackbar.make(coordinatorLayout, "onCancelled", Snackbar.LENGTH_SHORT).show();
            }
        });
    }

    /*public static void obtenerJugoDesayunos(final JugoDesayunoView view) {
        items = new ArrayList<>();
        ref = database.getReference("jugos");
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot data : dataSnapshot.getChildren())
                    items.add(data.getValue(Item.class));
                obtenerSandwiches(view);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("se cancelo");
            }
        });
    }

    private static void obtenerSandwiches(final JugoDesayunoView view) {
        ref = database.getReference("sandwiches");
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot data : dataSnapshot.getChildren())
                    items.add(data.getValue(Item.class));

                view.obtenerLista(items);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("se cancelo");
            }
        });
    }

    public static void realizarPedido(Item item, UFoodView view) {
        Pedido pedido = new Pedido(
                new Date().getTime(),
                item.nombre,
                item.precio,
                false
        );
        ref = database.getReference();
        String key = ref.child("users").child(Services.userUid).child("pedido").push().getKey();
        pedido.codigo = key;
        ref.child("users").child(Services.userUid).child("pedido").setValue(pedido);
        view.showNotificaciones();
    }


    public static void intentarPedido(final Item item, final UFoodView view) {
        //items = new ArrayList<>();
        ref = database.getReference();

        ref.child("users").child(Services.userUid).child("tarjetas").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                System.out.println("Esto es lo que sale : " + dataSnapshot.getValue());
                if (dataSnapshot.getValue() != null) {
                    realizarPedido(item, view);
                } else {
                    view.showPayment();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("serv. not.", databaseError.getDetails());
            }
        });
    }

    public static void setNotificaciones(final NotificacionesView view) {
        ref = database.getReference();
        ref.child("users").child(Services.userUid).child("pedido")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        Pedido pedido = dataSnapshot.getValue(Pedido.class);
                        view.setNotificacionesValues(pedido);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Log.e("serv. not.", databaseError.getDetails());
                    }
        });
    }*/
}




