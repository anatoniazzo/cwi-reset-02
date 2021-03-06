package br.com.cwi.resetflix.entity;

import java.util.List;

public class DiretorEntity {

    private Long id;
    private String nome;
    private List<Long> idFilmes;

    public DiretorEntity(String nome, List<Long> idFilmes) {
        this.nome = nome;
        this.idFilmes = idFilmes;
    }

    public DiretorEntity(Long id, String nome, List<Long> idFilmes) {
        this.id = id;
        this.nome = nome;
        this.idFilmes = idFilmes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Long> getIdFilmes() {
        return idFilmes;
    }

    public void setIdFilmes(List<Long> idFilmes) {
        this.idFilmes = idFilmes;
    }
}