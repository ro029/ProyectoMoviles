package pe.edu.ulima.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PromocionesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);


    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Salir")
                .setMessage("Esta seguro de Salir")
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent mainIntent = new Intent(PromocionesActivity.this,MainActivity.class);
                        PromocionesActivity.this.startActivity(mainIntent);
                        PromocionesActivity.this.finish();
                    }
                }).setNegativeButton("No", null).show();
    }


}
