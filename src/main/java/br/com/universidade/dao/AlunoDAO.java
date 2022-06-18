package br.com.universidade.dao;

import java.util.ArrayList;
import br.com.universidade.models.Aluno;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

// Camada onde irá ser feito apenas a conexão com o bando de dados!
public class AlunoDAO {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("universidadePU"); // Instanciando criador de "gerentes" e referenciando à PU declarada no persistence.
    EntityManager entityManager = entityManagerFactory.createEntityManager(); //Usando o criador de gerentes para criar um gerente.

    //Diferença de LIST e ARRAYLIST

    public ArrayList<Aluno> pegarTodosAlunos() {
        ArrayList<Aluno> alunos = (ArrayList<Aluno>) entityManager.createQuery("From Aluno").getResultList();
        return alunos;
    }

    public Aluno criarALuno(Aluno aluno) {
        entityManager.getTransaction().begin();
        entityManager.persist(aluno);
        entityManager.getTransaction().commit();
        entityManager.close();
        return aluno;
    }

    public Aluno pegarAlunoPeloId(int id) {
        return entityManager.find(Aluno.class, id); // Por que Aluno.class?
    }

    public Aluno atualizarAluno(Aluno aluno) {
        entityManager.getTransaction().begin();
        entityManager.merge(aluno);
        entityManager.getTransaction().commit();
        entityManager.close();
        return aluno;
    }

    public void excluirAluno(int id) {
        Aluno alunoExcluir = pegarAlunoPeloId(id);
        entityManager.getTransaction().begin();
        entityManager.remove(alunoExcluir);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public ArrayList<Aluno> pesquisarAlunoPeloNome(String nome) {
        Query query = entityManager.createQuery("select a from Aluno a where a.nome like: nome"); // O que essa linha faz?
        return (ArrayList<Aluno>) query.setParameter("nome", "%" + nome + "%").getResultList(); // O que essa linha faz?
    }

}
