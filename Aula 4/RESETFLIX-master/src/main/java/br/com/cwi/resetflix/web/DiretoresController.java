package br.com.cwi.resetflix.web;

import br.com.cwi.resetflix.request.CriarDiretorRequest;
import br.com.cwi.resetflix.response.ConsultarDetalhesDiretorResponse;
import br.com.cwi.resetflix.response.DiretoresResponse;
import br.com.cwi.resetflix.service.DiretorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/diretores")
public class DiretoresController implements DiretoresContract {

    @Autowired
    private DiretorService diretorService;

    @Override
    @GetMapping
    public List<DiretoresResponse> getDiretores() {
        return diretorService.getDiretores();
    }

    @Override
    @GetMapping("/{id}")
    public ConsultarDetalhesDiretorResponse getDiretorById(@PathVariable("id")Long id) {
        return null;
    }

    @Override
    @PostMapping
    public Long criarDiretor(@RequestBody final CriarDiretorRequest request) {
        return diretorService.criarDiretor(request);
    }
}




