package lk.iuhs.crm.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lk.iuhs.crm.entity.ItemEntity;
import lk.iuhs.crm.model.ItemModel;
import lk.iuhs.crm.repository.ItemRepository;
import lk.iuhs.crm.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public ItemModel postdata(ItemModel itemModel) {
        ItemEntity itemEntity = objectMapper.convertValue(itemModel, ItemEntity.class);
        itemRepository.save(itemEntity);
        ItemModel itemModel1 = objectMapper.convertValue(itemModel, ItemModel.class);
        return itemModel1;
    }

    @Override
    public List<ItemModel> getdata() {
        Iterable<ItemEntity> all = itemRepository.findAll();

        List<ItemModel> itemarraylist = new ArrayList<>();
        all.forEach(itemEntity -> {
            itemarraylist.add(objectMapper.convertValue(itemEntity,ItemModel.class));
        });
        System.out.println(itemarraylist);
        return itemarraylist;
    }

    @Override
    public void deletedata(Integer id) {
        Optional<ItemEntity> byId = itemRepository.findById(id);
        itemRepository.delete(byId.get());

    }

    @Override
    public void updatedata(Integer id, ItemModel itemModel) {
        Optional<ItemEntity> byId = itemRepository.findById(id);

        ItemEntity itemEntity = byId.get();
        itemEntity.setItemname(itemModel.getItemname());
        itemEntity.setItemprice(itemModel.getItemprice());
        itemEntity.setItemdescription(itemModel.getItemdescription());
        itemRepository.save(itemEntity);

    }


}
