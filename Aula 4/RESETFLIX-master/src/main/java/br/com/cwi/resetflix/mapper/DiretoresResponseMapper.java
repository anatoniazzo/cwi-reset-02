package br.com.cwi.resetflix.mapper;

import br.com.cwi.resetflix.entity.DiretorEntity;
import br.com.cwi.resetflix.response.AtoresResponse;
import br.com.cwi.resetflix.response.DiretoresResponse;

import java.util.ArrayList;
import java.util.List;

public class DiretoresResponseMapper {

    public List<DiretoresResponse> mapear(List<DiretorEntity> diretores) {
        List<DiretoresResponse> diretoresResponses = new ArrayList<>();
        for(DiretorEntity diretor : diretores){

            DiretoresResponse diretoresResponse = new DiretoresResponse(diretor.getId(), diretor.getNome());
            diretoresResponses.add(diretoresResponse);
        }

        return diretoresResponses;
    }
        }


