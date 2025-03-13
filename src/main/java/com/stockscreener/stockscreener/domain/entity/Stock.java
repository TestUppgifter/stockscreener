package com.stockscreener.stockscreener.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "stocks")
@Data
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String symbol;

    @Column(nullable = false)
    private String name;

    public Stock(){

    }

    public Stock(String symbol, String name, String exchange, String sector, String industry) {
        this.symbol = symbol;
        this.name = name;
        this.exchange = exchange;
        this.sector = sector;
        this.industry = industry;
    }

    private String exchange;
    private String sector;
    private String industry;

}
