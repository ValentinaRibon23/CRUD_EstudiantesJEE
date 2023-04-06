/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.session;

import co.edu.unipiloto.entity.MatriculaCursos;
import co.edu.unipiloto.entity.MatriculaCursosPK;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Valentina Contreras
 */
@Local
public interface MatriculaCursosFacadeLocal {

    void create(MatriculaCursos matriculaCursos);

    void edit(MatriculaCursos matriculaCursos);

    void remove(MatriculaCursos matriculaCursos);

    MatriculaCursos find(Object id);

    List<MatriculaCursos> findAll();

    List<MatriculaCursos> findRange(int[] range);

    int count();

    boolean insertarMatriculaCursos(int codCurso, int studentid, Date fecha, int precio);

    MatriculaCursos consultarMatriculaCursos(MatriculaCursosPK pk);

    boolean eliminarMatriculaCursos(int codCurso, int studentid, Date fecha, int precio);
    
    boolean modificarMatriculaCursos(int codCurso, int studentid, Date fecha, int precio);

}
