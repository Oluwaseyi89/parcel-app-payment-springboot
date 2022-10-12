package com.deextralucid.parcel.paystack.ordersandpayments;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="parcel_order_paymentdetail")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int order_id;
    private String customer_id;
    private String customer_name;
    private Boolean is_customer;
    private Integer amount;
    private Integer shipping_fee;
    private Integer grand_total_amount;
    private String provider;
    private String payment_type;
    private String status;
    private String reference;
    private String created_at;
    private String updated_at;

    public Payment () {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public Boolean getIs_customer() {
        return is_customer;
    }

    public void setIs_customer(Boolean is_customer) {
        this.is_customer = is_customer;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getShipping_fee() {
        return shipping_fee;
    }

    public void setShipping_fee(Integer shipping_fee) {
        this.shipping_fee = shipping_fee;
    }

    public Integer getGrand_total_amount() {
        return grand_total_amount;
    }

    public void setGrand_total_amount(Integer grand_total_amount) {
        this.grand_total_amount = grand_total_amount;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getPayment_type() {
        return payment_type;
    }

    public void setPayment_type(String payment_type) {
        this.payment_type = payment_type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

}
