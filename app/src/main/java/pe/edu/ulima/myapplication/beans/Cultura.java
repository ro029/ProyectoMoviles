package pe.edu.ulima.myapplication.beans;

/**
 * Created by CarlosGabriel on 13/07/2016.
 */
public class Cultura {
    private String foto;
    private String titulo;
    private String descripcion;
    private String condiciones;
    private String fechaTemporada;
    private String lugar;
    private String promocionul;
    private String facebook;
    private String filtro;


    public Cultura(String foto, String titulo, String descripcion, String condiciones, String fechaTemporada, String lugar, String promocionul, String facebook, String filtro) {
        this.foto = foto;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.condiciones = condiciones;
        this.fechaTemporada = fechaTemporada;
        this.lugar = lugar;
        this.promocionul = promocionul;
        this.facebook = facebook;
        this.filtro = filtro;
    }

    public Cultura() {
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCondiciones() {
        return condiciones;
    }

    public void setCondiciones(String condiciones) {
        this.condiciones = condiciones;
    }

    public String getFechaTemporada() {
        return fechaTemporada;
    }

    public void setFechaTemporada(String fechaTemporada) {
        this.fechaTemporada = fechaTemporada;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getPromocionul() {
        return promocionul;
    }

    public void setPromocionul(String promocionul) {
        this.promocionul = promocionul;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }
}
