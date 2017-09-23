package ru.parser.web;

import ru.parser.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.parser.service.ProductService;

import java.util.List;

public abstract class AbstractProductController
{
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private ProductService service;

    public Product get(int productId)
    {
        log.info("get {}", productId);
        return service.get(productId);
    }

    public void delete(int productId)
    {
        log.info("delete {}", productId);
        service.delete(productId);
    }

    public List<Product> getAll()
    {
        log.info("getAll");
        return service.getAll();
    }

    public Product insert(Product product)
    {
        log.info("insert {}", product);
        return service.insert(product);
    }

    public void update(Product product, int id)
    {
        log.info("update {} with id={}", product, id);
        service.update(product);
    }
}
