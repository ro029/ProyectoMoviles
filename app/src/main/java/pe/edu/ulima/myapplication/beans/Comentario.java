package pe.edu.ulima.myapplication.beans;

/**
 * Created by CarlosGabriel on 14/07/2016.
 */
public class Comentario {
    private String comentario;

    public Comentario(String comentario) {
        this.comentario = comentario;
    }

    public Comentario() {
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
