package ru.zzaharovs.shoppinglist.dao.repo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.zzaharovs.shoppinglist.dao.entity.CustomerEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class CustomerRepoHibernateImpl implements CustomerRepository {

    @PersistenceContext
    private final EntityManager em;

    @Override
    public List<CustomerEntity> getCustomers() {

        em.find(CustomerEntity.class, UUID.randomUUID());

        Query findAllCustomers = em.createQuery(
                "select c from CustomerEntity c ");

        return findAllCustomers.getResultList();
    }
}
