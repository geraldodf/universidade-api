package br.com.universidade.recursos;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.ws.rs.*;
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
    public Aluno pegarAlunoPeloId(@PathParam("id") int id) throws Exception {
        return alunoService.pegarAlunoPeloId(id);
    }

    @GET
    @Path("/query/nome-aluno") 
    public ArrayList<Aluno> pesquisarAlunoPorNome(@QueryParam ("nome") String nome){
        return alunoService.pesquisarAlunoPeloNome(nome);
    }

    @POST
    public Aluno criarALuno(Aluno aluno) throws Exception {
        return alunoService.criarALuno(aluno);
    }

    @PUT
    @Path("/{id}")
    public Aluno atualizarAluno(@PathParam ("id") int id, Aluno aluno) throws Exception {
        return alunoService.atualizarAluno(aluno, id);
    }

    @DELETE
    @Path("/{id}")
    public void excluirAluno(@PathParam ("id") int id){
        alunoService.excluirAluno(id);
    }

}
