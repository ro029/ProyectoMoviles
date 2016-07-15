package pe.edu.ulima.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;
import pe.edu.ulima.myapplication.Fragments.CulturaActivity;
import pe.edu.ulima.myapplication.Fragments.DeportesActivity;
import pe.edu.ulima.myapplication.Fragments.IdiomasActivity;
import pe.edu.ulima.myapplication.Fragments.PromocionesFragment;
import pe.edu.ulima.myapplication.Fragments.SugerenciasActivity;

public class DrawerActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler{

    //Defining Variables
    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private ZXingScannerView mScannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        //Log.i("correoA",getIntent().getStringExtra("correo"));


        // Initializing Toolbar and setting it as the actionbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
        PromocionesFragment promocionActivity = new PromocionesFragment();
        android.support.v4.app.FragmentTransaction fragmentPromocion = getSupportFragmentManager().beginTransaction();
        fragmentPromocion.replace(R.id.frame,promocionActivity);
        fragmentPromocion.commit();

        //Initializing NavigationView
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setItemIconTintList(null);
        View viewHeader = LayoutInflater.from(this).inflate(R.layout.header, navigationView, false);
        ((TextView) viewHeader.findViewById(R.id.email)).setText(getIntent().getStringExtra("correo"));
        Toast.makeText(DrawerActivity.this,getIntent().getStringExtra("correo"),Toast.LENGTH_SHORT);
        navigationView.addHeaderView(viewHeader);
        //Setting Navigation View Item Selected Listener to handle the item click of the navigation menu
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            // This method will trigger on item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {


                    //Checking if the item is in checked state or not, if not make it in checked state
                    if(menuItem.isChecked()) menuItem.setChecked(false);
                    else menuItem.setChecked(true);

                    //Closing drawer on item click
                    drawerLayout.closeDrawers();

                    //Check to see which item was being clicked and perform appropriate action
                    switch (menuItem.getItemId()){


                    //Replacing the main content with ContentFragment Which is our Inbox View;
                    case R.id.promociones:
                        Toast.makeText(getApplicationContext(),"Promociones",Toast.LENGTH_SHORT).show();
                        PromocionesFragment promocionActivity = new PromocionesFragment();
                        android.support.v4.app.FragmentTransaction fragmentPromocion = getSupportFragmentManager().beginTransaction();
                        fragmentPromocion.replace(R.id.frame,promocionActivity);
                        fragmentPromocion.commit();
                        toolbar.setTitle("Promociones");

                        return true;

                    // For rest of the options we just show a toast on click

                    case R.id.cultura:
                        Toast.makeText(getApplicationContext(),"Cultura y entretenimiento",Toast.LENGTH_SHORT).show();
                        CulturaActivity cultura=new CulturaActivity();
                        android.support.v4.app.FragmentTransaction transaccionCultura = getSupportFragmentManager().beginTransaction();
                        transaccionCultura.replace(R.id.frame,cultura);
                        transaccionCultura.commit();
                        toolbar.setTitle("Cultura y entretenimiento");



                        return true;
                    case R.id.deportes:
                        Toast.makeText(getApplicationContext(),"Deportes",Toast.LENGTH_SHORT).show();
                        DeportesActivity deportesActivity=new DeportesActivity();
                        android.support.v4.app.FragmentTransaction transaccionDeportes = getSupportFragmentManager().beginTransaction();
                        transaccionDeportes.replace(R.id.frame,deportesActivity);
                        transaccionDeportes .commit();
                        toolbar.setTitle("Deportes");
                        return true;
                    case R.id.idiomas:
                        Toast.makeText(getApplicationContext(),"Idiomas y otros estudios",Toast.LENGTH_SHORT).show();
                        IdiomasActivity idiomasActivity=new IdiomasActivity();
                        android.support.v4.app.FragmentTransaction transaccionidiomas = getSupportFragmentManager().beginTransaction();
                        transaccionidiomas.replace(R.id.frame,idiomasActivity);
                        transaccionidiomas .commit();
                        toolbar.setTitle("Idiomas y otros estudios");
                        return true;
                    case R.id.restaurantes:
                        Toast.makeText(getApplicationContext(),"Restaurantes",Toast.LENGTH_SHORT).show();
                        toolbar.setTitle("Restaurantes");
                        return true;
                    case R.id.ropa:
                        Toast.makeText(getApplicationContext(),"Ropa y accesorios",Toast.LENGTH_SHORT).show();
                        toolbar.setTitle("Ropa y accesorios");
                        return true;
                    case R.id.salud:
                        Toast.makeText(getApplicationContext(),"Salud",Toast.LENGTH_SHORT).show();
                        toolbar.setTitle("Salud");
                        return true;
                    case R.id.turismo:
                        Toast.makeText(getApplicationContext(),"Turismo",Toast.LENGTH_SHORT).show();
                        toolbar.setTitle("Turismo");
                        return true;
                    case R.id.otros:
                        Toast.makeText(getApplicationContext(),"Otros productos y servicios",Toast.LENGTH_SHORT).show();
                        toolbar.setTitle("Otros productos y servicios");
                        return true;
                    case R.id.sugerencia:
                        Toast.makeText(getApplicationContext(),"Sugerencias",Toast.LENGTH_SHORT).show();
                        SugerenciasActivity sugerenciasActivity=new SugerenciasActivity();
                        android.support.v4.app.FragmentTransaction transaccionsugerencias = getSupportFragmentManager().beginTransaction();
                        transaccionsugerencias.replace(R.id.frame,sugerenciasActivity);
                        transaccionsugerencias .commit();
                        toolbar.setTitle("Sugerencias");
                        return true;
                    case R.id.qr:

                        mScannerView = new ZXingScannerView(DrawerActivity.this);
                        setContentView(mScannerView);
                        mScannerView.setResultHandler(DrawerActivity.this);
                        mScannerView.startCamera();



                        return true;
                    case R.id.Salir:
                        new AlertDialog.Builder(DrawerActivity.this)
                                .setTitle("Delete entry")
                                .setMessage("Are you sure you want to delete this entry?")
                                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent mainIntent = new Intent(DrawerActivity.this,MainActivity.class);
                                        DrawerActivity.this.startActivity(mainIntent);
                                        DrawerActivity.this.finish();

                        /*finish();
                        System.exit(0);*/
                                    }
                                }).setNegativeButton("No", null).show();
                        return true;

                    default:
                        Toast.makeText(getApplicationContext(),"Somethings Wrong",Toast.LENGTH_SHORT).show();
                        return true;

                }
            }
        });

        // Initializing Drawer Layout and ActionBarToggle
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.openDrawer, R.string.closeDrawer){

            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank
                /*
                correo=(TextView) drawerView.findViewById(R.id.email);
                correo.setText(getIntent().getStringExtra("correo"));*/



                super.onDrawerOpened(drawerView);
            }
        };

        //Setting the actionbarToggle to drawer layout
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessay or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();






    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Salir")
                .setMessage("Esta seguro de Salir")
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent mainIntent = new Intent(DrawerActivity.this,MainActivity.class);
                        DrawerActivity.this.startActivity(mainIntent);
                        DrawerActivity.this.finish();

                        /*finish();
                        System.exit(0);*/
                    }
                }).setNegativeButton("No", null).show();
    }

    @Override
    public void handleResult(Result rawResult) {
        // Do something with the result here

        Log.e("handler", rawResult.getText()); // Prints scan results
        Log.e("handler", rawResult .getBarcodeFormat().toString()); // Prints the scan format (qrcode)

        // show the scanner result into dialog box.
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Scan Result");
        builder.setMessage(rawResult.getText());
        AlertDialog alert1 = builder.create();
        alert1.show();


        // If you would like to resume scanning, call this method below:
        mScannerView.resumeCameraPreview(this);
    }

}

