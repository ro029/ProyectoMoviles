package pe.edu.ulima.myapplication.Fragments;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import pe.edu.ulima.myapplication.FirebaseHelper.FirebaseHelper;
import pe.edu.ulima.myapplication.R;
import pe.edu.ulima.myapplication.adapter.Adapter;
import pe.edu.ulima.myapplication.beans.Comentario;
import pe.edu.ulima.myapplication.beans.Cultura;

public class SugerenciasActivity extends Fragment {
    TextView comentario;
    Button boton;
    DatabaseReference db;
    FirebaseHelper helper;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_sugerencias,container,false);
        comentario=(TextView) v.findViewById(R.id.eteSugerencias);
        boton=(Button)v.findViewById(R.id.btnSugerencia);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        db= FirebaseDatabase.getInstance().getReference();

        helper=new FirebaseHelper(db);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String comentarioinput=comentario.getText().toString();
                Comentario c=new Comentario();
                c.setComentario(comentarioinput);

                if(comentarioinput.length()>0 && comentarioinput!=null){
                    if(helper.save(c)){
                        comentario.setText("");
                        Toast.makeText(getContext(),"Gracias por su comentario",Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });

    }

}
