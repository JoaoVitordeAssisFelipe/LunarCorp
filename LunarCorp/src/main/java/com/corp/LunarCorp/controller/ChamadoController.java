package com.corp.LunarCorp.controller;

import com.corp.LunarCorp.dto.ChamadoDTO;
import com.corp.LunarCorp.entity.Chamado;
import com.corp.LunarCorp.entity.Status;
import com.corp.LunarCorp.entity.Usuario;
import com.corp.LunarCorp.entity.UsuarioTecnico;
import com.corp.LunarCorp.service.ChamadoService;
import com.corp.LunarCorp.service.UsuarioService;
import com.corp.LunarCorp.service.UsuarioTecnicoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/chamado")
public class ChamadoController {

    private final ChamadoService chamadoService;
    private final UsuarioTecnicoService usuarioTecnicoService;
    private final UsuarioService usuarioService;

    public ChamadoController(ChamadoService chamadoService, UsuarioTecnicoService usuarioTecnicoService, UsuarioService usuarioService) {
        this.chamadoService = chamadoService;
        this.usuarioTecnicoService = usuarioTecnicoService;
        this.usuarioService = usuarioService;
    }


    @PostMapping
    public ResponseEntity<Chamado> criar(@RequestBody @Valid ChamadoDTO dto) {
        Chamado chamado = new Chamado();

        UsuarioTecnico tecnico = usuarioTecnicoService.buscarPorId(dto.getIdUsuarioDestinatario());
        Usuario solicitante = usuarioService.buscarPorId(dto.getIdUsuarioSolicitante());

        chamado.setUsuarioTecnico(tecnico);
        chamado.setUsuarioSolicitante(solicitante);
        chamado.setNatureza(dto.getNatureza());
        chamado.setObservacao(dto.getObservacao());
        chamado.setStatus(Status.ABERTO);
        chamado.setData(LocalDate.now());

        Chamado salvo = chamadoService.criar(chamado);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }



    @GetMapping("/{id}")
    public ResponseEntity<Chamado> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(chamadoService.buscarPorId(id));
    }
}

