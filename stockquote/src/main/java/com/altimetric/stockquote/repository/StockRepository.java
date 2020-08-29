package com.altimetric.stockquote.repository;

import com.altimetric.stockquote.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional
public interface StockRepository extends JpaRepository<Stock, Integer> {
    List<Stock> findByStockQuoteIn(List<String> names);                // 1. Spring JPA In clause using method name

    @Query("SELECT e FROM Stock e WHERE e.stockQuote IN (:names)")          // 2. Spring JPA In clause using @Query
    List<Stock> findByStockQuote(@Param("names")List<String> names);

    List<Stock> findByIdIn(List<Integer> list);


}