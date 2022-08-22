package net.sourcecode.springboot.service;

import net.sourcecode.springboot.model.Item;

import java.util.List;

public interface ItemService {

//    in this interface what we do is specification, and then we implement in our impl class
    Item saveItem(Item item); // specify the method to save or create item and update our database, the parameters Item means that our attribute would be altered and updated
    List<Item> getAllItems(); // specify the method to render all our item once user logs in
    Item getItemById(long id); // specify the method to get each item based on the id inputted.
    Item updateItem(Item item, long id);
    void deleteItem(long id);
}
