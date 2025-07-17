package com.corp.LunarCorp.controller;

import com.corp.LunarCorp.dto.AtendimentoDTO;
import com.corp.LunarCorp.entity.Atendimento;
import com.corp.LunarCorp.entity.UsuarioTecnico;
import com.corp.LunarCorp.service.AtendimentoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/atendimento")
public class AtendimentoController {

    private final AtendimentoService atendimentoService;

    public AtendimentoController(AtendimentoService atendimentoService) {
        this.atendimentoService = atendimentoService;
    }

    @PostMapping
    public ResponseEntity<Atendimento> criar(@RequestBody @Valid AtendimentoDTO dto) {
       Atendimento atendimento = new Atendimento();
       atendimento.setId(dto.getIdChamado());
       atendimento.setIdUsuarioTecnico(new UsuarioTecnico(dto.getIdUsuarioTecnico()));
       atendimento.setDataInicio(dto.getDataInicio());
       atendimento.setDataFinal(dto.getDataFinal());
       atendimento.setHistoricoAtendimento(dto.getHistoricoAtendimento());

        Atendimento salvo =  atendimentoService.criar(atendimento);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @GetMapping
    public List<Atendimento> listarTodos() {
        return atendimentoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Atendimento> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(atendimentoService.buscarPorId(id));
    }
}

