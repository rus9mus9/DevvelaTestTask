package model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.persistence.*;
import java.util.Arrays;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

@NamedQueries({
        @NamedQuery(name = Product.DELETE, query = "DELETE FROM Product p WHERE p.productId=:id"),
        @NamedQuery(name = Product.GET_ALL, query = "SELECT p FROM Product p"),
        @NamedQuery(name = Product.GET_VIEWS, query = "SELECT p FROM Product p WHERE p.productId=:id"),
})

@Entity
@Table(name = "products")
@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, isGetterVisibility = NONE, setterVisibility = NONE)
public class Product
{
   public static final String DELETE = "Meal.delete";
   public static final String GET_ALL = "Meal.getAll()";
   public static final String GET_VIEWS = "Meal.getViews()";

   @Id
   @Column(name = "id", nullable = false)
   private Integer productId;

   @Column(name = "title")
   private String title;

   @Column(name = "description")
   private String description;

   @Column(name = "price")
   private int price;

   @Column(name = "inetprice")
   private int inetPrice;

   @Column(name = "rating")
   private double rating;

   @Column(name = "image")
   private byte[] image;

   @Column(name = "views")
   private int views;

   @Column(name = "base64Encoded")
   private String base64ImageFile;

   public Product()
   {

   }
    public Product(Integer productId, String title, String description, int price, int inetPrice, double rating, byte[] image)
    {
        this.productId = productId;
        this.title = title;
        this.description = description;
        this.price = price;
        this.inetPrice = inetPrice;
        this.rating = rating;
        this.image = image;
    }

    public String getBase64ImageFile()
    {
        return base64ImageFile;
    }

    public void setBase64ImageFile(String base64ImageFile)
    {
        this.base64ImageFile = base64ImageFile;
    }

    public int getViews()
    {
        return views;
    }

    public void setViews(int views)
    {
        this.views = views;
    }

    public Integer getProductId()
    {
        return productId;
    }

    public double getRating()
    {
        return rating;
    }

    public void setRating(double rating)
    {
        this.rating = rating;
    }

    public void setProductId(Integer productId)
    {
        this.productId = productId;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(int price)
    {
        this.price = price;
    }

    public double getInetPrice()
    {
        return inetPrice;
    }

    public void setInetPrice(int inetPrice)
    {
        this.inetPrice = inetPrice;
    }

    public byte[] getImage()
    {
        return image;
    }

    public void setImage(byte[] image)
    {
        this.image = image;
    }

    public boolean isNew() {return this.productId == null;}

    @Override
    public String toString()
    {
        return "Product{" +
                "productId=" + productId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", inetPrice=" + inetPrice +
                ", rating=" + rating +
                ", image=" + Arrays.toString(image) +
                '}';
    }
}