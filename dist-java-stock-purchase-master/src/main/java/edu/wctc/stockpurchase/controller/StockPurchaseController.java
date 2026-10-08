package edu.wctc.stockpurchase.controller;

import edu.wctc.stockpurchase.entity.StockPurchase;
import edu.wctc.stockpurchase.service.StockPurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stockpurchases")
public class StockPurchaseController {

    private final StockPurchaseService stockPurchaseService;

    @Autowired
    public StockPurchaseController(StockPurchaseService stockPurchaseService) {
        this.stockPurchaseService = stockPurchaseService;
    }
    @GetMapping
    public List<StockPurchase> getPurchases() {
        return stockPurchaseService.findAll();
    }

    @GetMapping("/{purchaseId}")
    public StockPurchase getPurchase(@PathVariable int purchaseId){
        return stockPurchaseService.findById(purchaseId);
    }

    @PostMapping
    public StockPurchase createPurchase(@RequestBody StockPurchase stockPurchase){
        return stockPurchaseService.createPurchase(stockPurchase);
    }

    @PutMapping
    public StockPurchase updatePurchase(@RequestBody StockPurchase stockPurchase){
        return stockPurchaseService.createPurchase(stockPurchase);
    }

    @DeleteMapping("/{purchaseId}")
    public String deletePurchase(@PathVariable int purchaseId){
        stockPurchaseService.deletePurchase(purchaseId);
        return "Successfully deleted purchase with id: " + purchaseId;
    }


}
