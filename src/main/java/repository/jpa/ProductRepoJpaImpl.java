package repository.jpa;

import model.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import repository.ProductRepo;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class ProductRepoJpaImpl implements ProductRepo
{

    @PersistenceContext
    private EntityManager em;

    @Transactional
    @Override
    public Product insert(Product product)
    {
        em.persist(product);
        return product;
    }

    @Transactional
    @Override
    public Product update(Product product)
    {
        return em.merge(product);
    }

    @Override
    public Product get(int id)
    {
        return em.find(Product.class, id);
    }

    @Transactional
    @Override
    public boolean delete(int id)
    {
        return em.createNamedQuery(Product.DELETE)
                .setParameter("id", id).
                        executeUpdate() != 0;
    }

    @Override
    public List<Product> getAll()
    {
        return em.createNamedQuery(Product.GET_ALL, Product.class).getResultList();
    }

    @Override
    public List<Product> getBad()
    {
        List<Product> badProd = new ArrayList<>();
        for(Product product : getAll())
        {
            if(product.getRating() <= 3)
            {
                badProd.add(product);
            }
        }
        return badProd;
    }

    @Override
    public List<Product> getNormal()
    {
        List<Product> normProd = new ArrayList<>();
        for(Product product : getAll())
        {
            if(product.getRating() > 3 && product.getRating() <= 4)
            {
                normProd.add(product);
            }
        }
        return normProd;
    }

    @Override
    public List<Product> getGood()
    {
        List<Product> goodProd = new ArrayList<>();
        for(Product product : getAll())
        {
            if(product.getRating() > 4 && product.getRating() <= 5)
            {
                goodProd.add(product);
            }
        }
        return goodProd;
    }

    @Override
    public int getViews(int id)
    {
        return em.createNamedQuery(Product.GET_VIEWS, Product.class).getSingleResult().getViews();
    }
}
