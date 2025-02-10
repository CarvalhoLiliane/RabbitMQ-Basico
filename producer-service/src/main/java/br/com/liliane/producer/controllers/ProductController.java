package br.com.liliane.producer.controllers;

import br.com.liliane.producer.services.ProductService;
import br.com.liliane.producer.services.StringService;
import dtos.ProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/products")
public class ProductController {

    private final ProductService service;

    @PostMapping
    public ResponseEntity<String> produces(@RequestBody ProductDTO dto){
         service.createProduct(dto);
         return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
