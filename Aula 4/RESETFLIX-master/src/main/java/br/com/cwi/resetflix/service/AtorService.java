package br.com.cwi.resetflix.service;

import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.entity.FilmeEntity;
import br.com.cwi.resetflix.mapper.AtorEntityMapper;
import br.com.cwi.resetflix.mapper.AtoresResponseMapper;
import br.com.cwi.resetflix.mapper.ConsultarDetalhesAtorResponseMapper;
import br.com.cwi.resetflix.repository.AtorRepository;
import br.com.cwi.resetflix.repository.FilmeRepository;
import br.com.cwi.resetflix.request.CriarAtorRequest;
import br.com.cwi.resetflix.response.AtoresResponse;
import br.com.cwi.resetflix.response.ConsultarDetalhesAtorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtorService {

    @Autowired
    private AtorRepository atorRepository;

    @Autowired
    private FilmeRepository filmeRepository;

    static AtoresResponseMapper MAPPER_RESPONSE = new AtoresResponseMapper();
    static AtorEntityMapper MAPPER_ENTITY = new AtorEntityMapper();
    static ConsultarDetalhesAtorResponseMapper MAPPER_DETALHES_ATOR = new ConsultarDetalhesAtorResponseMapper();

    public List<AtoresResponse> getAtores() {
        //NA SERVICE É ONDE TU VAI NO REPOSITORY E BUSCA A ENTITY E TRANSFORMA PRA RESPONSE;
        List<AtorEntity> atores = atorRepository.getAtores();

        return MAPPER_RESPONSE.mapear(atores);
    }

    public Long criarAtor(CriarAtorRequest request) {
        AtorEntity atorSalvar = MAPPER_ENTITY.mapear(request);
        return atorRepository.criarAtor(atorSalvar);
    }

    public ConsultarDetalhesAtorResponse consultarDetalhesAtor(final Long id) {
            AtorEntity atorSalvo = atorRepository.acharAtorPorId(id);
            List<FilmeEntity> filmesAtor = filmeRepository.acharFilmesAtor(id);
            return MAPPER_DETALHES_ATOR.mapear(atorSalvo, filmesAtor);
        }
    }






