package br.com.universidade.recursos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import br.com.universidade.models.Aluno;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javax.ws.rs.core.MediaType;

@Path("/alunos")
@Produces(MediaType.APPLICATION_JSON)
public class AlunoResouce implements Serializable {


    @GET
    public List<Aluno> pegarAlunos() {
        Aluno aluno = new Aluno();
        aluno.setIdade(20);
        aluno.setNome("Douglas");
        aluno.setMatricula(9090L);

        Aluno aluno1 = new Aluno();
        aluno1.setIdade(22);
        aluno1.setNome("Geraldo");
        aluno1.setMatricula(808L);
      
        List<Aluno> alunos = new ArrayList<Aluno>();
        alunos.add(aluno1);
        alunos.add(aluno);

        return alunos;
    }

    @POST
    public void criarALuno(){
        Aluno aluno = new Aluno();
        aluno.setIdade(20);
        aluno.setNome("Douglas");
        aluno.setMatricula(9090L);

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("universidadePU");
        EntityManager entityManager = (EntityManager) entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.merge(aluno);
        entityManager.getTransaction().commit();
        entityManager.close();
        
        
    }

}
