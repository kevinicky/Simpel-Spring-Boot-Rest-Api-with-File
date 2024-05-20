package com.kevinicky.springbootcrudfile.transaction.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TransactionUpdateRequest {

    private Integer id;

    private String itemName;

    private Long quantity;

    private BigDecimal price;

}
