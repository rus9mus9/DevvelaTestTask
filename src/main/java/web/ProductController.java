package web;

import model.Product;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.SAXException;
import service.ProductService;
import util.ProductParserUtil;

import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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

    @GetMapping("/products/delete")
    public String delete(HttpServletRequest request)
    {
        service.delete(getId(request));
        return "redirect:/products";
    }

    @GetMapping("/products/update")
    public String update(HttpServletRequest request, Model model) {
        model.addAttribute("product", getId(request));
        return "productForm";
    }

    @GetMapping("/products/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "productForm";
    }

    @PostMapping("/products")
    public String parse(@RequestParam("file") MultipartFile file, @RequestParam("urlFile") URL url, Model model) throws IOException, SAXException, ParserConfigurationException
    {
        File convFile = null;

        if(file != null)
        {
            convFile = new File(file.getOriginalFilename());
            file.transferTo(convFile);
        }
        else if(url != null)
        {
            String tDir = System.getProperty("java.io.tmpdir");
            String path = tDir + "tmp" + ".xml";
            convFile = new File(path);
            convFile.deleteOnExit(); FileUtils.copyURLToFile(url, convFile);
        }

        for(Product product : ProductParserUtil.parseFromXmlToProductList(convFile))
        {
            service.insert(product);
        }
        model.addAttribute("products", service.getAll());
        convFile.delete();
        return "redirect:products";
    }

    @GetMapping("/products")
    public String getParsed(Model model)
    {
        model.addAttribute("products", service.getAll());
        return "products";
    }

   /* @PostMapping("/products")*/
   /* public String updateOrCreate(HttpServletRequest request) {
        Product product = new Product(getId(request), request.getParameter("title"),
                request.getParameter("description"),
                Integer.valueOf(request.getParameter("price")),
                Integer.valueOf(request.getParameter("inetPrice")),
                Double.valueOf(request.getParameter("rating")),
                request.getParameter("image").getBytes());

        if (product.getProductId() == null) {
            service.insert(product);
        } else {
            service.update(product);
        }
        return "redirect:/products";
    }*/

    private int getId(HttpServletRequest request)
    {
        String paramId = Objects.requireNonNull(request.getParameter("id"));
        return Integer.valueOf(paramId);
    }

}
