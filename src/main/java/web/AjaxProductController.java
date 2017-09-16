package web;

import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import service.ProductService;

import java.util.List;


@RestController
@RequestMapping("ajax/products")
public class AjaxProductController extends ProductController
{
    @Autowired
    private ProductService service;

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id)
    {
        service.delete(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> getAll()
    {
       return service.getAll();
    }


}
