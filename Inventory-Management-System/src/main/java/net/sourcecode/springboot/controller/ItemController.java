package net.sourcecode.springboot.controller;

import net.sourcecode.springboot.model.Item;
import net.sourcecode.springboot.repository.ItemRepository;
import net.sourcecode.springboot.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/item")
public class ItemController {

//    to enable usage of the defined function in the repository package we use the following
    @Autowired
    ItemRepository itemRepository;

    private ItemService itemService; // with this we are able to use the various method specified in the ItemService

//    CONSTRUCTOR DEPENDENCY INJECTION
    public ItemController(ItemService itemService) {
        super();
        this.itemService = itemService;
    }

//    BUILD CREATE ITEM REST API
//    we use the response-entity class as our return type because we would add some http
//    value and headers like response status etc.
//    request-body annotation allows to retrieve the request-body and convert it to java object
    @PostMapping()
    public ResponseEntity<Item> saveItem(@RequestBody Item item) {
        return new ResponseEntity<Item>(itemService.saveItem(item), HttpStatus.CREATED); // this returns the function specified in the service package, together with the http-status code
    }

//    BUILD GET ALL ITEM REST API
    @GetMapping()
    public List<Item> getAllItem(){
        return itemService.getAllItems();
    }

//    BUILD GET ITEM BY ID REST API
//    http://localhost:8080/api/item/1
    @GetMapping("{id}")
    public ResponseEntity<Item> getItemById(@PathVariable("id") long itemId) {
        return new ResponseEntity<Item>(itemService.getItemById(itemId), HttpStatus.OK);
    }

//    BUILD GET ITEM BY CATEGORY REST API
//    http://localhost:8080/api/item/category?category=smartphones
    @GetMapping("/category")
    public ResponseEntity<List<Item>> getItemByCategory(@RequestParam String category) {
        return new ResponseEntity<List<Item>>(itemRepository.findByCategory(category), HttpStatus.OK);
    }

//    BUILD GET ITEM BY BRAND REST API
//    http://loaclhost:8080/api/item/brand?brand=Apple
    @GetMapping("/brand")
    public ResponseEntity<List<Item>> getItemByBrand(@RequestParam String brand) {
        return new ResponseEntity<List<Item>>(itemRepository.findByBrand(brand), HttpStatus.OK);
    }

//    BUILD UPDATE ITEM REST API
//    http://localhost:8080/api/item/1
    @PutMapping("{id}")
    public ResponseEntity<Item> updateItem(@PathVariable("id") long id, @RequestBody Item item) {
        return new ResponseEntity<Item>(itemService.updateItem(item, id), HttpStatus.OK);
    }

//    BUILD DELETE ITEM REST API
//    http://localhost:8080/api/item/1
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteItem(@PathVariable("id") long id) {

//        delete item from the db
        itemService.deleteItem(id);

        return new ResponseEntity<String>("Item Deleted Successfully", HttpStatus.OK);
    }
}

