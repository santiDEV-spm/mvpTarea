package coursera.santi.kota2.adapters;

import android.app.Activity;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.StringTokenizer;

import coursera.santi.kota2.R;
import coursera.santi.kota2.db.ConstructorMascotas;
import coursera.santi.kota2.pojo.Mascota;


/**
 * Created by santi on 24/09/2016.
 */
public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    ArrayList<Mascota>mascotas;
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> mascotas,Activity activity) {
        this.mascotas = mascotas;
        this.activity=activity;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_mascota, parent , false);

        return new MascotaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder holder, int position) {

        final Mascota mascota = mascotas.get(position);

        holder.imgMascota.setImageResource(mascota.getImagen());
        holder.tvNombre.setText(mascota.getNombre());
        holder.tvNumerolike.setText(String.valueOf(mascota.getLike()));


        holder.imgVotar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Snackbar.make(v,"diste Like a " + mascota.getNombre() + "...",Snackbar.LENGTH_INDEFINITE).show();

                ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
                constructorMascotas.darLikeMascota(mascota);

                holder.tvNumerolike.setText(constructorMascotas.obtenerLikesMascotas(mascota));

            }
        });

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        ImageView imgMascota,imgRaquin,imgVotar;
        TextView tvNombre,tvNumerolike;

        public MascotaViewHolder(View itemView) {
            super(itemView);

            imgMascota = (ImageView)itemView.findViewById(R.id.imgMascota);
            imgRaquin = (ImageView)itemView.findViewById(R.id.imgRaquin);
            imgVotar = (ImageView)itemView.findViewById(R.id.imgBotonVotar);

            tvNombre = (TextView)itemView.findViewById(R.id.tvNombre);
            tvNumerolike=(TextView)itemView.findViewById(R.id.numeroMegusta);
        }
    }
}
