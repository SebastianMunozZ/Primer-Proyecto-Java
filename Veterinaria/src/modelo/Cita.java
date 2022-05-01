/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Sebastian Munoz Z
 */
public class Cita {
    private int id;
    private String nombreMascota;
    private String tipoMascota;
    private String doctor;
    private int dia;
    private int mes;
    private int año;
    private String comentario;

    public Cita() {
    }

    public Cita(int id, String nombreMascota, String tipoMascota, String doctor, int dia, int mes, int año, String comentario) {
        this.id = id;
        this.nombreMascota = nombreMascota;
        this.tipoMascota = tipoMascota;
        this.doctor = doctor;
        this.dia = dia;
        this.mes = mes;
        this.año = año;
        this.comentario = comentario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public String getTipoMascota() {
        return tipoMascota;
    }

    public void setTipoMascota(String tipoMascota) {
        this.tipoMascota = tipoMascota;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }


    
}
