package com.example.produtoshexagonal.adapter.in.rest.validator;


import com.example.produtoshexagonal.adapter.dto.ProdutoRequest;
import com.example.produtoshexagonal.application.domain.TipoTributacao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.validation.BeanPropertyBindingResult;

import java.math.BigDecimal;

class AliquotaImpostoValidatorTest {

    @ParameterizedTest
    @CsvSource({"false, 0","true, 10"})
    public void deveValidarAliquotaImposto(boolean esperado, String valor) {

        var request = new ProdutoRequest("teste", BigDecimal.TEN,
                TipoTributacao.ISENTO, new BigDecimal(valor));
        var validator = new AliquotaImpostoValidator();
        var errors = new BeanPropertyBindingResult(request, "teste");
        validator.validate(request, errors);

        Assertions.assertEquals(esperado, errors.hasFieldErrors());

    }

//    @Test
//    public void deveRetornarErrorSeAliquotaForInvalida() {
//
//        var request = new ProdutoRequest("teste", BigDecimal.TEN, TipoTributacao.ISENTO, BigDecimal.ONE);
//        var validator = new AliquotaImpostoValidator();
//        var errors = new BeanPropertyBindingResult(request, "teste");
//        validator.validate(request, errors);
//
//        Assertions.assertEquals(true, errors.hasFieldErrors());
//
//    }
}