package repository.jdbc;

import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import repository.ProductRepo;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class ProductRepoJdbcImpl implements ProductRepo
{
    private static final RowMapper<Product> ROW_MAPPER = BeanPropertyRowMapper.newInstance(Product.class);

    private final JdbcTemplate jdbcTemplate;

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public ProductRepoJdbcImpl(DataSource dataSource, JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate)
    {
        jdbcTemplate.setDataSource(dataSource);
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public Product update(Product product)
    {
        BeanPropertySqlParameterSource parameterSource = new BeanPropertySqlParameterSource(product);
        namedParameterJdbcTemplate.update("UPDATE products SET " +
                        "title=:title, description=:description, price=:price, inetprice=:inetPrice, rating=:rating, " +
                        "image=:image WHERE id=:productId", parameterSource);
        return product;
    }

    public Product get(int id)
    {
        return DataAccessUtils.singleResult(jdbcTemplate.query("SELECT * FROM products WHERE id=?", ROW_MAPPER, id));
    }

    public boolean delete(int id)
    {
        return jdbcTemplate.update("DELETE FROM products WHERE id=?", id) != 0;
    }

    @Override
    public int getViews(int id)
    {
        return DataAccessUtils.singleResult(jdbcTemplate.query("SELECT * FROM products WHERE id=?", ROW_MAPPER, id)).getViews();
    }


    public List<Product> getBad()
    {
        return jdbcTemplate.query("SELECT * FROM products WHERE rating <= 3.5", ROW_MAPPER);
    }

    public List<Product> getNormal()
    {
        return jdbcTemplate.query("SELECT * FROM products WHERE rating > 3 AND rating <= 4", ROW_MAPPER);
    }

    public List<Product> getGood()
    {
        return jdbcTemplate.query("SELECT * FROM products WHERE rating > 4 AND rating <= 5", ROW_MAPPER);
    }

    public Product insert(Product product)
    {
        jdbcTemplate.update("INSERT INTO products (id, title, description, price, rating, inetprice, image, views) VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
                product.getProductId(), product.getTitle(), product.getDescription(), product.getPrice(), product.getRating(), product.getInetPrice()
                /*product.getImage()*/, 0);
        return product;
    }

    public List<Product> getAll()
    {
        return jdbcTemplate.query("SELECT * FROM products", ROW_MAPPER);
    }
}
