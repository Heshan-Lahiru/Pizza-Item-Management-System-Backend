package lk.iuhs.crm.repository;

import lk.iuhs.crm.entity.ItemEntity;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<ItemEntity,Integer> {
}
