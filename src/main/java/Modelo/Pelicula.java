package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Pelicula{
    String nombre;
    String pais;
    String anio;
    String productora;
    List<String> actores = new ArrayList<>();
    String descripcion;
    String genero;

    public Pelicula(){}
    public Pelicula(String nombre, String pais, String anio, String productora, List<String> actores, String descripcion, String genero) {
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
}
