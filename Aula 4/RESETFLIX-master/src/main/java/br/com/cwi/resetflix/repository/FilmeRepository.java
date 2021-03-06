package br.com.cwi.resetflix.repository;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.cwi.resetflix.entity.AtorEntity;
import org.springframework.stereotype.Repository;

import br.com.cwi.resetflix.domain.Genero;
import br.com.cwi.resetflix.entity.FilmeEntity;

@Repository
public class FilmeRepository {

    static List<FilmeEntity> filmes = new ArrayList<>();//lista de filmes vazia

    static Long contadorIds = 1l;

    public List<FilmeEntity> getFilmes(Genero genero) {
        return filmes;//listar os filmes por gênero
    }

    public Long criarFilme(FilmeEntity filmeSalvar) {
        if (filmeSalvar.getId() == null) {
            filmeSalvar.setId(contadorIds);
            contadorIds++;

        }
        filmes.add(filmeSalvar);
        return filmeSalvar.getId();
    }


    public FilmeEntity acharFilmesPorId(Long id) {
        for (FilmeEntity filmeEntity : filmes) {
            if (filmeEntity.getId().equals(id)) {
                return filmeEntity;
            }
        }
        return null;

    }

    public List<FilmeEntity> acharFilmesAtor(Long id) {
        return null;
    }
}


