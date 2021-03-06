package br.com.cwi.resetflix.entity;

import java.util.List;

public class AtorEntity {
    private Long id;
    private String nome;
    private List<Long> idFilmes;


    public AtorEntity( String nome, List<Long> filmesParticipou) {
        this.nome = nome;
        this.idFilmes = filmesParticipou;
    }
    public AtorEntity(Long id, String nome, List<Long> filmesParticipou) {
        this.id = id;
        this.nome = nome;
        this.idFilmes = filmesParticipou;
    }

    public java.lang.Long getId() {
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