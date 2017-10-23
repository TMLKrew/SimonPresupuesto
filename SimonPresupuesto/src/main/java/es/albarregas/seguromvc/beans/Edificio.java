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
public class Edificio {
    private String tipoEd;
    private String numeroHab;
    private String fecha;
    private String tipoCons;
    private String valorMer;
    private float cuota;

    public Edificio() {
    
    }

    public String getTipoEd() {
        return tipoEd;
    }

    public void setTipoEd(String tipoEd) {
        this.tipoEd = tipoEd;
    }

    public String getNumeroHab() {
        return numeroHab;
    }

    public void setNumeroHab(String numeroHab) {
        this.numeroHab = numeroHab;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTipoCons() {
        return tipoCons;
    }

    public void setTipoCons(String tipoCons) {
        this.tipoCons = tipoCons;
    }

    public String getValorMer() {
        return valorMer;
    }

    public void setValorMer(String valorMer) {
        this.valorMer = valorMer;
    }

    public float getCuota() {
        return cuota;
    }

    public void setCuota(float cuota) {
        this.cuota = cuota;
    }
    
    
}
