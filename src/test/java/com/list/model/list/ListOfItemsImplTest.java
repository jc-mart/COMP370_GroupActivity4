package com.list.model.list;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;


class ListOfItemsImplTest {

    private List<Item> aList = new ArrayList<>();

    @org.junit.jupiter.api.BeforeEach
     void setUp() {
         aList = new ArrayList<>();
     }

    @org.junit.jupiter.api.Test
    void sortByPriority() {
        Priority priorityItem1 = new PriorityImpl();
        Priority priorityItem2 = new PriorityImpl();
        Priority priorityItem3 = new PriorityImpl();
        priorityItem1.setPriority("high");
        priorityItem2.setPriority("medium");
        priorityItem3.setPriority("low");
        Item item1 = new ItemImpl();
        item1.setItem("dog");
        item1.setPriority(priorityItem1);
        Item item2 = new ItemImpl();
        item2.setItem("cat");
        item2.setPriority(priorityItem2);
        Item item3 = new ItemImpl();
        item3.setItem("mouse");
        item3.setPriority(priorityItem3);

        aList.add(item1);
        aList.add(item2);
        aList.add(item3);

        Collections.sort(aList, (o1, o2) -> item1.getPriority().compareTo(item2.getPriority()));

        assertEquals(priorityItem1, item1.getPriority());
        assertEquals(priorityItem2, item2.getPriority());
        assertEquals(priorityItem3, item3.getPriority());
        assertEquals(2, aList.indexOf(item1));
        assertEquals(1, aList.indexOf(item2));
        assertEquals(0, aList.indexOf(item3));
    }

    @org.junit.jupiter.api.Test
    void sortByDate() {
        Item item1 = new ItemImpl();
        Item item2 = new ItemImpl();
        Item item3 = new ItemImpl();

        item1.setItem("School");
        item2.setItem("Eat");
        item3.setItem("Sleep");
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        Calendar calendar3 = Calendar.getInstance();
        calendar.set(2022, 4, 22);
        calendar2.set(2022, 4, 23);
        calendar3.set(2022, 4, 24);
        item1.setDueDate(calendar);
        item2.setDueDate(calendar2);
        item3.setDueDate(calendar3);
        aList.add(item1);
        aList.add(item2);
        aList.add(item3);

        Collections.sort(aList, Comparator.comparing(Item::getDueDate));

        assertEquals(calendar, item1.getDueDate());
        assertEquals(calendar2, item2.getDueDate());
        assertEquals(calendar3, item3.getDueDate());
        assertEquals("School", item1.getItem());
        assertEquals("Eat", item2.getItem());
        assertEquals("Sleep", item3.getItem());
        assertEquals(0, aList.indexOf(item1));
        assertEquals(1, aList.indexOf(item2));
        assertEquals(2, aList.indexOf(item3));
    }

    @org.junit.jupiter.api.Test
    void addItem() {
        Priority high = new PriorityImpl();
        high.setPriority("High");

        Item item1 = new ItemImpl();
        item1.setItem("Homework");
        item1.setPriority(high);
        aList.add(item1);

        assertEquals(high, item1.getPriority());
        assertEquals("Homework", item1.getItem());
        assertTrue(aList.contains(item1));
    }

    @org.junit.jupiter.api.Test
    void completed() {
        Priority high = new PriorityImpl();
        high.setPriority("High");
        high.getPriority();

        Item item1 = new ItemImpl();
        item1.setItem("bread");
        item1.setPriority(high);
        Calendar calendar = Calendar.getInstance();
        calendar.set(2022,12,1);
        item1.setDueDate(calendar);

        aList.add(item1);
        item1.setItemState("Completed");
        aList.remove(item1);

        assertEquals("bread", item1.getItem());
        assertEquals(high, item1.getPriority());
        assertEquals(calendar, item1.getDueDate());
        assertEquals("Completed", item1.getItemState());
        assertTrue(aList.isEmpty());

    }
}