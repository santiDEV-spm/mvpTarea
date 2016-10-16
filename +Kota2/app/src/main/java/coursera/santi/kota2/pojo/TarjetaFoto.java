package coursera.santi.kota2.pojo;

/**
 * Created by santi on 02/10/2016.
 */
public class TarjetaFoto {

    private int $fotolike ;
    private String noMegusta;

    public TarjetaFoto(int $fotolike , String noMegusta) {
        this.$fotolike = $fotolike;
        this.noMegusta = noMegusta;
    }

    public int get$fotolike() {
        return $fotolike;
    }

    public void set$fotolike(int $fotolike) {
        this.$fotolike = $fotolike;
    }

    public String getNoMegusta() {
        return noMegusta;
    }

    public void setNoMegusta(String noMegusta) {
        this.noMegusta = noMegusta;
    }
}
