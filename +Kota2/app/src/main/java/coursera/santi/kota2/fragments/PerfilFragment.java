package coursera.santi.kota2.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import coursera.santi.kota2.R;
import coursera.santi.kota2.adapters.FotoAdapter;
import coursera.santi.kota2.pojo.TarjetaFoto;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {

    RecyclerView rvFotosdePerfil;
ArrayList<TarjetaFoto>tarjetaFotos;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_perfil, container, false);

        rvFotosdePerfil = (RecyclerView)view.findViewById(R.id.rvFotosdePerfil);

        GridLayoutManager grd =new GridLayoutManager(getContext(),2);
        rvFotosdePerfil.setLayoutManager(grd);

        llenarlistaFotos();
        InicializarAdaptador();

        return view;
    }

    public  void InicializarAdaptador(){
        FotoAdapter fotoAdapter = new FotoAdapter(tarjetaFotos);
        rvFotosdePerfil.setAdapter(fotoAdapter);
    }

    public void llenarlistaFotos(){

        tarjetaFotos  = new ArrayList<TarjetaFoto>();

        tarjetaFotos.add(new TarjetaFoto(R.drawable.perro,"30"));
        tarjetaFotos.add(new TarjetaFoto(R.drawable.perro,"40"));
        tarjetaFotos.add(new TarjetaFoto(R.drawable.perro,"35"));
        tarjetaFotos.add(new TarjetaFoto(R.drawable.perro,"20"));
        tarjetaFotos.add(new TarjetaFoto(R.drawable.perro,"16"));
        tarjetaFotos.add(new TarjetaFoto(R.drawable.perro,"70"));
        tarjetaFotos.add(new TarjetaFoto(R.drawable.perro,"14"));
        tarjetaFotos.add(new TarjetaFoto(R.drawable.perro,"10"));
        tarjetaFotos.add(new TarjetaFoto(R.drawable.perro,"60"));
        tarjetaFotos.add(new TarjetaFoto(R.drawable.perro,"5"));


    }

}
