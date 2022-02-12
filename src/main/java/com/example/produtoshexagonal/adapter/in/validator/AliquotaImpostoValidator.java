package com.example.produtoshexagonal.adapter.in.validator;

import com.example.produtoshexagonal.adapter.dto.ProdutoRequest;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class AliquotaImpostoValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return ProdutoRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        var request = (ProdutoRequest) target;

        if(request.getTipoTributacao().aliquotaInvalida(request.getAliquotaImposto()))
            errors.rejectValue("aliquotaImposto", null, "Aliquota imposto invalida");

    }
}
