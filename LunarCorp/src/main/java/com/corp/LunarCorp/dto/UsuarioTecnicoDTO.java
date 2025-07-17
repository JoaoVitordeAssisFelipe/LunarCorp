package com.corp.LunarCorp.dto;

import jakarta.validation.constraints.NotBlank;

public class UsuarioTecnicoDTO {
    @NotBlank
    private String nome;

    @NotBlank
    private String cargo;

    @NotBlank
    private String funcao;

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

