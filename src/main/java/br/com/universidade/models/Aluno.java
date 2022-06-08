package br.com.universidade.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Aluno {

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    private Integer matricula;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    private String nome; 

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    private Integer idade;    


}
