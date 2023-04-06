/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Valentina Contreras
 */
@Entity
@Table(name = "CURSOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cursos.findAll", query = "SELECT c FROM Cursos c"),
    @NamedQuery(name = "Cursos.findByCodCurso", query = "SELECT c FROM Cursos c WHERE c.codCurso = :codCurso"),
    @NamedQuery(name = "Cursos.findByNombre", query = "SELECT c FROM Cursos c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Cursos.findByNumCreditos", query = "SELECT c FROM Cursos c WHERE c.numCreditos = :numCreditos"),
    @NamedQuery(name = "Cursos.findBySemestre", query = "SELECT c FROM Cursos c WHERE c.semestre = :semestre"),
    @NamedQuery(name = "Cursos.findByNumEstudiantesAdmitidos", query = "SELECT c FROM Cursos c WHERE c.numEstudiantesAdmitidos = :numEstudiantesAdmitidos")})
public class Cursos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CURSO")
    private Integer codCurso;
    @Size(max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "NUM_CREDITOS")
    private Integer numCreditos;
    @Column(name = "SEMESTRE")
    private Integer semestre;
    @Column(name = "NUM_ESTUDIANTES_ADMITIDOS")
    private Integer numEstudiantesAdmitidos;

    public Cursos() {
    }

    public Cursos(Integer codCurso) {
        this.codCurso = codCurso;
    }

    public Cursos(Integer codCurso, String nombre, Integer numCreditos, Integer semestre, Integer numEstudiantesAdmitidos) {
        this.codCurso = codCurso;
        this.nombre = nombre;
        this.numCreditos = numCreditos;
        this.semestre = semestre;
        this.numEstudiantesAdmitidos = numEstudiantesAdmitidos;
    }

   

    public Integer getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(Integer codCurso) {
        this.codCurso = codCurso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNumCreditos() {
        return numCreditos;
    }

    public void setNumCreditos(Integer numCreditos) {
        this.numCreditos = numCreditos;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public Integer getNumEstudiantesAdmitidos() {
        return numEstudiantesAdmitidos;
    }

    public void setNumEstudiantesAdmitidos(Integer numEstudiantesAdmitidos) {
        this.numEstudiantesAdmitidos = numEstudiantesAdmitidos;
    }

   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCurso != null ? codCurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cursos)) {
            return false;
        }
        Cursos other = (Cursos) object;
        if ((this.codCurso == null && other.codCurso != null) || (this.codCurso != null && !this.codCurso.equals(other.codCurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unipiloto.entity.Cursos[ codCurso=" + codCurso + " ]";
    }
    
}
