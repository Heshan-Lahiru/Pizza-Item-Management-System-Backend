package lk.iuhs.crm.controller;


import lk.iuhs.crm.model.ItemModel;
import lk.iuhs.crm.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ItemController {

    @Autowired
    ItemService itemService;

    @PostMapping("/postdata")
    public ItemModel postdata(@RequestBody ItemModel itemModel) {
        return itemService.postdata(itemModel);
    }

    @GetMapping("/getdata")
    public List<ItemModel> getdata() {
        return itemService.getdata();
    }

    @DeleteMapping("/deletedata/{id}")
    public void deletedata(@PathVariable Integer id) {
        itemService.deletedata(id);
    }

    @PutMapping("/updatedata/{id}")
    public void updatedata(@PathVariable Integer id, @RequestBody ItemModel itemModel) {
        itemService.updatedata(id, itemModel);
    }

}
