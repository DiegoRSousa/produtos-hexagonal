package com.example.produtoshexagonal.application.port.in;


import com.example.produtoshexagonal.application.domain.Produto;

public interface ProdutoPortIn {

    Produto save(Produto produto);
}
