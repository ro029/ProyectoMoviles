package pe.edu.ulima.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import pe.edu.ulima.myapplication.beans.Cultura;

public class DetalleActivity extends AppCompatActivity {

   ImageView rImagen;
    TextView rTitulo;
    TextView rDescripcion;
    TextView rPromocion;
    TextView rCondiciones;
    TextView rFechaTemporada;
    TextView rLugar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.itemlayour);

        rImagen=(ImageView) findViewById(R.id.rImagen);
        rDescripcion=(TextView) findViewById(R.id.rDescripcion);
        rTitulo=(TextView) findViewById(R.id.rTitulo);
        rPromocion=(TextView) findViewById(R.id.rPromocionUl);
        rCondiciones=(TextView) findViewById(R.id.rCondiciones);
        rFechaTemporada=(TextView) findViewById(R.id.rFechaTemporada);
        rLugar=(TextView) findViewById(R.id.rLugar);

        Picasso.with(this)
                .load(getIntent().getStringExtra("foto"))
                .into(rImagen);
        rDescripcion.setText(getIntent().getStringExtra("descripcion"));
        rTitulo.setText(getIntent().getStringExtra("titulo"));
        rPromocion.setText(getIntent().getStringExtra("promocionul"));
        rCondiciones.setText(getIntent().getStringExtra("condiciones"));
        rFechaTemporada.setText(getIntent().getStringExtra("fechatemporada"));
        rLugar.setText(getIntent().getStringExtra("lugar"));

    }
}
