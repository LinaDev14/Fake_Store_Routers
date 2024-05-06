package com.co.linadev.fakestore.domain.dto;

import com.co.linadev.fakestore.domain.utils.valueObjects.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDto {

    private String id;
    private PaymentMethod paymentMethod;
    private String details;
}
