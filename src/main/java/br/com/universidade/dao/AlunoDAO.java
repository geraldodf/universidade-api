package br.com.universidade.dao;

import java.util.ArrayList;
import br.com.universidade.models.Aluno;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AlunoDAO {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("universidadePU");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

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
        return entityManager.find(Aluno.class, id);
    }

}
