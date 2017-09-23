import org.springframework.context.support.GenericXmlApplicationContext;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class SpringTest
{
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException
    {
        try(GenericXmlApplicationContext appCtx = new GenericXmlApplicationContext())
        {
           /* appCtx.getEnvironment().setActiveProfiles("jpa");
            appCtx.load("spring/spring-config.xml", "spring/spring-db.xml");
            appCtx.refresh();
            ProductController controller = appCtx.getBean(ProductController.class);
            for(Product product: ProductParserUtil.parseFromXmlToProductList(new File("src/test/resources/products.xml")))
            {
                controller.insert(product);
            }*/
        }
    }
}
