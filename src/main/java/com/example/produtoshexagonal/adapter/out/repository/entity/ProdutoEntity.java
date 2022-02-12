package com.example.produtoshexagonal.adapter.out.repository.entity;

import com.example.produtoshexagonal.application.domain.Produto;
import com.example.produtoshexagonal.application.domain.TipoTributacao;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class ProdutoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String descricao;
    @NotNull
    @Positive
    private BigDecimal preco;
    @NotNull
    @Enumerated(EnumType.STRING)
    private TipoTributacao tipoTributacao;
    @NotNull
    @PositiveOrZero
    private BigDecimal aliquotaImposto;
    private LocalDateTime criadoEm = LocalDateTime.now();

    @Deprecated
    public ProdutoEntity() {}

    public ProdutoEntity(Produto produto) {
        this.descricao = produto.getDescricao();
        this.preco = produto.getPreco();
        this.tipoTributacao = produto.getTipoTributacao();
        this.aliquotaImposto = produto.getAliquotaImposto();
    }

    public Produto toModel() {
        return new Produto(id, descricao, preco, tipoTributacao, aliquotaImposto, criadoEm);
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
