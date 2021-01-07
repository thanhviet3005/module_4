package managing_product.repository;

import managing_product.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements Repository<Product>{
    private static List<Product> productList;

    static {
        productList = new ArrayList<Product>();
        productList.add(new Product(1, "iphone", 200, "https://images.news18.com/ibnlive/uploads/2020/10/1602622490_apple-iphone-12-pro-iphone-12-pro-max.jpg", 30));
        productList.add(new Product(2, "galaxy", 100, "https://store.stormfront.co.uk/content/images/thumbs/0011043_imagejpg.jpeg", 40));
        productList.add(new Product(3, "bphone", 120, "https://cdn.screenguards.co.in/media/catalog/product/cache/11/image/9df78eab33525d08d6e5fb8d27136e95/6/_/6_132_3.jpg", 50));
        productList.add(new Product(4, "nokia", 140, "https://cdn.screenguards.co.in/media/catalog/product/cache/11/image/9df78eab33525d08d6e5fb8d27136e95/6/_/6_132_3.jpg", 20));
        productList.add(new Product(5, "sony", 180, "https://store.stormfront.co.uk/content/images/thumbs/0011043_imagejpg.jpeg", 60));
        productList.add(new Product(6, "samsung", 160, "https://store.stormfront.co.uk/content/images/thumbs/0011043_imagejpg.jpeg", 80));
    }

    @Override
    public List<Product> getAll() {
        return productList;
    }

    @Override
    public Product findById(int id) {
        Product product = new Product();
        for (Product prod : productList) {
            if (prod.getIdProduct() == id){
                product = prod;
                break;
            }
        }
        return product;
    }

    @Override
    public boolean saveToList(Product product) {
        boolean isSave = true;
        for (Product prod : productList) {
            if (prod.getIdProduct() == product.getIdProduct()){
                isSave = false;
                break;
            }
        }
        if (isSave == true){
            productList.add(product);
        }
        return isSave;
    }

    @Override
    public void removeById(int id) {
        Product product = findById(id);
        productList.remove(product);
    }

    @Override
    public void updateToList(Product product) {
        Product pdt = findById(product.getIdProduct());
        int index = productList.indexOf(pdt);
        productList.set(index, product);
    }

//__+__+__+__+__+__+__+__+__+__+
}
