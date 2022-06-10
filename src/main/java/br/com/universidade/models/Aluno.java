package br.com.universidade.models;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "alunos")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aluno_id")
    private int id;

    @Column(name = "aluno_matricula")
    private Long matricula;
    
    @Column(name = "aluno_nome")
    private String nome; 
    
    @Column(name = "aluno_idade")
    private Integer idade;

}
