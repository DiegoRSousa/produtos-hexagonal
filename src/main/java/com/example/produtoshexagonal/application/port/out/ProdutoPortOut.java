package com.example.produtoshexagonal.application.port.out;

import com.example.produtoshexagonal.application.domain.Produto;

public interface ProdutoPortOut {

    Produto save(Produto produto);
}
