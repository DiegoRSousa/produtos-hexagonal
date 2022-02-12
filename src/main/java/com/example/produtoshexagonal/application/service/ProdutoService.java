package com.example.produtoshexagonal.application.service;

import com.example.produtoshexagonal.application.domain.Produto;
import com.example.produtoshexagonal.application.port.in.ProdutoPortIn;
import com.example.produtoshexagonal.application.port.out.ProdutoPortOut;

public class ProdutoService implements ProdutoPortIn {

    private ProdutoPortOut produtoPortOut;

    public ProdutoService(ProdutoPortOut produtoPortOut) {
        this.produtoPortOut = produtoPortOut;
    }

    @Override
    public Produto save(Produto produto) {
        return produtoPortOut.save(produto);
    }
}
