/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.seguromvc.beans;

/**
 *
 * @author Simon
 */
public class Contenido {
    private String accidentes;
    private String cantidadAseg;
    private String franquicia;
    private float cuota;

    public String getAccidentes() {
        return accidentes;
    }

    public void setAccidentes(String accidentes) {
        this.accidentes = accidentes;
    }

    public String getCantidadAseg() {
        return cantidadAseg;
    }

    public void setCantidadAseg(String cantidadAseg) {
        this.cantidadAseg = cantidadAseg;
    }

    public String getFranquicia() {
        return franquicia;
    }

    public void setFranquicia(String franquicia) {
        this.franquicia = franquicia;
    }

    public float getCuota() {
        return cuota;
    }

    public void setCuota(float cuota) {
        this.cuota = cuota;
    }
    
    
}
