package com.example.produtoshexagonal.application.port.in;


import com.example.produtoshexagonal.application.domain.Produto;

import java.util.Optional;

public interface ProdutoPortIn {

    Produto save(Produto produto);

    Optional<Produto> findById(Long id);
}
