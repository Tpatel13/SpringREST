package Models;



import javax.persistence.*;

@Entity
@Table(name="products")
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    private double price;
    private int  merchantID;

    private String name,info;

    public Product(double price, String name, String info) {
        this.price = price;
        this.name = name;
        this.info = info;
    }

    public Product(double price, String name, String info, int productID) {
        this.price = price;
        this.name = name;
        this.info = info;
        this.id=productID;
    }



    Product(){}


    public Product(double price, String name, String info, int productID, int merchantID) {
        this.price = price;
        this.name = name;
        this.info = info;
        this.merchantID=merchantID;
        this.id=productID;

    }
    public int getMerchantID() {
        return merchantID;
    }

    public void setMerchantID(int merchantID) {
        this.merchantID = merchantID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
    public int getProductID() {
        return id;
    }

    public void setProductID(int productID) {
        this.id = productID;
    }

}
