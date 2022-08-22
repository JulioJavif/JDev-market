package com.platzi.JDevmarket.web.controller;

import com.platzi.JDevmarket.domain.Purchase;
import com.platzi.JDevmarket.domain.services.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {

    @Autowired
    public PurchaseService purchaseService;

    @GetMapping("/")
    public ResponseEntity<List<Purchase>> getAll(){
        try {
            return new ResponseEntity<>(purchaseService.getAll(), HttpStatus.OK);
        }catch (RuntimeException e){
            System.out.println("El error es: \n"+e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Purchase> save(@RequestBody Purchase purchase){
        try {
            return new ResponseEntity<>(purchaseService.save(purchase), HttpStatus.CREATED);
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<List<Purchase>>> getByClient(@PathVariable("id") String clientId){
        return new ResponseEntity<>(purchaseService.getByClient(clientId), HttpStatus.OK);
    }
}
