package com.example.produtoshexagonal.adapter.out.repository;

import com.example.produtoshexagonal.adapter.out.repository.entity.ProdutoEntity;
import com.example.produtoshexagonal.application.domain.Produto;
import com.example.produtoshexagonal.application.port.out.ProdutoPortOut;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ProdutoAdapterOut implements ProdutoPortOut {


    private ProdutoRepository produtoRepository;

    public ProdutoAdapterOut(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public Produto save(Produto produto) {
        var produtoEntity = new ProdutoEntity(produto);
        produtoRepository.save(produtoEntity);
        return produtoEntity.toModel();
    }

    @Override
    public Optional<Produto> findById(Long id) {
        var produtoEntity = produtoRepository.findById(id);
        if(produtoEntity.isPresent())
            return Optional.of(produtoEntity.get().toModel());
        else
            return Optional.empty();
    }
}
