package coursera.santi.kota2.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import coursera.santi.kota2.R;
import coursera.santi.kota2.pojo.TarjetaFoto;

/**
 * Created by santi on 02/10/2016.
 */
public class FotoAdapter extends RecyclerView.Adapter<FotoAdapter.FotoViewHolder>  {

    ArrayList<TarjetaFoto>tarjetaFotos;

    public FotoAdapter(ArrayList<TarjetaFoto> tarjetaFotos) {
        this.tarjetaFotos = tarjetaFotos;
    }

    @Override
    public FotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_foto, parent , false);
        return new FotoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FotoViewHolder holder, int position) {

              TarjetaFoto tarjetaFoto = tarjetaFotos.get(position);

        holder.foto_tarjeta.setImageResource(tarjetaFoto.get$fotolike());
        holder.tvNoMegusta.setText(tarjetaFoto.getNoMegusta());
    }

    @Override
    public int getItemCount() {
        return tarjetaFotos.size();
    }

    public static class FotoViewHolder extends RecyclerView.ViewHolder {

        ImageView foto_tarjeta;
        TextView tvNoMegusta;

        public FotoViewHolder(View itemView) {
            super(itemView);

            tvNoMegusta = (TextView)itemView.findViewById(R.id.tvNoMegusta);
            foto_tarjeta = (ImageView)itemView.findViewById(R.id.foto_tarjeta);
        }
    }

}
