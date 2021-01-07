package managing_product.repository;

import managing_product.model.Product;

import java.util.List;

public interface Repository<E> {
    List<E> getAll();
    Product findById(int id);
    boolean saveToList(E e);
    void removeById(int id);
    void updateToList(E e);

//__+__+__+__+__+__+__+__+__+__+
}
