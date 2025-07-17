package com.corp.LunarCorp.controller;

import com.corp.LunarCorp.dto.UsuarioDTO;
import com.corp.LunarCorp.entity.Usuario;
import com.corp.LunarCorp.entity.UsuarioTecnico;
import com.corp.LunarCorp.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<Usuario> criar(@RequestBody @Valid UsuarioDTO dto) {
        UsuarioTecnico usuario = new UsuarioTecnico();
        usuario.setNome(dto.getNome());
        usuario.setCargo(dto.getCargo());

        Usuario salvo = usuarioService.criar(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.buscarPorId(id));
    }
}
