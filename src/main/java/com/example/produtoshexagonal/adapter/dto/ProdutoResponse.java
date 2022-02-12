package com.example.produtoshexagonal.adapter.dto;

import com.example.produtoshexagonal.application.domain.Produto;
import com.example.produtoshexagonal.application.domain.TipoTributacao;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProdutoResponse {

    private Long id;
    private String descricao;
    private BigDecimal preco;
    private TipoTributacao tipoTributacao;
    private BigDecimal aliquotaImposto;
    private LocalDateTime criadoEm;

    @Deprecated
    public ProdutoResponse() {}

    public ProdutoResponse(Produto produto) {
        this.id = produto.getId();
        this.descricao = produto.getDescricao();
        this.preco = produto.getPreco();
        this.tipoTributacao = produto.getTipoTributacao();
        this.aliquotaImposto = produto.getAliquotaImposto();
        this.criadoEm = produto.getCriadoEm();
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
