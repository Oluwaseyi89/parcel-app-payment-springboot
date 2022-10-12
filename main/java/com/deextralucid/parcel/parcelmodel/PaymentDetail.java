package com.deextralucid.parcel.parcelmodel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="parcel_order_paymentdetail")
public class PaymentDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    int order_id;
    int customer_id;
    String customer_name;
    int amount;
    String provider;
    String payment_type;
    String status;
    boolean is_customer;
    String created_at;
    String updated_at;


    public void setOrderId(int order_id) {
        this.order_id = order_id;
    }

    public int getOrderId() {
        return order_id;
    }

    public void setCustomerId(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getCustomerId() {
        return customer_id;
    }

    public void setCustomerName(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomerName() {
        return customer_name;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getProvider() {
        return provider;
    }

    public void setPaymentType(String payment_type) {
        this.payment_type = payment_type;
    }

    public String getPaymentType() {
        return payment_type;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setIsCustomer(boolean is_customer) {
        this.is_customer = is_customer;
    }

    public boolean getIsCustomer() {
        return is_customer;
    }

    public void setCreatedAt(String created_at) {
        this.created_at = created_at;
    }

    public String getCreatedAt() {
        return created_at;
    }

    public void setUpdatedAt(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getUpdatedAt() {
        return updated_at;
    }
}
