package com.pos.Inventory.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private String productName;
    private String productDescription;
    private String quantity;
    private String weight;
    private String touch;
    private String category;
    private String supplierId;

}
