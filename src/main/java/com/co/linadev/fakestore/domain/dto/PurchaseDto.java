package com.co.linadev.fakestore.domain.dto;

import com.co.linadev.fakestore.domain.utils.valueObjects.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseDto {

    private String id;

    private String userId;
    private String productId;
    private Status status;
}
