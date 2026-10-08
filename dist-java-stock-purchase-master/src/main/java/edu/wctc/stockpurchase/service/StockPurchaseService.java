package edu.wctc.stockpurchase.service;

import edu.wctc.stockpurchase.entity.StockPurchase;
import edu.wctc.stockpurchase.exception.ResourceNotFoundException;
import edu.wctc.stockpurchase.repo.StockPurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockPurchaseService {
    private final StockPurchaseRepository stockPurchaseRepository;

    @Autowired
    public StockPurchaseService(StockPurchaseRepository stockPurchaseRepository) {
        this.stockPurchaseRepository = stockPurchaseRepository;
    }

    public List<StockPurchase> findAll() {
        return (List<StockPurchase>) stockPurchaseRepository.findAll();
    }

    public StockPurchase findById(int id) {
        return stockPurchaseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("StockPurchase", id));
    }

    public StockPurchase createPurchase(StockPurchase purchase){
        purchase.setId(0);
        return stockPurchaseRepository.save(purchase);
    }

    public StockPurchase updatePurchase(StockPurchase purchase){
        return stockPurchaseRepository.save(purchase);
    }

    public void deletePurchase(int id){
        stockPurchaseRepository.deleteById(id);
    }
}
