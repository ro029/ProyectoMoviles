package pe.edu.ulima.myapplication.beans;

/**
 * Created by Rossy on 14/07/2016.
 */
public class Idiomas {
    private String foto;
    private String titulo;
    private String condiciones;
    private String fechaTemporada;
    private String lugar;
    private String promocionul;
    private String facebook;
    private String filtro;

    public Idiomas(String condiciones, String facebook, String fechaTemporada, String filtro, String foto, String lugar, String promocionul, String titulo) {
        this.condiciones = condiciones;
        this.facebook = facebook;
        this.fechaTemporada = fechaTemporada;
        this.filtro = filtro;
        this.foto = foto;
        this.lugar = lugar;
        this.promocionul = promocionul;
        this.titulo = titulo;
    }

    public Idiomas() {
    }

    public String getCondiciones() {
        return condiciones;
    }

    public void setCondiciones(String condiciones) {
        this.condiciones = condiciones;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getFechaTemporada() {
        return fechaTemporada;
    }

    public void setFechaTemporada(String fechaTemporada) {
        this.fechaTemporada = fechaTemporada;
    }

    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
