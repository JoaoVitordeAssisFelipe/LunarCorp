package com.corp.LunarCorp.exception;

import java.time.LocalDateTime;

public class ErroResposta {
    private int status;
    private LocalDateTime timestamp;
    private String mensagem;
    private String caminho;

    public ErroResposta(int status, LocalDateTime timestamp, String mensagem, String caminho) {
        this.status = status;
        this.timestamp = timestamp;
        this.mensagem = mensagem;
        this.caminho = caminho;
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
