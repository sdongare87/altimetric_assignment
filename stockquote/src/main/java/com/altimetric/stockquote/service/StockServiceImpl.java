package com.altimetric.stockquote.service;

import com.altimetric.stockquote.repository.StockRepository;
import com.altimetric.stockquote.model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StockServiceImpl implements StockService{

    private StockRepository stockRepository;

    @Autowired
    public void setStockRepository(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public void save(Stock stock)
    {
        stockRepository.save(stock);
    }

    @Override
    public List<Stock> get(List<String> nameList)
    {
        return stockRepository.findByStockQuoteIn(nameList);//findByStockQuoteIn(nameList);
    }
}
