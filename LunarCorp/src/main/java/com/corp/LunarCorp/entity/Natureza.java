package com.corp.LunarCorp.entity;

public enum Natureza {
    ERRO_DE_SISTEMA ("ERRO DE SISTEMA"),
    HARDWARE_E_PERIFERICO ("Problemas de Hardwares"),
    REDE_INTERNET("Erro de conexão de internet"),
    REDEFINICAO_SENHA("Bloqueio de senha"),
    ATUALIZACAO_SOFTWARE("Atualização de versões de softwares"),
    ERRO_OPERACIONAl("Dúvidas operacinais do usuário"),
    LICENCAS_SOFTWARE("Ativação de licenças de software");

    private final String descricao;

    Natureza(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
