package com.corp.LunarCorp.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class UsuarioTecnico extends Usuario{
    @OneToMany(mappedBy = "usuarioTecnico")
    private List<Chamado> chamadosAtribuidos;

    @OneToMany(mappedBy = "usuarioTecnico")
    private List<Atendimento> atendimentosRealizados;

    private String email;
    private String senha;


    public UsuarioTecnico() {}

    public UsuarioTecnico(String cargo, String funcao, Long id, String nome, String email) {
        super(cargo, funcao, id, nome);
        this.email = email;
    }

    public UsuarioTecnico(Long idUsuarioDestinatario) {
        super.setId(idUsuarioDestinatario);
    }
    public long calcularChamadosFinalizados() {
        return atendimentosRealizados.stream()
                .filter(a -> a.getChamado().getStatus() == Status.FINALIZADO)
                .count();
    }

    public List<Atendimento> getAtendimentosRealizados() {
        return atendimentosRealizados;
    }

    public void setAtendimentosRealizados(List<Atendimento> atendimentosRealizados) {
        this.atendimentosRealizados = atendimentosRealizados;
    }

    public List<Chamado> getChamadosAtribuidos() {
        return chamadosAtribuidos;
    }

    public void setChamadosAtribuidos(List<Chamado> chamadosAtribuidos) {
        this.chamadosAtribuidos = chamadosAtribuidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    public UsuarioTecnico(String email) {
        this.email = email;
    }

}
