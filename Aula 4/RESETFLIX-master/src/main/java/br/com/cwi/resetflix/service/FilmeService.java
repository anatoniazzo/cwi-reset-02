package br.com.cwi.resetflix.service;

import br.com.cwi.resetflix.domain.Genero;
import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.entity.DiretorEntity;
import br.com.cwi.resetflix.entity.FilmeEntity;
import br.com.cwi.resetflix.mapper.*;
import br.com.cwi.resetflix.repository.AtorRepository;
import br.com.cwi.resetflix.repository.DiretorRepository;
import br.com.cwi.resetflix.repository.FilmeRepository;
import br.com.cwi.resetflix.request.CriarFilmeRequest;
import br.com.cwi.resetflix.response.ConsultarDetalhesAtorResponse;
import br.com.cwi.resetflix.response.ConsultarDetalhesFilmeResponse;
import br.com.cwi.resetflix.response.FilmeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilmeService {
    @Autowired
    private FilmeRepository filmeRepository;
    @Autowired
    private AtorRepository atorRepository;
    @Autowired
    private DiretorRepository diretorRepository;

    static FilmesResponseMapper MAPPER_RESPONSE = new FilmesResponseMapper();
    static FilmeEntityMapper MAPPER_ENTITY = new FilmeEntityMapper();
    static ConsultarDetalhesFilmeResponseMapper MAPPER_DETALHES_FILME = new ConsultarDetalhesFilmeResponseMapper();

    public List<FilmeResponse> getFilmes(Genero genero) {
        List<FilmeEntity> filmes = filmeRepository.getFilmes(genero);

        return MAPPER_RESPONSE.mapear(filmes);
    }

    public Long criarFilme(CriarFilmeRequest request) {
        FilmeEntity filmeSalvar = MAPPER_ENTITY.mapear(request);
        return filmeRepository.criarFilme(filmeSalvar);

    }

    public ConsultarDetalhesFilmeResponse getFilmeById(final Long id) {
        FilmeEntity filmeEncontrado = filmeRepository.acharFilmesPorId(id);

        //Buscando Diretor
        DiretorEntity diretorEncontrado = diretorRepository.acharDiretorPorId(filmeEncontrado.getIdDiretor());

        //Buscando Atores
        List<AtorEntity> atoresEncontrados = new ArrayList<>();
        for (Long idAtor:filmeEncontrado.getIdsAtores()) {
            atoresEncontrados.add(atorRepository.acharAtorPorId(idAtor));
        }
        ConsultarDetalhesFilmeResponse response =  MAPPER_DETALHES_FILME.mapear(filmeEncontrado,diretorEncontrado,atoresEncontrados);
        return response;

        }

    }


