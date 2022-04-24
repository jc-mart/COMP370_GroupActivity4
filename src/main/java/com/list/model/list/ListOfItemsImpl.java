package com.list.model.list;

import java.util.*;

public class ListOfItemsImpl implements ListOfItems{
    private List<Item> items = new ArrayList<>();


    @Override
    public List<Item> getListItems() {
        return this.items;
    }

    @Override
    public void setListItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public void sortByPriority(List<Item> items) {
        Collections.sort(items, (o1, o2) -> o1.getPriority().compareTo(o2.getPriority()));
    }

    @Override
    public void sortByDate(List<Item> items) {
        Collections.sort(items, Comparator.comparing(Item::getDueDate));
    }

    @Override
    public void addItem(Item item) {
        items.add(item);
    }

    @Override
    public void completed(Item item) {
        item.setItemState("Completed");
        items.remove(item);
    }

}