package br.com.cwi.resetflix.mapper;

import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.entity.DiretorEntity;
import br.com.cwi.resetflix.entity.FilmeEntity;
import br.com.cwi.resetflix.response.AtoresResponse;
import br.com.cwi.resetflix.response.ConsultarDetalhesFilmeResponse;
import br.com.cwi.resetflix.response.DiretoresResponse;

import java.util.ArrayList;
import java.util.List;

public class ConsultarDetalhesFilmeResponseMapper {

    public ConsultarDetalhesFilmeResponse mapear(FilmeEntity filmeEncontrado, DiretorEntity diretorEncontrado, List<AtorEntity> atoresEncontrados) {
        DiretoresResponse diretoresResponse = null;
        if(diretorEncontrado != null) {
            diretoresResponse = new DiretoresResponse(diretorEncontrado.getId(), diretorEncontrado.getNome());
        }
        List<AtoresResponse> atoresResponseList = new ArrayList<>();
        for (AtorEntity ator : atoresEncontrados) {
            atoresResponseList.add(new AtoresResponse(ator.getId(), ator.getNome()));
        }
        return new ConsultarDetalhesFilmeResponse(filmeEncontrado.getId(), filmeEncontrado.getNome(), filmeEncontrado.getGenero(), diretoresResponse, atoresResponseList);


    }
}
