package coursera.santi.kota2.pojo;

/**
 * Created by santi on 24/09/2016.
 */
public class Mascota {

    private int imagen;
    private String nombre;
    private int like;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public Mascota() {
        this.nombre = nombre;
        this.imagen = imagen;


    }




    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
