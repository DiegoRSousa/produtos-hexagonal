package com.example.produtoshexagonal.adapter.dto;

import com.example.produtoshexagonal.domain.TipoTributacao;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

public class ProdutoRequest {

    @NotBlank
    private String descricao;
    @Positive
    private BigDecimal preco;
    @NotNull
    private TipoTributacao tipoTributacao;
    @PositiveOrZero
    private BigDecimal aliquotaImposto;

    @Deprecated
    public ProdutoRequest() { }

    public ProdutoRequest(String descricao, BigDecimal preco, TipoTributacao tipoTributacao,
                          BigDecimal aliquotaImposto) {
        this.descricao = descricao;
        this.preco = preco;
        this.tipoTributacao = tipoTributacao;
        this.aliquotaImposto = aliquotaImposto;
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
}
