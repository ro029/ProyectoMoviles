package pe.edu.ulima.myapplication;

import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class PromocioneslistActivity extends ActionBarActivity {
    private DrawerLayout drawerLayout;
    private ListView drawerList;
    private ActionBarDrawerToggle drawerToggle;

    private CharSequence activityTitle;
    private CharSequence itemTitle;
    private String[] tagTitles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemTitle = activityTitle = getTitle();
        tagTitles = getResources().getStringArray(R.array.Tags);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerList = (ListView) findViewById(R.id.left_drawer);

        // Setear una sombra sobre el contenido principal cuando el drawer se despliegue
        drawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);

        //Crear elementos de la lista
        ArrayList<DrawerItem> items = new ArrayList<DrawerItem>();
        items.add(new DrawerItem(tagTitles[0], R.drawable.ic_promociones));
        items.add(new DrawerItem(tagTitles[1], R.drawable.ic_cultura));
        items.add(new DrawerItem(tagTitles[2], R.drawable.ic_deportes));
        items.add(new DrawerItem(tagTitles[3], R.drawable.ic_estudios));
        items.add(new DrawerItem(tagTitles[4], R.drawable.ic_restaurantes));
        items.add(new DrawerItem(tagTitles[5], R.drawable.ic_ropas));
        items.add(new DrawerItem(tagTitles[6], R.drawable.ic_salud));
        items.add(new DrawerItem(tagTitles[7], R.drawable.ic_turismo));
        items.add(new DrawerItem(tagTitles[8], R.drawable.ic_otros));
        items.add(new DrawerItem(tagTitles[9], R.drawable.ic_qr));
        items.add(new DrawerItem(tagTitles[10], R.drawable.ic_sugerencias));



        // Relacionar el adaptador y la escucha de la lista del drawer
        drawerList.setAdapter(new DrawerListAdapter(this, items));
        drawerList.setOnItemClickListener(new DrawerItemClickListener());

        // Habilitar el icono de la app por si hay algún estilo que lo deshabilitó
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        // Crear ActionBarDrawerToggle para la apertura y cierre
        drawerToggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                R.drawable.ic_drawer,
                R.string.drawer_open,
                R.string.drawer_close
        ) {
            public void onDrawerClosed(View view) {
                getSupportActionBar().setTitle(itemTitle);

                /*Usa este método si vas a modificar la action bar
                con cada fragmento
                 */
                //invalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                getSupportActionBar().setTitle(activityTitle);

                /*Usa este método si vas a modificar la action bar
                con cada fragmento
                 */
                //invalidateOptionsMenu();
            }
        };
        //Seteamos la escucha
        drawerLayout.setDrawerListener(drawerToggle);

        if (savedInstanceState == null) {
            selectItem(0);
        }
    }
}
