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
                .load("http://www.ulima.edu.pe/sites/default/files/imagenes-promociones/poster_cuentos_de_siempre_web.jpg")
                .fit()
                .centerCrop()
                .into(rImagen);
        rDescripcion.setText("'Cuentos de Siempre como Nunca' es el nuevo especticulo del famoso narrador de cuentos Francois Vallaeys, en el que los cuentos universales seran revelados como nunca antes, en versiones adultas: mas crudas, profundas y graciosas, acompanados con musica clasica interpretada en el piano por su hijo Loac. En este espectaculo, completamente nuevo, los grandes cuentos de la tradicion universal: Cenicienta, Blanca Nieves, Caperucita, Pulgarcito, etc, relatos tan trillados de la literatura infantil, seran redescubiertos traves de versiones tradicionales poco conocidas, de todas partes del mundo.");
        rTitulo.setText("Cuentos de siempre como nunca");
        rPromocion.setText("Descuentos especiales en entradas: Alumnos: S / .16(Precio normal S / .20) Docentes y administrativos: S / .32(Precio normal S / .40) ");
        rCondiciones.setText("Promoci�n v�lida presentando carn� o fotocheck. && V�lida para todas las funciones de jueves a domingos a las 16.00 horas. ");
        rFechaTemporada.setText("Jueves 7 al domingo 24 de julio de 2016 ");
        rLugar.setText("san luis");

    }
}
