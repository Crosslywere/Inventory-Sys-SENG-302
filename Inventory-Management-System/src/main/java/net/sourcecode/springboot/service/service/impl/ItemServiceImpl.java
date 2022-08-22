package net.sourcecode.springboot.service.service.impl;

import net.sourcecode.springboot.exception.ResourceNotFoundException;
import net.sourcecode.springboot.model.Item;
import net.sourcecode.springboot.repository.ItemRepository;
import net.sourcecode.springboot.service.ItemService;
import org.springframework.stereotype.Service;

import java.util.List;

// this class implement the ItemService interface
@Service
public class ItemServiceImpl implements ItemService {

    private ItemRepository itemRepository;

//    We won't need the AutoWired annot. here since we have just one bean or constructor for the itemrepo. class
    public ItemServiceImpl(ItemRepository itemRepository){
        super();
        this.itemRepository = itemRepository;
    }
    @Override
    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Item getItemById(long id) {
//        Optional<Item> item = itemRepository.findById(id);
//        if(item.isPresent()){
//            return item.get();
//        } else {
//            throw new ResourceNotFoundException("Item", "Id", id);
//        }

        return itemRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Item", "id", id));
    }

    @Override
    public Item updateItem(Item item, long id) {
//        we need to check whether item with the given id is in the DB
        Item existingItem = itemRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Item", "Id", id));

//      here we set and get the existing item and then populate in the db
        existingItem.setTitle(item.getTitle());
        existingItem.setCategory(item.getCategory());
        existingItem.setBrand(item.getBrand());
        existingItem.setStock(item.getStock());
        existingItem.setDiscountPercentage(item.getDiscountPercentage());
        existingItem.setDate(item.getDate());
//        id will be auto generated
//        existingItem.setId(item.getId());
//      saving to the db
        itemRepository.save(existingItem);
        return existingItem;
    }

    @Override
    public void deleteItem(long id) {

//        check whether item id exist in the db
        itemRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Item", "id", id));
        itemRepository.deleteById(id);
    }
}
