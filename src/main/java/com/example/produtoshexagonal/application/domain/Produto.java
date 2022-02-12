package com.example.produtoshexagonal.application.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Produto {

    private Long id;
    private String descricao;
    private BigDecimal preco;
    private TipoTributacao tipoTributacao;
    private BigDecimal aliquotaImposto;
    private LocalDateTime criadoEm = LocalDateTime.now();

    @Deprecated
    public Produto() { }

    public Produto(String descricao, BigDecimal preco, TipoTributacao tipoTributacao,
                   BigDecimal aliquotaImposto) {
        this.descricao = descricao;
        this.preco = preco;
        this.tipoTributacao = tipoTributacao;
        this.aliquotaImposto = aliquotaImposto;
    }

    public Produto(Long id, String descricao, BigDecimal preco, TipoTributacao tipoTributacao,
                   BigDecimal aliquotaImposto, LocalDateTime criadoEm) {
        this.id = id;
        this.descricao = descricao;
        this.preco = preco;
        this.tipoTributacao = tipoTributacao;
        this.aliquotaImposto = aliquotaImposto;
        this.criadoEm = criadoEm;
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public TipoTributacao getTipoTributacao() {
        return tipoTributacao;
    }

    public BigDecimal getAliquotaImposto() {
        return aliquotaImposto;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }
}
