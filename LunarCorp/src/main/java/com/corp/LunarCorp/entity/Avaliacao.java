package com.corp.LunarCorp.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "chamado_id")
    private Chamado chamado;

    @ManyToOne
    @JoinColumn(name = "usuario_solicitante_id")
    private Usuario usuarioSolicitante;

    private int notaAvaliacao;
    private String comentario;
    private LocalDate dataAvaliacao;

    public  Avaliacao(){}

    public Avaliacao(Chamado chamado, String comentario, LocalDate dataAvaliacao, Long id, int notaAvaliacao, Usuario usuarioSolicitante) {
        this.chamado = chamado;
        this.comentario = comentario;
        this.dataAvaliacao = dataAvaliacao;
        this.id = id;
        this.notaAvaliacao = notaAvaliacao;
        this.usuarioSolicitante = usuarioSolicitante;
    }

    public Chamado getChamado() {
        return chamado;
    }

    public void setChamado(Chamado chamado) {
        this.chamado = chamado;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public LocalDate getDataAvaliacao() {
        return dataAvaliacao;
    }

    public void setDataAvaliacao(LocalDate dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNotaAvaliacao() {
        return notaAvaliacao;
    }

    public void setNotaAvaliacao(int notaAvaliacao) {
        this.notaAvaliacao = notaAvaliacao;
    }

    public Usuario getUsuarioSolicitante() {
        return usuarioSolicitante;
    }

    public void setUsuarioSolicitante(Usuario usuarioSolicitante) {
        this.usuarioSolicitante = usuarioSolicitante;
    }

    @Override
    public String toString() {
        return "Avaliacao{" +
                "chamado=" + chamado +
                ", id=" + id +
                ", usuarioSolicitante=" + usuarioSolicitante +
                ", notaAvaliacao=" + notaAvaliacao +
                ", comentario='" + comentario + '\'' +
                ", dataAvaliacao=" + dataAvaliacao +
                '}';
    }
}
