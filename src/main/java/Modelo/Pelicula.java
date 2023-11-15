package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Pelicula{
    private String ruta;
    private String imagen;
    private String nombre;
    private String pais;
    private String anio;
    private String productora;
    private List<String> actores = new ArrayList<>();
    private String descripcion;
    private String genero;
    public Pelicula(){}

    public Pelicula(String ruta, String imagen, String nombre, String pais, String anio, String productora, List<String> actores, String descripcion, String genero) {
        this.ruta = ruta;
        this.imagen = imagen;
        this.nombre = nombre;
        this.pais = pais;
        this.anio = anio;
        this.productora = productora;
        this.actores = actores;
        this.descripcion = descripcion;
        this.genero = genero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getProductora() {
        return productora;
    }

    public void setProductora(String productora) {
        this.productora = productora;
    }

    public List<String> getActores() {
        return actores;
    }

    public void setActores(List<String> actores) {
        this.actores = actores;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getImagen() {
        return imagen;
    }

    public String getRuta() {
        return ruta;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
}
