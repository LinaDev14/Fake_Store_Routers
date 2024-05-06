package com.co.linadev.fakestore.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleDto {

    private String id;
    private String userId;
    private String productId;
    private String orderId;
}
