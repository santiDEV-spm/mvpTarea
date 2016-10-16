package coursera.santi.kota2.db;

/**
 * Created by santi on 15/10/2016.
 */

public class ConstantesBaseDatos {

    public  static  final  String  DATABASE_NAME ="mascotas";
    public static final  int DATABASE_VERSION = 1;


    public static final String TABLE_MASCOTAS ="mascota"; //nombre de tabla contacto


    public static final String TABLE_MASCOTA_ID               ="id";
    public static final String TABLE_MASCOTA_NOMBRE       ="nombre";
    public static final String TABLE_MASCOTA_FOTO ="foto";


    public static final String TABLE_LIKES_MASCOTA = "mascota_likes" ;
    public static final String TABLE_LIKES_MASCOTA_ID ="id" ;
    public static final String TABLE_LIKES_MASCOTA_ID_MASCOTA ="id_mascota" ;
    public static final String TABLE_LIKES_MASCOTA_NUMERO_LIKES = "numero_likes";
}
