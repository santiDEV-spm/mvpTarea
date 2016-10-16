package coursera.santi.kota2.presentador;

import android.content.Context;

import java.util.ArrayList;

import coursera.santi.kota2.db.ConstructorMascotas;
import coursera.santi.kota2.fragments.IRecyclerViewFragment;
import coursera.santi.kota2.pojo.Mascota;

/**
 * Created by santi on 15/10/2016.
 */

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {

    private IRecyclerViewFragment iRecyclerViewFragment;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragment iRecyclerViewFragment, Context context) {
        this.iRecyclerViewFragment = iRecyclerViewFragment;
        this.context = context;
        obtenrmascotasBaseDatos();
    }

    @Override
    public void obtenrmascotasBaseDatos() {

        constructorMascotas = new ConstructorMascotas(context);
        mascotas=constructorMascotas.obtenerDatos();
        mostrarContactosENRecyclerView();

    }

    @Override
    public void mostrarContactosENRecyclerView() {

        iRecyclerViewFragment.inicializarAdaptadorRV(iRecyclerViewFragment.crearAdaptador(mascotas));
        iRecyclerViewFragment.generarLinearLayoutVertical();

    }
}
