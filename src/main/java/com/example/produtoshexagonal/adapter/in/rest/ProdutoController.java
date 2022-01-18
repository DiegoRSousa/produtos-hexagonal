package com.example.produtoshexagonal.adapter.in.rest;

import com.example.produtoshexagonal.adapter.dto.ProdutoRequest;
import com.example.produtoshexagonal.adapter.in.rest.validator.AliquotaImpostoValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final AliquotaImpostoValidator aliquotaImpostoValidator;

    public ProdutoController(AliquotaImpostoValidator aliquotaImpostoValidator) {
        this.aliquotaImpostoValidator = aliquotaImpostoValidator;
    }

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(aliquotaImpostoValidator);
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody ProdutoRequest request) {

        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok().build();
    }
}
