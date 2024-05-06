package com.co.linadev.fakestore.domain.dto;

import com.co.linadev.fakestore.domain.utils.valueObjects.ShippingCompany;
import com.co.linadev.fakestore.domain.utils.valueObjects.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShippingDto {

    private String id;
    private String orderId;
    private ShippingCompany shippingCompany;
    private Status status;
    private Date shappingDate;
    private Date estimatedDeliveryDate;
}
