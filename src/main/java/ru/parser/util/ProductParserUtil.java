package ru.parser.util;

import ru.parser.model.Product;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ProductParserUtil
{
    private ProductParserUtil()
    {

    }

    public static List<Product> parseFromXmlToProductList(File file) throws ParserConfigurationException, IOException, SAXException
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(false);
        factory.setNamespaceAware(true);
        factory.setFeature("http://xml.org/sax/features/namespaces", false);
        factory.setFeature("http://xml.org/sax/features/validation", false);
        factory.setFeature("http://apache.org/xml/features/nonvalidating/load-dtd-grammar", false);
        factory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(file);
        NodeList productList = document.getElementsByTagName("product");
        List<Product> allProducts = new ArrayList<>();

        for(int i = 0; i < productList.getLength(); i++)
        {
            Product productObj = new Product();
            Node p = productList.item(i);

            if(p.getNodeType() == Node.ELEMENT_NODE)
            {
                Element product = (Element) p;
                int productId;
                String title;
                String description;
                double rating;
                int inet_price;
                int price;
                URL imageURL;

                try
                {
                    if(product.getElementsByTagName("product_id").item(0).getChildNodes().getLength() > 0)
                    {
                        productId = Integer.valueOf(product.getElementsByTagName("product_id").item(0).getChildNodes().item(0).getNodeValue());
                    }
                    else
                    {
                        Node productIdInCaseOfLack = productList.item(i-1);
                        Element eProduct = (Element) productIdInCaseOfLack;
                        productId = Integer.valueOf(eProduct.getElementsByTagName("product_id").item(0).getChildNodes().item(0).getNodeValue());
                    }
                    price = Integer.valueOf(product.getElementsByTagName("price").item(0).getChildNodes().item(0).getNodeValue());

                    if(product.getElementsByTagName("inet_price").item(0).getChildNodes().getLength() > 0)
                    {
                        inet_price = Integer.valueOf(product.getElementsByTagName("inet_price").item(0).getChildNodes().item(0).getNodeValue());
                    }

                    else
                    {
                        inet_price = price;
                    }
                    imageURL = new URL(product.getElementsByTagName("image").item(0).getChildNodes().item(0).getNodeValue());
                    title = product.getElementsByTagName("title").item(0).getChildNodes().item(0).getNodeValue();
                    description = product.getElementsByTagName("description").item(0).getChildNodes().item(0).getNodeValue();
                    rating = Double.parseDouble(product.getElementsByTagName("rating").item(0).getChildNodes().item(0).getNodeValue());

                    productObj.setProductId(productId);
                    productObj.setTitle(title);
                    productObj.setDescription(description);
                    productObj.setPrice(price);
                    productObj.setInetPrice(inet_price);
                    productObj.setRating(rating);
                    productObj.setImageURL(imageURL);
                    allProducts.add(productObj);

                }
                catch (NullPointerException ex)
                {

                }
        }
    }
     return allProducts;
    }

    /*public static byte[] downloadImFromURL(URL toDownload)
    {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try
        {
            byte [] chunk = new byte[toDownload.openConnection().getContentLength()];
            int byteRead;
            InputStream stream = toDownload.openStream();
            while((byteRead = stream.read(chunk)) > 0)
            {
                outputStream.write(chunk, 0, byteRead);
            }
            stream.close();
            return outputStream.toByteArray();
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return null;
        }
    }*/
}
