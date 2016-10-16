package coursera.santi.kota2.db;

import android.content.ContentValues;
import android.content.Context;

import java.util.ArrayList;

import coursera.santi.kota2.R;
import coursera.santi.kota2.pojo.Mascota;

/**
 * Created by santi on 15/10/2016.
 */

public class ConstructorMascotas {

    private static final int LIKE = 1;
    private Context context;

    public ConstructorMascotas(Context context) {
        this.context = context;
    }


    public ArrayList<Mascota> obtenerDatos(){


        BaseDatos db = new BaseDatos(context);
        insertarTresMascotas(db);
        return  db.obtenerTadasLasMascotas();

    }

    public void insertarTresMascotas(BaseDatos db){

        ContentValues contentValues =new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "TIMOTEO");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.perro);

        db.insertarMascota(contentValues);

        contentValues =new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE , "CLEMENTINO");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.cuyo);

        db.insertarMascota(contentValues);

        contentValues =new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE , "PANCHITO");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.cat);

        db.insertarMascota(contentValues);


    }

    public  void darLikeMascota(Mascota mascota){
        BaseDatos db = new BaseDatos( context);
        ContentValues contentValues = new ContentValues();

        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTA_NUMERO_LIKES ,LIKE);
        db.insertarLikeContacto(contentValues);

    }

    public  int obtenerLikesMascotas(Mascota mascota){
        //consulta a base datos

        BaseDatos db = new BaseDatos( context);
        return  db.ontenerLikesContacto(mascota);
    }




}
