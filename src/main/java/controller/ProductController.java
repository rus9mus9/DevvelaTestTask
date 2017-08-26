package controller;

import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import service.ProductService;

import java.util.List;

@Controller
public class ProductController
{
    private final ProductService service;

    @Autowired
    public ProductController(ProductService service)
    {
        this.service = service;
    }

    public Product insert(Product product)
    {
        return service.insert(product);
    }

    public Product update(Product product)
    {
       return service.update(product);
    }

    public Product get(int id)
    {
        return service.get(id);
    }

    public boolean delete(int id)
    {
       return service.delete(id);
    }


    public List<Product> getBad()
    {
        return service.getBad();
    }

    public List<Product> getNormal()
    {
        return service.getNormal();
    }

    public List<Product> getGood()
    {
        return service.getGood();
    }

    public List<Product> getAll()
    {
        return service.getAll();
    }

    public int getViews(int id) {return service.getViews(id);}
}
