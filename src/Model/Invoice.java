package Model;

import java.lang.reflect.Field;

public class Invoice {
    private String firstName;
    private String lastName;
    private String email;
    private int product_id;
    private int quantity;
    private double amount;
    private String invoiceDate;
    private String address;
    private String city;
    private int stockCode;
    private String job;
    private static int primaryKey;

    public Invoice(String firstName, String lastName, String email, int product_id, int quantity, double amount,
                   String invoiceDate, String address, String city, int stockCode, String job) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.product_id = product_id;
        this.quantity = quantity;
        this.amount = amount;
        this.invoiceDate = invoiceDate;
        this.address = address;
        this.city = city;
        this.stockCode = stockCode;
        this.job = job;
    }

    public Object getAttribute(int index) throws IllegalAccessException {
        Field[] attributes = Invoice.class.getDeclaredFields();
        if (index >= 0 && index < attributes.length) {
            Field attr = attributes[index];
            attr.setAccessible(true);
            return attr.get(this);
        }
        return null;
    }

    public Object getPrimaryKeyValue() {
        try {
            return this.getAttribute(this.primaryKey);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    /** GETTERS E SETTERS **/
    public static int getPrimaryKey() {
        return primaryKey;
    }

    public static void setPrimaryKey(int primaryKey) {
        Invoice.primaryKey = primaryKey;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getStockCode() {
        return stockCode;
    }

    public void setStockCode(int stockCode) {
        this.stockCode = stockCode;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
