package com.altimetric.stockquote.service;

import com.altimetric.stockquote.model.Stock;

import java.util.List;

public interface StockService {
    void save(Stock stock);
    List<Stock> get (List<String> nameList);
}
