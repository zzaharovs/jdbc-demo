package ru.zzaharovs.shoppinglist.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.zzaharovs.shoppinglist.dao.entity.GoodEntity;

import java.util.List;
import java.util.UUID;

public interface GoodsRepository extends JpaRepository<GoodEntity, UUID> {



}
