package com.kevinicky.springbootcrudfile.transaction.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Transaction {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("itemName")
    private String itemName;

    @JsonProperty("quantity")
    private Long quantity;

    @JsonProperty("price")
    private BigDecimal price;

}
