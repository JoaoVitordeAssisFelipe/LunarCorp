package com.corp.LunarCorp.controller;

import com.corp.LunarCorp.dto.UsuarioTecnicoDTO;
import com.corp.LunarCorp.entity.UsuarioTecnico;
import com.corp.LunarCorp.service.UsuarioTecnicoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/usuario-tecnico")
public class UsuarioTecnicoController {

    private final UsuarioTecnicoService usuarioTecnicoService;

    public UsuarioTecnicoController(UsuarioTecnicoService usuarioTecnicoService) {
        this.usuarioTecnicoService = usuarioTecnicoService;
    }

    @PostMapping
    public ResponseEntity<UsuarioTecnico> criar(@RequestBody @Valid UsuarioTecnicoDTO dto) {
        UsuarioTecnico tecnico = new UsuarioTecnico();
        tecnico.setNome(dto.getNome());
        tecnico.setCargo(dto.getCargo());
        tecnico.setFuncao(dto.getFuncao());

        UsuarioTecnico salvo = usuarioTecnicoService.criar(tecnico);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioTecnico> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioTecnicoService.buscarPorId(id));
    }
}

