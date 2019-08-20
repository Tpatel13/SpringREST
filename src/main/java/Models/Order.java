package Models;


import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id;
    private int count;
    private int customerID;
    private int merchantID;
    private int productID;

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getMerchantID() {
        return merchantID;
    }

    public void setMerchantID(int merchantID) {
        this.merchantID = merchantID;
    }

    @Transient

    private Product product;
    @Transient

    private Customer customer;
    @Transient

    private Merchant merchant;

    public Order() {

    }

    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }
//
//    public Order(Product product, int count, int customer, String orderID, Merchant merchant) {
//        this.product = product;
//        this.count = count;
//        this.customerID = customer;
//        this.orderID = orderID;
//        this.merchant = merchant;
//    }


    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public Order(int count, int customerID, int productID, int merchantID) {
        this.productID = productID;
        this.count = count;
        this.customerID = customerID;
        this.merchantID = merchantID;
    }

    public int getCustomer() {
        return customerID;
    }

    public void setCustomer(int customer) {
        this.customerID = customer;
    }



    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
