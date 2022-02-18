package com.example.produtoshexagonal.adapter.in.rest;

import com.example.produtoshexagonal.adapter.dto.ProdutoRequest;
import com.example.produtoshexagonal.adapter.dto.ProdutoResponse;
import com.example.produtoshexagonal.adapter.in.rest.validator.AliquotaImpostoValidator;
import com.example.produtoshexagonal.application.port.in.ProdutoPortIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/produtos")
public class ProdutoAdapterIn {


    private final AliquotaImpostoValidator aliquotaImpostoValidator;
    private final ProdutoPortIn produtoPortIn;

    public ProdutoAdapterIn(AliquotaImpostoValidator aliquotaImpostoValidator, ProdutoPortIn produtoPortIn) {
        this.aliquotaImpostoValidator = aliquotaImpostoValidator;
        this.produtoPortIn = produtoPortIn;
    }

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(aliquotaImpostoValidator);
    }

    @PostMapping()
    public ResponseEntity<ProdutoResponse> save(@Valid @RequestBody ProdutoRequest request) {
        var produto = request.toModel();
        produto = produtoPortIn.save(produto);
        return new ResponseEntity<>(new ProdutoResponse(produto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponse> findById(@PathVariable Long id) {
        var produto = produtoPortIn.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return ResponseEntity.ok(new ProdutoResponse(produto));
    }
}
