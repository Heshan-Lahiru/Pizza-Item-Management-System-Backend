package lk.iuhs.crm.service;

import lk.iuhs.crm.model.ItemModel;

import java.util.List;

public interface ItemService {
    ItemModel  postdata(ItemModel itemModel);

    List<ItemModel> getdata();

    void deletedata(Integer id);

    void updatedata(Integer id, ItemModel itemModel);
}
