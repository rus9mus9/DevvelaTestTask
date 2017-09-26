package ru.parser.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.net.URL;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

@NamedQueries({
        @NamedQuery(name = Product.DELETE, query = "DELETE FROM Product p WHERE p.baseId=:id"),
        @NamedQuery(name = Product.GET_ALL, query = "SELECT p FROM Product p"),
        @NamedQuery(name = Product.GET_VIEWS, query = "SELECT p FROM Product p WHERE p.baseId=:id"),
})

@Entity
@Table(name = "products")
@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, isGetterVisibility = NONE, setterVisibility = NONE)
public class Product
{
   public static final String DELETE = "Product.delete";
   public static final String GET_ALL = "Product.getAll()";
   public static final String GET_VIEWS = "Product.getViews()";


   @Id
   @SequenceGenerator(name = "base_seq", sequenceName = "base_seq", allocationSize = 1, initialValue = 1)
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "base_seq")
   private Integer baseId;

   @Column(name = "productId")
   @NotNull(message = " ID must not be blank ")
   private Integer productId;

   @Column(name = "title", nullable = false)
   @NotBlank(message = " Title must not be blank ")
   @Pattern(regexp = "^[()+а-яА-ЯёЁa-zA-Z0-9 /-]+$", message = " Title can contain only numbers, Cyrillic, Latin scripts and space char ")
   private String title;

   @Column(name = "description")
   private String description;

   @Column(name = "price")
   @NotNull(message = " Price must not be blank ")
   @Min(value = 1, message = " Price must be greater or equal 1 ")
   private Integer price;

   @Column(name = "inetprice")
   @Min(value = 1, message = " Internet price must be greater or equal 1 ")
   private Integer inetPrice;

   @Column(name = "rating")
   @Min(value = 0, message = " Rating must be between 0.0 and 5.0 ")
   @Max(value = 5, message = " Rating must be between 0.0 and 5.0 ")
   @NotNull(message= "Rating must not be blank ")
   private Double rating;

   @Column(name = "imageurl")
   private URL imageURL;

   @Column(name = "views")
   private Integer views;

    public URL getImageURL()
    {
        return imageURL;
    }

    public void setImageURL(URL imageURL)
    {
        this.imageURL = imageURL;
    }


   public Product()
   {

   }
    public Product(Integer baseId,
                   Integer productId,
                   String title,
                   String description,
                   Integer price,
                   Integer inetPrice,
                   Double rating,
                   URL imageURL) //byte[] image)
    {
        this.baseId = baseId;
        this.productId = productId;
        this.title = title;
        this.description = description;
        this.price = price;
        this.inetPrice = inetPrice;
        this.rating = rating;
        this.imageURL = imageURL;
        //this.image = image;
    }

    /*public String getBase64ImageFile()
    {
        return base64ImageFile;
    }

    public void setBase64ImageFile(String base64ImageFile)
    {
        this.base64ImageFile = base64ImageFile;
    }*/

    public Integer getViews()
    {
        return views;
    }

    public void setViews(Integer views)
    {
        this.views = views;
    }

    public Integer getProductId()
    {
        return productId;
    }

    public Double getRating()
    {
        return rating;
    }

    public void setRating(Double rating)
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

    public Integer getPrice()
    {
        return price;
    }

    public Integer getInetPrice()
    {
        return inetPrice;
    }

    public void setInetPrice(Integer inetPrice)
    {
        this.inetPrice = inetPrice;
    }

 /*   public byte[] getImage()
    {
        return image;
    }

    public void setImage(byte[] image)
    {
        this.image = image;
    }*/


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
                /*", image=" + Arrays.toString(image) */+
                '}';
    }

    public Integer getBaseId()
    {
        return baseId;
    }

    public void setBaseId(Integer baseId)
    {
        this.baseId = baseId;
    }

    public void setPrice(Integer price)
    {
        this.price = price;
    }

    public boolean isNew()
    {
        return this.baseId == null;
    }
}