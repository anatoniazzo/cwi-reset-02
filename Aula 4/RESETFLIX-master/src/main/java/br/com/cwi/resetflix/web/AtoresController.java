package br.com.cwi.resetflix.web;

import br.com.cwi.resetflix.request.CriarAtorRequest;
import br.com.cwi.resetflix.response.AtoresResponse;
import br.com.cwi.resetflix.response.ConsultarDetalhesAtorResponse;
import br.com.cwi.resetflix.service.AtorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/atores")
public class AtoresController implements AtoresContract {

    @Autowired
    private AtorService atorService;

    @Override
    @GetMapping
    public List<AtoresResponse> getAtores() {

        return atorService.getAtores();
    }

    @Override
    @GetMapping("/{id}")
    public ConsultarDetalhesAtorResponse getAtorById(@PathVariable("id") final Long id) {

        return atorService.consultarDetalhesAtor(id);
    }

    @Override
    @PostMapping
    public Long criarAtor(@RequestBody final CriarAtorRequest request) {

        return atorService.criarAtor(request);
    }
}
