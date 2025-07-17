package com.corp.LunarCorp.service;

import com.corp.LunarCorp.entity.UsuarioTecnico;
import com.corp.LunarCorp.exception.EntidadeNaoEncontradaException;
import com.corp.LunarCorp.repository.UsuarioTecnicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioTecnicoService {
    private final UsuarioTecnicoRepository usuarioTecnicoRepository;


    public UsuarioTecnicoService(UsuarioTecnicoRepository usuarioTecnicoRepository) {
        this.usuarioTecnicoRepository = usuarioTecnicoRepository;
    }
    public UsuarioTecnico criar(UsuarioTecnico usuario) {
        return usuarioTecnicoRepository.save(usuario);
    }
    public List<UsuarioTecnico> listarUsuarioTecnicos(){
        return usuarioTecnicoRepository.findAll();
    }

    public UsuarioTecnico buscarPorId(Long id) {
        return usuarioTecnicoRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        "Usuário técnico com ID " + id + " não encontrado."
                ));
    }

}
