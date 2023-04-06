/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Valentina Contreras
 */
@Entity
@Table(name = "MATRICULA_CURSOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MatriculaCursos.findAll", query = "SELECT m FROM MatriculaCursos m"),
    @NamedQuery(name = "MatriculaCursos.findByCodCurso", query = "SELECT m FROM MatriculaCursos m WHERE m.matriculaCursosPK.codCurso = :codCurso"),
    @NamedQuery(name = "MatriculaCursos.findByStudentid", query = "SELECT m FROM MatriculaCursos m WHERE m.matriculaCursosPK.studentid = :studentid"),
    @NamedQuery(name = "MatriculaCursos.findByFecha", query = "SELECT m FROM MatriculaCursos m WHERE m.fecha = :fecha"),
    @NamedQuery(name = "MatriculaCursos.findByPrecio", query = "SELECT m FROM MatriculaCursos m WHERE m.precio = :precio")})
public class MatriculaCursos implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MatriculaCursosPK matriculaCursosPK;
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "PRECIO")
    private Integer precio;
    @JoinColumn(name = "COD_CURSO", referencedColumnName = "COD_CURSO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cursos cursos;
    @JoinColumn(name = "STUDENTID", referencedColumnName = "STUDENTID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Estudiante estudiante;

    public MatriculaCursos() {
    }

    public MatriculaCursos(MatriculaCursosPK matriculaCursosPK, Date fecha, int precio) {
        this.matriculaCursosPK = matriculaCursosPK;
        this.fecha = fecha;
        this.precio = precio;
    }

    public MatriculaCursos(int codCurso, int studentid) {
        this.matriculaCursosPK = new MatriculaCursosPK(codCurso, studentid);
    }

    public MatriculaCursos(int codCurso, int studentid, Date fecha, int precio) {
        this.matriculaCursosPK = new MatriculaCursosPK(codCurso, studentid);
        this.fecha = fecha;
        this.precio = precio;
    }

    public MatriculaCursosPK getMatriculaCursosPK() {
        return matriculaCursosPK;
    }

    public void setMatriculaCursosPK(MatriculaCursosPK matriculaCursosPK) {
        this.matriculaCursosPK = matriculaCursosPK;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Cursos getCursos() {
        return cursos;
    }

    public void setCursos(Cursos cursos) {
        this.cursos = cursos;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (matriculaCursosPK != null ? matriculaCursosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof MatriculaCursos)) {
            return false;
        }
        MatriculaCursos other = (MatriculaCursos) object;
        if ((this.matriculaCursosPK == null && other.matriculaCursosPK != null) || (this.matriculaCursosPK != null && !this.matriculaCursosPK.equals(other.matriculaCursosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unipiloto.entity.MatriculaCursos[ matriculaCursosPK=" + matriculaCursosPK + " ]";
    }

}
