package com.corp.LunarCorp.controller;

import com.corp.LunarCorp.dto.AvaliacaoDTO;
import com.corp.LunarCorp.entity.Avaliacao;
import com.corp.LunarCorp.service.AvaliacaoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliacao")

public class AvaliacaoController {

    private final AvaliacaoService avaliacaoService;

    public AvaliacaoController(AvaliacaoService avaliacaoService) {
        this.avaliacaoService = avaliacaoService;
    }


    @PostMapping
    public ResponseEntity<Avaliacao> criar(@RequestBody @Valid AvaliacaoDTO dto) {
       Avaliacao avaliacao = new Avaliacao();

       avaliacao.setId(dto.getIdChamado());
       avaliacao.setNotaAvaliacao(dto.getNota());
       avaliacao.setComentario(dto.getComentario());

       Avaliacao salvo = avaliacaoService.criar(avaliacao);
       return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @GetMapping
    public List<Avaliacao> listar() {
        return avaliacaoService.listarAvaliacoes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Avaliacao> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(avaliacaoService.buscarPorId(id));
    }
}


