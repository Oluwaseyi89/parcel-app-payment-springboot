package com.deextralucid.parcel.paystack.orderpaymentcrud;

import com.deextralucid.parcel.paystack.ordersandpayments.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ProductRepo extends JpaRepository<Product, Integer> {
    Product findById(int id);
}
