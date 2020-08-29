package com.altimetric.stockquote.controllar;

import com.altimetric.stockquote.model.Stock;
import com.altimetric.stockquote.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/rest/api/v1/stock")
public class StockControllar {

    private StockService stockService;
    @Autowired
    public StockControllar(StockService stockService) {
        this.stockService = stockService;
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Stock stock)
    {
        stockService.save(stock);
        return new ResponseEntity("save ", HttpStatus.OK);
    }

    @GetMapping("/get/stockQuote")
     public  ResponseEntity<List<Stock>> getStocks(@RequestParam(required = true) String names) {

        String str[] = names.split(",");
        List<String> nameList = new ArrayList<String>(Arrays.asList(str));
        List<String> filterList = new ArrayList<>();
        for(String param :nameList )
        {
            filterList.add(param.trim());
        }
        if(nameList.size() >10)
        {
            return new ResponseEntity(new ArrayList<Stock>(), HttpStatus.BAD_REQUEST);
        }
        System.out.println("Name"+nameList + "filter Size"+filterList);
       return new ResponseEntity(stockService.get(filterList), HttpStatus.OK);

    }
}
