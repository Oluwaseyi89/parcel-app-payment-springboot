package com.deextralucid.parcel.paystack.orderpaymentcrud;

import com.deextralucid.parcel.paystack.ordersandpayments.OrderItem;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepo extends JpaRepository<OrderItem, Integer> {
    OrderItem[] findByOrderId(Integer order_id);

    OrderItem findByProductId(int product_id);
}
