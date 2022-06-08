package br.com.universidade.resouces;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import br.com.universidade.models.Aluno;
import javax.ws.rs.core.MediaType;

@Path("/alunos")
@Produces(MediaType.APPLICATION_JSON)
public class AlunoResouce {


    @GET
    public List<Aluno> pegarAlunos() {
        Aluno aluno = new Aluno();
        aluno.setIdade(20);
        aluno.setNome("Douglas");
        aluno.setMatricula(9090);

        Aluno aluno1 = new Aluno();
        aluno1.setIdade(22);
        aluno1.setNome("Geraldo");
        aluno1.setMatricula(808);
      
        List<Aluno> alunos = new ArrayList<Aluno>();
        alunos.add(aluno1);
        alunos.add(aluno);

        return alunos;
    }

}
