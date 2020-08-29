package com.altimetric.stockquote.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "stock")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Stock {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @Column
    private String stockQuote;
    @Column
    private String companyName;
    @Column
    private BigDecimal price;
    @Column
    private String currency;
    @Column
    private Date date;

}
