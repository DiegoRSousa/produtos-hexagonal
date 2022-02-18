package com.example.produtoshexagonal.adapter.out;

import com.example.produtoshexagonal.adapter.out.repository.ProdutoAdapterOut;
import com.example.produtoshexagonal.adapter.out.repository.ProdutoRepository;
import com.example.produtoshexagonal.adapter.out.repository.entity.ProdutoEntity;
import com.example.produtoshexagonal.application.domain.Produto;
import com.example.produtoshexagonal.util.ProdutoCreator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;


@ExtendWith(SpringExtension.class)
class ProdutoAdapterOutTest {

    @InjectMocks
    private ProdutoAdapterOut produtoAdapterOut;

    @Mock
    private ProdutoRepository produtoRepository;

    @BeforeEach
    public void setup() {
        Mockito.when(produtoRepository.save(new ProdutoEntity(ProdutoCreator.createProdutoToBeSaved())))
                .thenReturn(new ProdutoEntity(ProdutoCreator.createValidProduto()));
        Mockito.when(produtoRepository.findById(1L))
                .thenReturn(Optional.of(new ProdutoEntity(ProdutoCreator.createValidProduto())));
        Mockito.when(produtoRepository.findById(2L))
                .thenReturn(Optional.empty());
        
    }

    @Test
    public void save_ReturnsProduto_WhenSuccessful() {
        var expectedProduto = ProdutoCreator.createValidProduto();

        Produto produto = produtoAdapterOut.save(ProdutoCreator.createProdutoToBeSaved());

        Assertions.assertNotNull(produto);
        Assertions.assertEquals(expectedProduto.getDescricao(), produto.getDescricao());
    }

    @Test
    public void findById_ReturnsProduto_WhenSuccessful() {
        Long expectedId = 1L;
        var produto = produtoAdapterOut.findById(1L).get();

        Assertions.assertNotNull(produto);
        Assertions.assertEquals(expectedId, produto.getId());
    }

    @Test
    public void findById_ReturnsEmpty_WhenProdutoIsNotFound() {
        var produto = produtoAdapterOut.findById(2L);

        Assertions.assertNotNull(produto);
        Assertions.assertEquals(Optional.empty(), produto);
    }
}