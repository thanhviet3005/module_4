package c0920g1.service;

import java.util.List;

public interface Service<E> {
    List<E> findAll();
    E findById(int id);
    void save(E e);
    void update(E e);
    void remove(int id);
}
