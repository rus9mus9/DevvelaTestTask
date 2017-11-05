package ru.parser.repository.jpa;

import ru.parser.model.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.parser.repository.ProductRepo;
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
        if(product.getDescription().isEmpty() || product.getDescription().equals("\n"))
        {
            product.setDescription("Описание товара отсутствует.");
        }
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
    public Product get(int baseId)
    {
        return em.find(Product.class, baseId);
    }

    @Transactional
    @Override
    public boolean delete(int baseId)
    {
        return em.createNamedQuery(Product.DELETE)
                .setParameter("id", baseId).
                        executeUpdate() != 0;
    }

    @Override
    public List<Product> getAll()
    {
        return em.createNamedQuery(Product.GET_ALL, Product.class).getResultList();
    }

    @Override
    public int getViews(int id)
    {
        return em.createNamedQuery(Product.GET_VIEWS, Product.class).getSingleResult().getViews();
    }
}
