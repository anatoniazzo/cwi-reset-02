package br.com.cwi.resetflix.entity;

import br.com.cwi.resetflix.domain.Genero;

import java.util.List;

public class SerieEntity {
    private FilmeEntity id;
    private String nome;
    private Genero genero;
    private Integer temporadas;
    private Integer episodios;
    private List<Integer> IdAtores;

    public SerieEntity(FilmeEntity id, String nome, Genero genero, Integer temporadas, Integer episodios, List<Integer> idAtores) {
        this.id = id;
        this.nome = nome;
        this.genero = genero;
        this.temporadas = temporadas;
        this.episodios = episodios;
        IdAtores = idAtores;
    }

    public FilmeEntity getId() {
        return id;
    }

    public void setId(FilmeEntity id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Integer getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(Integer temporadas) {
        this.temporadas = temporadas;
    }

    public Integer getEpisodios() {
        return episodios;
    }

    public void setEpisodios(Integer episodios) {
        this.episodios = episodios;
    }

    public List<Integer> getIdAtores() {
        return IdAtores;
    }

    public void setIdAtores(List<Integer> idAtores) {
        IdAtores = idAtores;
    }
}
