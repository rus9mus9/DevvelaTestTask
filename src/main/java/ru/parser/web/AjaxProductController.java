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
    @GetMapping(value="/{baseId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Product get(@PathVariable("baseId") int baseId)
    {
       return super.get(baseId);
    }

    @DeleteMapping("/{baseId}")
    public void delete(@PathVariable("baseId") int baseId)
    {
        super.delete(baseId);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> getAll()
    {
       return super.getAll();
    }

    @PostMapping
    public ResponseEntity<String> update(@Valid Product product, BindingResult result)
    {
        if (result.hasErrors()) {
            StringJoiner joiner = new StringJoiner("<br>");
            result.getFieldErrors().forEach(
                    fe -> {
                        String msg = fe.getDefaultMessage();
                        joiner.add(msg);
                    });
            return new ResponseEntity<>(joiner.toString(), HttpStatus.UNPROCESSABLE_ENTITY);
        }
        if(product.isNew())
        {
        super.insert(product);
        }
        else
            {
                super.update(product, product.getProductId());
            }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
