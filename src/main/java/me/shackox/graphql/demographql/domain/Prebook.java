package me.shackox.graphql.demographql.domain;

import java.sql.Timestamp;
import java.util.List;

public class Prebook {
    private Long id;
    private String customerName;
    private String carrierName;
    private String customerPoNumber;
    private Timestamp shipDate;
    private List<PrebookItem> prebookItems;

    public Prebook() {
    }

    public Prebook(Long id, String customerName, String carrierName, String customerPoNumber, Timestamp shipDate, List<PrebookItem> prebookItems) {
        this.id = id;
        this.customerName = customerName;
        this.carrierName = carrierName;
        this.customerPoNumber = customerPoNumber;
        this.shipDate = shipDate;
        this.prebookItems = prebookItems;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCarrierName() {
        return carrierName;
    }

    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }

    public String getCustomerPoNumber() {
        return customerPoNumber;
    }

    public void setCustomerPoNumber(String customerPoNumber) {
        this.customerPoNumber = customerPoNumber;
    }

    public Timestamp getShipDate() {
        return shipDate;
    }

    public void setShipDate(Timestamp shipDate) {
        this.shipDate = shipDate;
    }

    public List<PrebookItem> getPrebookItems() {
        return prebookItems;
    }

    public void setPrebookItems(List<PrebookItem> prebookItems) {
        this.prebookItems = prebookItems;
    }
}
