package com.example.produtoshexagonal.adapter.config;

import com.example.produtoshexagonal.adapter.out.repository.ProdutoAdapterOut;
import com.example.produtoshexagonal.adapter.out.repository.ProdutoRepository;
import com.example.produtoshexagonal.application.port.in.ProdutoPortIn;
import com.example.produtoshexagonal.application.service.ProdutoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    ProdutoPortIn produtoPortIn(ProdutoRepository produtoRepository) {
        return new ProdutoService(new ProdutoAdapterOut(produtoRepository));

    }
}
