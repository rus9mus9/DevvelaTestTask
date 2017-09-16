package controller;

import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.xml.sax.SAXException;
import service.ProductService;
import util.ProductParserUtil;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class ProductController
{
    private final ProductService service;

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

    public int getViews(int id)
    {
        return service.getViews(id);
    }
}
