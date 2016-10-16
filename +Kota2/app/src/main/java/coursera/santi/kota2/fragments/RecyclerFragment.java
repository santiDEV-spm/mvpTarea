package coursera.santi.kota2.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import coursera.santi.kota2.adapters.MascotaAdaptador;
import coursera.santi.kota2.pojo.Mascota;
import coursera.santi.kota2.R;
import coursera.santi.kota2.presentador.IRecyclerViewFragmentPresenter;
import coursera.santi.kota2.presentador.RecyclerViewFragmentPresenter;


public class RecyclerFragment extends Fragment implements IRecyclerViewFragment {


    ArrayList<Mascota>mascotas;
    RecyclerView rvMascotas;
    private IRecyclerViewFragmentPresenter presenter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View v= inflater.inflate(R.layout.fragment_recycler, container, false);

        rvMascotas = (RecyclerView)v.findViewById(R.id.rvMascotas);
        presenter = new RecyclerViewFragmentPresenter(this,getContext());

        return v;
    }


    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas.setLayoutManager(llm);

    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adapter= new MascotaAdaptador(mascotas, getActivity());

        return adapter;

    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adapter) {

        rvMascotas.setAdapter(adapter);
    }
}
