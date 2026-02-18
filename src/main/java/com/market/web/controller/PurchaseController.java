package com.market.web.controller;

import com.market.domain.Purchase;
import com.market.domain.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    @PostMapping("/save")
    public ResponseEntity<Purchase> save(@RequestBody Purchase purchase) {
        return new ResponseEntity<>(purchaseService.save(purchase), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Purchase>> getAll(){
        List<Purchase> purchases = purchaseService.getAll();
        return purchases.isEmpty()
                ? new ResponseEntity<>(purchases, HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(purchases, HttpStatus.OK);
        /*return new ResponseEntity<>(purchaseService.getAll(), HttpStatus.OK);*/
    }

    @GetMapping("/client/{clientId}")
    public ResponseEntity<List<Purchase>> getByClientId(@PathVariable String clientId) {
         return purchaseService.findByClientId(clientId)
                 .map(purchases -> new ResponseEntity<>(purchases, HttpStatus.OK))
                 .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
