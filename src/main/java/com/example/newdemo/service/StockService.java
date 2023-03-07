package com.example.newdemo.service;

import com.example.newdemo.entity.Stock;
import com.example.newdemo.repository.StockRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class StockService {
    private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    public Stock getStockById(Long id) {
        return stockRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Stock not found with id: " + id));
    }

    public Stock createStock(Stock stock) {
        return stockRepository.save(stock);
    }

    public Stock updateStock(Long id, Stock updatedStock) {
        Stock stock = getStockById(id);
        stock.setProduct(updatedStock.getProduct());
        stock.setQuantity(updatedStock.getQuantity());
        stock.setUpdatedAt(updatedStock.getUpdatedAt());
        return stockRepository.save(stock);
    }

    public void deleteStock(Long id) {
        stockRepository.deleteById(id);
    }
}
