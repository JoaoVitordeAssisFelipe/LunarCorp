package com.corp.LunarCorp.entity;

public enum Status {
    ABERTO ("Chamdo aberto"),
    EM_ATENDIMENTO("Chamado em atendimento"),
    FINALIZADO("Chamado encerrado/concluído"),
    REABERTO("Chamado reaberto");

    public final String descricao;

    Status(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return this.descricao;
    }
}
