package Segmentation;

import CSV.CSVExportClass;

public class Segmentation implements CSVExportClass {
    private int index;
    private String invoiceNo;
    private String stockCode;
    private String description;
    private int quantity;
    private String invoiceDate;
    private double unitPrice;
    private int customerID;
    private String country;
    private static int primaryKey;

    public Segmentation(int index, String invoiceNo, String stockCode, String description, int quantity, String invoiceDate,
                        double unitPrice, int customerID, String country) {
        this.index = index;
        this.invoiceNo = invoiceNo;
        this.stockCode = stockCode;
        this.description = description;
        this.quantity = quantity;
        this.invoiceDate = invoiceDate;
        this.unitPrice = unitPrice;
        this.customerID = customerID;
        this.country = country;
    }

    public Object getPrimaryKeyValue() {
        Object[] attrs = {index, invoiceNo, stockCode, description, quantity, invoiceDate, unitPrice, customerID, country};
        return attrs[primaryKey];
    }

    public static int getPrimaryKey() {
        return primaryKey;
    }

    public static void setPrimaryKey(int pk) {
        if ( pk >= 0 && pk <= 8 ) {
            primaryKey = pk;
        }else{
            primaryKey = 0;
        }
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String[] toCSV() {
        return new String[] { Integer.toString(index), invoiceNo, stockCode, description, Integer.toString(quantity),
                            invoiceDate, Double.toString(unitPrice), Integer.toString(customerID), country };
    }
}
