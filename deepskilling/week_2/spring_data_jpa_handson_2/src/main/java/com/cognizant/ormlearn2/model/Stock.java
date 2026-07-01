package com.cognizant.ormlearn2.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "stock")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "st_id")
    private Integer id;
    @Column(name = "st_code")
    private String code;
    @Column(name = "st_date")
    private LocalDate date;
    @Column(name = "st_open")
    private BigDecimal open;
    @Column(name = "st_close")
    private BigDecimal close;
    @Column(name = "st_volume")
    private Long volume;

    public Stock() {
    }

    public Stock(String code, LocalDate date, BigDecimal open, BigDecimal close, Long volume) {
        this.code = code;
        this.date = date;
        this.open = open;
        this.close = close;
        this.volume = volume;
    }

    public String getCode() {
        return code;
    }

    public LocalDate getDate() {
        return date;
    }

    public BigDecimal getClose() {
        return close;
    }

    public Long getVolume() {
        return volume;
    }
}
