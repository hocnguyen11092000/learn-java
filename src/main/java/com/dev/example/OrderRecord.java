package com.dev.example;

public record OrderRecord(
        String customerName,
        String productName,
        int quantity
) {

}
