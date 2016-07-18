package pe.edu.ulima.myapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import pe.edu.ulima.myapplication.DetalleActivity;
import pe.edu.ulima.myapplication.DrawerActivity;
import pe.edu.ulima.myapplication.R;
import pe.edu.ulima.myapplication.beans.Cultura;

/**
 * Created by CarlosGabriel on 14/07/2016.
 */
public class Adapter extends BaseAdapter{

    private List<Cultura> culturas;
    private LayoutInflater mInflater;
    private Context context;

    public Adapter(List<Cultura> culturas, Context context) {
        this.culturas = culturas;
        this.context = context;
        mInflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return culturas.size();
    }

    @Override
    public Object getItem(int position) {
        return culturas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=mInflater.inflate(R.layout.itemlista,parent,false);

        final TextView titulo=(TextView) view.findViewById(R.id.titulo);
        CircleImageView imagen= (CircleImageView) view.findViewById(R.id.promocion);
        final Cultura cultura=(Cultura) getItem(position);
        titulo.setText(cultura.getTitulo());
        Picasso.with(context).load(cultura.getFoto()).into(imagen);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(v.getContext(),DetalleActivity.class);
                mainIntent.putExtra("titulo",cultura.getTitulo());
                mainIntent.putExtra("foto",cultura.getFoto());
                mainIntent.putExtra("condiciones",cultura.getCondiciones());
                mainIntent.putExtra("descripcion",cultura.getDescripcion());
                mainIntent.putExtra("fechatemporada",cultura.getFechaTemporada());
                mainIntent.putExtra("lugar",cultura.getLugar());
                mainIntent.putExtra("facebook",cultura.getFacebook());
                mainIntent.putExtra("promocionul",cultura.getPromocionul());
                v.getContext().startActivity(mainIntent);


            }
        });
        return view;

    }
}
