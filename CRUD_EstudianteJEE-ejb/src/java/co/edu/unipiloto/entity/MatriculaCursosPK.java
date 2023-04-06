/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Valentina Contreras
 */
@Embeddable
public class MatriculaCursosPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CURSO")
    private int codCurso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STUDENTID")
    private int studentid;

    public MatriculaCursosPK() {
    }

    public MatriculaCursosPK(int codCurso, int studentid) {
        this.codCurso = codCurso;
        this.studentid = studentid;
    }

    public int getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(int codCurso) {
        this.codCurso = codCurso;
    }

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCurso;
        hash += (int) studentid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof MatriculaCursosPK)) {
            return false;
        }
        MatriculaCursosPK other = (MatriculaCursosPK) object;
        if (this.codCurso != other.codCurso) {
            return false;
        }
        if (this.studentid != other.studentid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unipiloto.entity.MatriculaCursosPK[ codCurso=" + codCurso + ", studentid=" + studentid + " ]";
    }
    
}
