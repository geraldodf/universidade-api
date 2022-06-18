package br.com.universidade.recursos;

import java.util.ArrayList;
import javax.ws.rs.*;
import br.com.universidade.models.Aluno;
import br.com.universidade.services.AlunoService;
import javax.ws.rs.core.MediaType;

// Camada onde irá ser recebida todas as requisições!
@Path("/alunos") // Configurando o endpoint do recurso
@Produces(MediaType.APPLICATION_JSON) // Configuração para mostrar que esse recurso retorna um objeto do tipo JSON
public class AlunoResouce {

    AlunoService alunoService = new AlunoService();

    @GET
    public ArrayList<Aluno> pegarTodosAlunos() {
        return alunoService.pegarTodosAlunos();
    }

    @GET
    @Path("/{id}") //Configurando o endpoint a ser consumido para essa requisição, recebimento do id pela url.
    public Aluno pegarAlunoPeloId(@PathParam("id") int id) throws Exception {
        return alunoService.pegarAlunoPeloId(id);
    }

    @GET
    @Path("/query/nome")//Configurando o endpoint a ser consumido para essa requisição, recebimento do nome do aluno.
    public ArrayList<Aluno> pesquisarAlunoPorNome(@QueryParam("nome") String nome) {
        return alunoService.pesquisarAlunoPeloNome(nome);
    }

    @POST
    public Aluno criarALuno(Aluno aluno) throws Exception {
        return alunoService.criarALuno(aluno);
    }

    @PUT
    @Path("/{id}")
    public Aluno atualizarAluno(@PathParam("id") int id, Aluno aluno) throws Exception {
        return alunoService.atualizarAluno(aluno, id);
    }

    @DELETE
    @Path("/{id}")
    public void excluirAluno(@PathParam("id") int id) {
        alunoService.excluirAluno(id);
    }

}
