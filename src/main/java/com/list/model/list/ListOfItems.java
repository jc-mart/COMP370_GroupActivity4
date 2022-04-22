package com.list.model.list;

import java.util.List;

public interface ListOfItems {
    List<Item> getListItems();
    void setListItems(List<Item> items);
    void sortByPriority(List<Item> items);
    void sortByDate(List<Item> items);
    void addItem(Item item);
    void completeItem(Item item);
}
