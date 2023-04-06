/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.session;

import co.edu.unipiloto.entity.MatriculaCursos;
import co.edu.unipiloto.entity.MatriculaCursosPK;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Valentina Contreras
 */
@Stateless
public class MatriculaCursosFacade extends AbstractFacade<MatriculaCursos> implements MatriculaCursosFacadeLocal {

    @PersistenceContext(unitName = "CRUD_EstudianteJEE-PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MatriculaCursosFacade() {
        super(MatriculaCursos.class);
    }

    @Override
    public boolean insertarMatriculaCursos(int codCurso, int studentid, Date fecha, int precio) {

        MatriculaCursosPK pk = new MatriculaCursosPK(codCurso, studentid);
        if (consultarMatriculaCursos(pk) == null) {
            return false;
        } else {
             MatriculaCursos mc = new MatriculaCursos(pk, fecha, precio);
            em.persist(mc);
            return true;
        }
    }

    @Override
    public MatriculaCursos consultarMatriculaCursos(MatriculaCursosPK pk) {
        return em.find(MatriculaCursos.class, pk);
    }

    @Override
    public boolean eliminarMatriculaCursos(int codCurso, int studentid, Date fecha, int precio) {
        MatriculaCursosPK pk = new MatriculaCursosPK(codCurso, studentid);
        if (consultarMatriculaCursos(pk) == null) {
            return false;
        } else {
            MatriculaCursos mc = new MatriculaCursos(pk,fecha,precio);
            em.remove(mc);
            return true;
        }
    }

    @Override
    public boolean modificarMatriculaCursos(int codCurso, int studentid, Date fecha, int precio) {
         MatriculaCursosPK pk = new MatriculaCursosPK(codCurso, studentid);
        if (consultarMatriculaCursos(pk) == null) {
            return false;
        } else {
            MatriculaCursos mc = new MatriculaCursos(pk,fecha,precio);
            em.merge(mc);
            return true;
        }
    }

}
