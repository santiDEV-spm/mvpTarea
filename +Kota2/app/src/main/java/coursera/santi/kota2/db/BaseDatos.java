package coursera.santi.kota2.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import coursera.santi.kota2.pojo.Mascota;

/**
 * Created by santi on 15/10/2016.
 */

public class BaseDatos extends SQLiteOpenHelper {

    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String queryCrearTablaMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLE_MASCOTAS+ "( " +
                ConstantesBaseDatos.TABLE_MASCOTA_ID+ " INTEGER PRIMARY KEY AUTOINCREMENT," +
                ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE+ " TEXT," +
                ConstantesBaseDatos.TABLE_MASCOTA_FOTO+ " INTEGER" +
                ")";


        String queryLikeMascotaTAB = " CREATE TABLE " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA + "("+
                ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID+ " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA+ " INTEGER, "+
                ConstantesBaseDatos.TABLE_LIKES_MASCOTA_NUMERO_LIKES + " INTEGER, " +
                "FOREIGN KEY ( " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA + " ) " +
                "REFERENCES " + ConstantesBaseDatos.TABLE_MASCOTAS + "( "+ConstantesBaseDatos.TABLE_MASCOTA_ID +" )"+
                ")";

        db.execSQL(queryCrearTablaMascota);
        db.execSQL(queryLikeMascotaTAB);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLE_MASCOTAS);
        db.execSQL("DROP TABLE IF EXIST"+ ConstantesBaseDatos.TABLE_LIKES_MASCOTA);
        onCreate(db);

    }

    public ArrayList<Mascota> obtenerTadasLasMascotas(){
        ArrayList<Mascota>mascotas= new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTAS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query , null);

        while ( registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setImagen(registros.getInt(2));

 /*
            String queryLikes = "SELECT COUNT ("+ConstantesBaseDatos.TABLE_LIKES_MASCOTA_NUMERO_LIKES+")"+
                    "FROM" + ConstantesBaseDatos.TABLE_LIKES_MASCOTA +
                    "WHERE" + ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA+ " = " + mascotaActual.getId();

            Cursor registrosLIkes = db.rawQuery(queryLikes , null);
            if (registrosLIkes .moveToNext()){

                mascotaActual.setLike(registrosLIkes.getInt(0));
            }
            else {

                mascotaActual.setLike(0);
            }
     */
            mascotas.add(mascotaActual);

        }

        db.close();

        return  mascotas;
    }

    public void insertarMascota (ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_MASCOTAS , null , contentValues);
        db.close();


    }

    public  void insertarLikeContacto(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_LIKES_MASCOTA, null , contentValues);
        db.close();
    }

    public  int ontenerLikesContacto(Mascota mascota){

        int likes = 0;
        String query = "SELECT COUNT ("+ConstantesBaseDatos.TABLE_LIKES_MASCOTA_NUMERO_LIKES+")" +
                "FROM " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA +
                "WHERE" + ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA + " = " + mascota.getId();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        if (registros.moveToNext()){
            likes = registros.getInt(0);

        }
        db.close();

        return likes;
    }
}
