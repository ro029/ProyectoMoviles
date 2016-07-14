package pe.edu.ulima.myapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.zip.Inflater;

import pe.edu.ulima.myapplication.R;
import pe.edu.ulima.myapplication.beans.Cultura;

/**
 * Created by CarlosGabriel on 14/07/2016.
 */
public class AdapterRecicler extends RecyclerView.Adapter<AdapterRecicler.ViewHolder> {
    private final Context context;
    private final List<Cultura> culturas;

    public AdapterRecicler(Context context, List<Cultura> culturas) {
        this.context = context;
        this.culturas = culturas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlayour,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.cultura = culturas.get(position);
        Picasso.with(context)
                .load(holder.cultura.getFoto())
                .fit()
                .centerCrop()
                .into(holder.rImagen);
        holder.rTitulo.setText(holder.cultura.getTitulo());
        holder.rDescripcion.setText(holder.cultura.getTitulo());
        holder.rPromocion.setText(holder.cultura.getTitulo());
        holder.rCondiciones.setText(holder.cultura.getTitulo());
        holder.rFechaTemporada.setText(holder.cultura.getTitulo());
        holder.rLugar.setText(holder.cultura.getTitulo());

        holder.mview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mview;
        public final ImageView rImagen;
        public final TextView rTitulo;
        public final TextView rDescripcion;
        public final TextView rPromocion;
        public final TextView rCondiciones;
        public final TextView rFechaTemporada;
        public final TextView rLugar;
        public Cultura cultura;

        public ViewHolder( View view) {
            super(view);
            mview=view;
            rImagen=(ImageView) view.findViewById(R.id.rImagen);
            rDescripcion=(TextView) view.findViewById(R.id.rDescripcion);
            rTitulo=(TextView) view.findViewById(R.id.rTitulo);
            rPromocion=(TextView) view.findViewById(R.id.rPromocionUl);
            rCondiciones=(TextView) view.findViewById(R.id.rCondiciones);
            rFechaTemporada=(TextView) view.findViewById(R.id.rFechaTemporada);
            rLugar=(TextView) view.findViewById(R.id.rLugar);
        }
    }
    public interface clicListener{
        void
    }
}
