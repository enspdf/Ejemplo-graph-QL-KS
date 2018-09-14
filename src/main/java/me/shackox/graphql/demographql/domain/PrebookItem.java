package me.shackox.graphql.demographql.domain;

public class PrebookItem {
    private Long id;
    private Long prebookId;
    private Long productId;
    private String vendorCode;
    private String boxType;
    private String unitType;
    private String markCode;
    private Double unitPrice;

    public PrebookItem() {
    }

    public PrebookItem(Long id, Long prebookId, Long productId, String vendorCode, String boxType, String unitType, String markCode, Double unitPrice) {
        this.id = id;
        this.prebookId = prebookId;
        this.productId = productId;
        this.vendorCode = vendorCode;
        this.boxType = boxType;
        this.unitType = unitType;
        this.markCode = markCode;
        this.unitPrice = unitPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPrebookId() {
        return prebookId;
    }

    public void setPrebookId(Long prebookId) {
        this.prebookId = prebookId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public String getBoxType() {
        return boxType;
    }

    public void setBoxType(String boxType) {
        this.boxType = boxType;
    }

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    public String getMarkCode() {
        return markCode;
    }

    public void setMarkCode(String markCode) {
        this.markCode = markCode;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }
}
