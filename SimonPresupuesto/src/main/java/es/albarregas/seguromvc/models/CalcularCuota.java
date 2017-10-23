/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.seguromvc.models;

import es.albarregas.seguromvc.beans.Contenido;
import es.albarregas.seguromvc.beans.Edificio;
import java.io.Serializable;

/**
 *
 * @author Simon
 */
public class CalcularCuota implements Serializable{
    public float calcularEdificio (Edificio edificio){
        float cuota = 0;
        cuota = (float) (Float.parseFloat(edificio.getValorMer()) * 0.005);
        switch (edificio.getTipoEd()){
            case "piso" : cuota = (float) (cuota *  0.95) ;
                break;
            case "casa" : cuota = cuota * 1;
                break;
            case "adosado" : cuota = (float) (cuota * 1.05);
                break;
            case "duplex" : cuota = (float) (cuota * 1.10);
                break;
            case "chalet" : cuota = (float) (cuota * 1.20);
                break;
        }
        cuota+= (cuota / 100) * Float.parseFloat(edificio.getNumeroHab());
        switch (edificio.getFecha()){
            case "1949" : cuota+= cuota * 0.09;
                break;
            case "1950" : cuota+= cuota * 0.06;
                break;
            case "1991" : cuota+= cuota * 0.04;
                break;
            case "2006" : cuota+= cuota * 0.02;
                break;
            case "2016" : cuota+= cuota * 0.01;
                break;  
        }
        if (edificio.getTipoCons().equals("madera")){
            cuota+= cuota * 0.1;
        }   
        return cuota;
    }
    public float calcularContenido(Contenido contenido){
        float cuota = 0;
        cuota = (float) (Float.parseFloat(contenido.getCantidadAseg()) * 0.008);
        if (contenido.getAccidentes() != null){
            cuota+= cuota * 1.25;
        }
        cuota -= Float.parseFloat(contenido.getFranquicia()) * 0.1;

        return cuota;
    }
}
