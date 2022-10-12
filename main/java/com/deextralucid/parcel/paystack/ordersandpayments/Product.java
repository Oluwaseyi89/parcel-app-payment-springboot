package com.deextralucid.parcel.paystack.ordersandpayments;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "parcel_product_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String vendor_name;
    private String vendor_phone;
    private String vendor_email;
    private String vend_photo;
    private String prod_cat;
    private String prod_name;
    private String prod_model;
    private String prod_photo;
    private String prod_price;
    private int prod_qty;
    private String prod_disc;
    private String prod_desc;
    private String img_base;
    private String appr_officer;
    private String appr_date;
    private String updated_at;

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVendor_name() {
        return vendor_name;
    }

    public void setVendor_name(String vendor_name) {
        this.vendor_name = vendor_name;
    }

    public String getVendor_phone() {
        return vendor_phone;
    }

    public void setVendor_phone(String vendor_phone) {
        this.vendor_phone = vendor_phone;
    }

    public String getVendor_email() {
        return vendor_email;
    }

    public void setVendor_email(String vendor_email) {
        this.vendor_email = vendor_email;
    }

    public String getVend_photo() {
        return vend_photo;
    }

    public void setVend_photo(String vend_photo) {
        this.vend_photo = vend_photo;
    }

    public String getProd_cat() {
        return prod_cat;
    }

    public void setProd_cat(String prod_cat) {
        this.prod_cat = prod_cat;
    }

    public String getProd_name() {
        return prod_name;
    }

    public void setProd_name(String prod_name) {
        this.prod_name = prod_name;
    }

    public String getProd_model() {
        return prod_model;
    }

    public void setProd_model(String prod_model) {
        this.prod_model = prod_model;
    }

    public String getProd_photo() {
        return prod_photo;
    }

    public void setProd_photo(String prod_photo) {
        this.prod_photo = prod_photo;
    }

    public String getProd_price() {
        return prod_price;
    }

    public void setProd_price(String prod_price) {
        this.prod_price = prod_price;
    }

    public int getProd_qty() {
        return prod_qty;
    }

    public void setProd_qty(int prod_qty) {
        this.prod_qty = prod_qty;
    }

    public String getProd_disc() {
        return prod_disc;
    }

    public void setProd_disc(String prod_disc) {
        this.prod_disc = prod_disc;
    }

    public String getProd_desc() {
        return prod_desc;
    }

    public void setProd_desc(String prod_desc) {
        this.prod_desc = prod_desc;
    }

    public String getImg_base() {
        return img_base;
    }

    public void setImg_base(String img_base) {
        this.img_base = img_base;
    }

    public String getAppr_officer() {
        return appr_officer;
    }

    public void setAppr_officer(String appr_officer) {
        this.appr_officer = appr_officer;
    }

    public String getAppr_date() {
        return appr_date;
    }

    public void setAppr_date(String appr_date) {
        this.appr_date = appr_date;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

}
