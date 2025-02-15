/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author jcmm
 */
@Entity
public class Matricula implements Serializable {

    private static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Estudiante estudiante;
    @ManyToOne
    private ProgramaAcademico programa;
    @ManyToOne
    private Periodo periodo;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;    
    private String estado;//Pre-Matricula -  Matricula 
    @OneToMany(mappedBy = "estudianteLider")
    private List<Proyecto_Aula> proyecto_Aulas;
    @OneToMany(mappedBy = "editor")
    private List<Item_Proyecto> item_Proyectos;
    @OneToMany(mappedBy = "matricula")
    private List<Integrante> integrantes;

    public Matricula() {
    }

    public Matricula(Long id, Estudiante estudiante, ProgramaAcademico programa, Periodo periodo, Date fecha, String estado, List<Proyecto_Aula> proyecto_Aulas, List<Item_Proyecto> item_Proyectos) {
        this.id = id;
        this.estudiante = estudiante;
        this.programa = programa;
        this.periodo = periodo;
        this.fecha = fecha;
        this.estado = estado;
        this.proyecto_Aulas = proyecto_Aulas;
        this.item_Proyectos = item_Proyectos;
    }
    
    public boolean validarMatricula() {
        boolean valido = true;
        if (this.estudiante.toString().equals("") || this.programa.toString().equals("") || this.periodo.toString().equals("")) {
            valido = false;
        }
        if (this.fecha.equals("") || this.estado.equals("") || this.proyecto_Aulas.equals("")) {
            valido = false;
        }
        if (this.item_Proyectos.equals("") || this.integrantes.equals("")) {
            valido = false;
        }
        return valido;
    }

      

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Matricula)) {
            return false;
        }
        Matricula other = (Matricula) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Matricula[ id=" + getId() + " ]";
    }

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }

    /**
     * @return the estudiante
     */
    public Estudiante getEstudiante() {
        return estudiante;
    }

    /**
     * @param estudiante the estudiante to set
     */
    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    /**
     * @return the programa
     */
    public ProgramaAcademico getPrograma() {
        return programa;
    }

    /**
     * @param programa the programa to set
     */
    public void setPrograma(ProgramaAcademico programa) {
        this.programa = programa;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

 
    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the periodo
     */
    public Periodo getPeriodo() {
        return periodo;
    }

    /**
     * @param periodo the periodo to set
     */
    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }
    
}
