package ru.parser.web;

import ru.parser.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.StringJoiner;


@RestController
@RequestMapping(value = "/ajax/products")
public class AjaxProductController extends AbstractProductController
{

    /*@Autowired
    private ProductService ru.parser.service;*/

    @GetMapping(value="/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Product get(@PathVariable("productId") int productId)
    {
       /*return ru.parser.service.get(productId); */
       return super.get(productId);
    }

    @DeleteMapping("/{productId}")
    public void delete(@PathVariable("productId") int productId)
    {
        /*ru.parser.service.delete(productId);*/
        super.delete(productId);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> getAll()
    {
       /*return ru.parser.service.getAll();*/
       return super.getAll();
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(@Valid Product product, BindingResult result ) {

        if (result.hasErrors()) {
            StringJoiner joiner = new StringJoiner("<br>");
            result.getFieldErrors().forEach(
                    fe -> {
                        String msg = fe.getDefaultMessage();
                        /*if (!msg.startsWith(fe.getField())) {
                            msg = fe.getField() + ' ' + msg;
                        }*/
                        joiner.add(msg);
                    });
            return new ResponseEntity<>(joiner.toString(), HttpStatus.UNPROCESSABLE_ENTITY);
        }
       // Product product = new Product(productId, title, description, price, inetPrice, rating, imageURL);
        super.insert(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<String> update(@Valid Product product, BindingResult result)
    {

        if (result.hasErrors()) {
            StringJoiner joiner = new StringJoiner("<br>");
            result.getFieldErrors().forEach(
                    fe -> {
                        String msg = fe.getDefaultMessage();
                        if (!msg.startsWith(fe.getField())) {
                            msg = fe.getField() + ' ' + msg;
                        }
                        joiner.add(msg);
                    });
            return new ResponseEntity<>(joiner.toString(), HttpStatus.UNPROCESSABLE_ENTITY);
        }

        super.update(product, product.getProductId());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
