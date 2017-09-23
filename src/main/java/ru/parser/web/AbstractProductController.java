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

    public Product get(int baseId)
    {
        log.info("get {}", baseId);
        return service.get(baseId);
    }

    public void delete(int baseId)
    {
        log.info("delete {}", baseId);
        service.delete(baseId);
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

    public void update(Product product, int baseId)
    {
        log.info("update {} with id={}", product, baseId);
        service.update(product);
    }
}
