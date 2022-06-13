package br.com.universidade.recursos;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import br.com.universidade.models.Aluno;
import br.com.universidade.services.AlunoService;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javax.ws.rs.core.MediaType;

@Path("/alunos")
@Produces(MediaType.APPLICATION_JSON)
public class AlunoResouce {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("universidadePU");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    AlunoService alunoService = new AlunoService();

    @GET
    public ArrayList<Aluno> pegarTodosAlunos() {
        return alunoService.pegarTodosAlunos();
    }

    @GET
    @Path("/{id}")
    public Aluno pegarAlunoPeloId(@PathParam("id") int id) throws Exception{
        return alunoService.pegarAlunoPeloId(id);
    }

    @POST
    public Aluno criarALuno(Aluno aluno) throws Exception {
        return alunoService.criarALuno(aluno);
    }

}
