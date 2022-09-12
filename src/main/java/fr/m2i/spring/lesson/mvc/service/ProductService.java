package fr.m2i.spring.lesson.mvc.service;

import fr.m2i.spring.lesson.mvc.exception.BalanceInsufficientException;
import fr.m2i.spring.lesson.mvc.exception.NotEnoughStockException;
import fr.m2i.spring.lesson.mvc.model.Product;
import fr.m2i.spring.lesson.mvc.model.User;
import fr.m2i.spring.lesson.mvc.repository.ProductRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {

    private final ProductRepository productRepository;
    private final IUserService userService;

    @Autowired
    public ProductService(ProductRepository productRepository, IUserService userService) {
        this.productRepository = productRepository;
        this.userService = userService;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        Optional<Product> oProduct = productRepository.findById(id);
        return oProduct.orElse(null);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void delete(Product product) {
        productRepository.delete(product);
    }

    @Override
    public void buyProduct(User user, Product product) throws NotEnoughStockException, BalanceInsufficientException {

        if (user == null) {
            return;
        }

        if (product.getQuantity() <= 0) {
            throw new NotEnoughStockException();
        }

        if (user.getBalance() < product.getPrice()) {
            throw new BalanceInsufficientException();
        }

        product.setQuantity(product.getQuantity() - 1);
        userService.decreaseBalance(user, product.getPrice());
        save(product);
    }
}
