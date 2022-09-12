package fr.m2i.spring.lesson.mvc.service;

import fr.m2i.spring.lesson.mvc.exception.BalanceInsufficientException;
import fr.m2i.spring.lesson.mvc.exception.NotEnoughStockException;
import fr.m2i.spring.lesson.mvc.model.Product;
import fr.m2i.spring.lesson.mvc.model.User;
import java.util.List;

public interface IProductService {

    List<Product> findAll();

    Product findById(Long id);

    Product save(Product product);

    void delete(Product product);

    void buyProduct(User user, Product product) throws NotEnoughStockException, BalanceInsufficientException;
}
