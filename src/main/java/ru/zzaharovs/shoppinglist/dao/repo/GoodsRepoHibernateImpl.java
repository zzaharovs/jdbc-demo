package ru.zzaharovs.shoppinglist.dao.repo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.zzaharovs.shoppinglist.dao.entity.GoodEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class GoodsRepoHibernateImpl implements GoodsRepository {

    @PersistenceContext
    private final EntityManager em;

    @Override
    public List<GoodEntity> getGoods() {

        Query findAllGoods = em.createQuery(
                "select g from GoodEntity g");

        return findAllGoods.getResultList();
    }
}
