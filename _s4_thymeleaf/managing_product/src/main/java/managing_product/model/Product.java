package managing_product.model;

public class Product {
    private int idProduct;
    private String nameProduct;
    private double priceProduct;
    private String imgProduct;
    private int quantity;

    public Product() {
    }

    public Product(int idProduct, String nameProduct, double priceProduct,
                   String imgProduct, int quantity) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
        this.imgProduct = imgProduct;
        this.quantity = quantity;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public double getPriceProduct() {
        return priceProduct;
    }

    public String getImgProduct() {
        return imgProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public void setPriceProduct(double priceProduct) {
        this.priceProduct = priceProduct;
    }

    public void setImgProduct(String imgProduct) {
        this.imgProduct = imgProduct;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
