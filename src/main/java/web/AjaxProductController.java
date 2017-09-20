package web;

import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import service.ProductService;

import java.net.URL;
import java.util.List;


@RestController
@RequestMapping(value = "/ajax/products")
public class AjaxProductController
{
    @Autowired
    private ProductService service;

    @GetMapping(value="/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Product get(@PathVariable("productId") int productId)
    {
       return service.get(productId);
    }

    @DeleteMapping("/{productId}")
    public void delete(@PathVariable("productId") int productId)
    {
        service.delete(productId);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> getAll()
    {
       return service.getAll();
    }

    @PostMapping
    public void createOrUpdate(/*@RequestParam("productId") Integer productId,
                               @RequestParam("title") String title,
                               @RequestParam("description") String description,
                               @RequestParam("price") int price,
                               @RequestParam("inetPrice") int inetPrice,
                               @RequestParam("rating") double rating,
                               @RequestParam("imageURL") URL imageURL*/ Product product) {
       // Product product = new Product(productId, title, description, price, inetPrice, rating, imageURL);
        boolean isNew = true;

        for(Product productComp : service.getAll())
        {
            if(product.getProductId().equals(productComp.getProductId()))
            {
                isNew = false;
                service.update(product);
                break;
            }
        }
        if(isNew)
        service.insert(product);
    }
}
