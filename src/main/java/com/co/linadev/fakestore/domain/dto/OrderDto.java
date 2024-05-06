package com.co.linadev.fakestore.domain.dto;


import com.co.linadev.fakestore.domain.utils.valueObjects.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    private String id;
    private String userId;
    private String productId;
    private String paymentId;
    private Integer quantity;
    private Double totalOrder;
    private Status status;
    private String statusDescription;
    private Date orderDate;

}
