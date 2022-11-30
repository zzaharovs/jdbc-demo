package ru.zzaharovs.shoppinglist.dao.repo;

import ru.zzaharovs.shoppinglist.dao.entity.GoodEntity;

import java.util.List;

public interface GoodsRepository {

    List<GoodEntity> getGoods();

}
