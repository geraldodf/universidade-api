package br.com.universidade.services;

import java.util.ArrayList;



import br.com.universidade.dao.AlunoDAO;
import br.com.universidade.models.Aluno;

public class AlunoService {

    AlunoDAO alunoDao = new AlunoDAO();

    public ArrayList<Aluno> pegarTodosAlunos() {
        return alunoDao.pegarTodosAlunos();
    }

    public Aluno criarALuno(Aluno aluno) throws Exception {
        verificarAluno(aluno);
        return alunoDao.criarALuno(aluno);
    }

    public Aluno pegarAlunoPeloId(int id) throws Exception {
        return alunoDao.pegarAlunoPeloId(id);
    }

    public Aluno atualizarAluno(Aluno aluno, int id) throws Exception {
        verificarAluno(aluno);
        Aluno alunoRetorno = pegarAlunoPeloId(id);

        alunoRetorno.setIdade(aluno.getIdade());
        alunoRetorno.setNome(aluno.getNome());
        alunoRetorno.setMatricula(aluno.getMatricula());

        return alunoDao.atualizarAluno(alunoRetorno);
    }

    public void excluirAluno(int id) {
        alunoDao.excluirAluno(id);
    }
    
    public ArrayList<Aluno> pesquisarAlunoPeloNome(String nome) {
       return alunoDao.pesquisarAlunoPeloNome(nome);
    }
    void verificarAluno(Aluno aluno) throws Exception {
        if (aluno.getIdade() == null) {
            throw new Exception("O aluno precisa de uma idade para ser cadastrado!!");
        }

        if (aluno.getMatricula() == null) {
            throw new Exception("O aluno precisa de uma matricula válida!");

        }
        if (aluno.getNome() == null || aluno.getNome().length() < 4) {
            throw new Exception("O aluno precisa de um nome válido com mais de 4 caracteres");
        }
    }


 

}
