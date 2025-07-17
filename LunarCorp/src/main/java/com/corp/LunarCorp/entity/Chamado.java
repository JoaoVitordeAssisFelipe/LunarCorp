package com.corp.LunarCorp.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Chamado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate data;

    @ManyToOne
    @JoinColumn(name = "destinatario_id", nullable = false)
    private UsuarioTecnico usuarioTecnico;

    @ManyToOne
    @JoinColumn(name = "solicitante_id", nullable = false)
    private Usuario usuarioSolicitante;

    @Enumerated(EnumType.STRING)
    private Natureza natureza;

    private String observacao;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "chamado_original_id")
    private Chamado chamadoOriginal;

    public Chamado(){}

    public Chamado(LocalDate data, Natureza natureza, String observacao, Status status, UsuarioTecnico usuarioTecnico) {
        this.data = data;
        this.natureza = natureza;
        this.observacao = observacao;
        this.status = status;
        this.usuarioTecnico = usuarioTecnico;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public Natureza getNatureza() {
        return natureza;
    }

    public void setNatureza(Natureza natureza) {
        this.natureza = natureza;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public UsuarioTecnico getUsuarioTecnico() {
        return usuarioTecnico;
    }

    public void setUsuarioTecnico(UsuarioTecnico usuarioTecnico) {
        this.usuarioTecnico = usuarioTecnico;
    }

    public Chamado getChamadoOriginal() {
        return chamadoOriginal;
    }

    public void setChamadoOriginal(Chamado chamadoOriginal) {
        this.chamadoOriginal = chamadoOriginal;
    }
    public Usuario getUsuarioSolicitante() {
        return usuarioSolicitante;
    }

    public void setUsuarioSolicitante(Usuario usuarioSolicitante) {
        this.usuarioSolicitante = usuarioSolicitante;
    }
}

