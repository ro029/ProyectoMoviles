package pe.edu.ulima.myapplication.beans;

/**
 * Created by CarlosGabriel on 11/07/2016.
 */
public class Promociones {
    private String foto;
    private String titulo;
    private String descripcion;
    private String condiciones;
    private String fechaTemporada;
    private String lugar;
    private String facebook;
    private String filtro;

    public Promociones(String foto, String titulo, String descripcion, String condiciones, String fechaTemporada, String lugar, String facebook, String filtro) {
        this.foto = foto;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.condiciones = condiciones;
        this.fechaTemporada = fechaTemporada;
        this.lugar = lugar;
        this.facebook = facebook;
        this.filtro = filtro;
    }

    public Promociones() {
    }
}




