package com.example.produtoshexagonal.application.port.out;

import com.example.produtoshexagonal.application.domain.Produto;

import java.util.Optional;

public interface ProdutoPortOut {

    Produto save(Produto produto);

    Optional<Produto> findById(Long id);
}
