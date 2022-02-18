package com.example.produtoshexagonal.application.service;

import com.example.produtoshexagonal.application.domain.Produto;
import com.example.produtoshexagonal.application.port.out.ProdutoPortOut;
import com.example.produtoshexagonal.util.ProdutoCreator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

@ExtendWith(SpringExtension.class)
class ProdutoServiceTest {

    @Mock
    private ProdutoPortOut produtoPortOut;

    @InjectMocks
    private ProdutoService produtoService;

    @BeforeEach
    public void  setup() {
        Mockito.when(produtoPortOut.save(ArgumentMatchers.any(Produto.class)))
                .thenReturn(ProdutoCreator.createValidProduto());
        Mockito.when(produtoPortOut.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(ProdutoCreator.createValidProduto()));
    }

    @Test
    public void save_ReturnsProduto_WhenSuccessful() {
        Produto produto = produtoService.save(ProdutoCreator.createProdutoToBeSaved());
        Assertions.assertEquals(ProdutoCreator.createValidProduto(), produto);
    }

    @Test
    public void findById_ReturnsProduto_WhenSuccessful() {
        Long expectedId = 1L;
        var produto = produtoService.findById(1L).get();

        Assertions.assertNotNull(produto);
        Assertions.assertEquals(expectedId, produto.getId());
    }
}