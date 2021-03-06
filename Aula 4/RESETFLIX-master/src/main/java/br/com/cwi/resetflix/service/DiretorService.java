package br.com.cwi.resetflix.service;

import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.entity.DiretorEntity;
import br.com.cwi.resetflix.entity.FilmeEntity;
import br.com.cwi.resetflix.mapper.AtoresResponseMapper;
import br.com.cwi.resetflix.mapper.DiretorEntityMapper;
import br.com.cwi.resetflix.mapper.DiretoresResponseMapper;
import br.com.cwi.resetflix.repository.AtorRepository;
import br.com.cwi.resetflix.repository.DiretorRepository;
import br.com.cwi.resetflix.request.CriarAtorRequest;
import br.com.cwi.resetflix.request.CriarDiretorRequest;
import br.com.cwi.resetflix.response.DiretoresResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiretorService {


    @Autowired
    private DiretorRepository diretorRepository;

    static DiretoresResponseMapper MAPPER_RESPONSE = new DiretoresResponseMapper();
    static DiretorEntityMapper MAPPER_ENTITY = new DiretorEntityMapper();

    public List<DiretoresResponse> getDiretores() {
        List<DiretorEntity> diretores = diretorRepository.getDiretores();
        return MAPPER_RESPONSE.mapear(diretores);
    }

    public Long criarDiretor(CriarDiretorRequest request) {
        DiretorEntity diretorSalvar = MAPPER_ENTITY.mapear(request);
        return diretorRepository.criarDiretor(diretorSalvar);
    }
}

