package com.example.produtoshexagonal.util;

import com.example.produtoshexagonal.application.domain.Produto;
import com.example.produtoshexagonal.application.domain.TipoTributacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProdutoCreator {

    public static Produto createValidProduto() {
        return new Produto(1L, "teste", BigDecimal.TEN,
                TipoTributacao.ISENTO, BigDecimal.ZERO, LocalDateTime.now());
    }

    public static Produto createProdutoToBeSaved() {
        return new Produto("teste", BigDecimal.TEN,
                TipoTributacao.ISENTO, BigDecimal.ZERO);
    }
}
