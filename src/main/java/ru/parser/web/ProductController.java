package ru.parser.web;

import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.PathVariable;
import ru.parser.model.Product;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.SAXException;
import ru.parser.service.ProductService;
import ru.parser.util.ProductParserUtil;

import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Objects;

@Controller
public class ProductController
{
    @Autowired
    private ProductService service;

    @GetMapping("/")
    public String root()
    {
        return "index";
    }


    @PostMapping("/productsFromFile")
    public String parseFromFile(@RequestParam("file") MultipartFile file, Model model) throws Exception
    {
        File convFile;
        convFile = new File(file.getOriginalFilename());
        file.transferTo(convFile);
        parseToProductsFromFile(convFile);
        model.addAttribute("products", service.getAll());
        convFile.deleteOnExit();
        return "redirect:products";
    }

    @PostMapping("/productsFromUrl")
    public String parseFromUrl(@RequestParam("urlFile") URL url, Model model) throws IOException, ParserConfigurationException, SAXException
    {
        File convFile;
        InputStream inputStream =   url.openStream();
        convFile = File.createTempFile("tmp", ".xml", new File(System.getProperty("user.dir")));
        byte [] binary = IOUtils.toByteArray(inputStream);
        FileUtils.writeByteArrayToFile(convFile, binary);
        parseToProductsFromFile(convFile);
        model.addAttribute("products", service.getAll());
        convFile.deleteOnExit();
        return "redirect:products";
    }

    @GetMapping("/products")
    public String getParsed()
    {
        return "products";
    }

    @GetMapping(value="/products/product/{baseId}")
    public String getForPart(@PathVariable("baseId") int baseId, Model model)
    {
        Product product = service.get(baseId);
        product.setViews(product.getViews() + 1);
        model.addAttribute("product", product);
        return "particularProduct";
    }


  private void parseToProductsFromFile(File file) throws IOException, SAXException, ParserConfigurationException
  {
      for(Product product : ProductParserUtil.parseFromXmlToProductList(file))
      {
          service.insert(product);
      }
  }

}
