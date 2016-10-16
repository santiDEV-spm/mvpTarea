package coursera.santi.kota2.fragments;

import java.util.ArrayList;

import coursera.santi.kota2.adapters.MascotaAdaptador;
import coursera.santi.kota2.pojo.Mascota;

/**
 * Created by santi on 15/10/2016.
 */

public interface IRecyclerViewFragment {

    public void generarLinearLayoutVertical();
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);
    public void  inicializarAdaptadorRV(MascotaAdaptador adapter);
}
