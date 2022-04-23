package com.list.model.list;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
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

        assertEquals(priorityItem1.getPriority(), item1.getPriority());
        assertEquals(priorityItem2.getPriority(), item2.getPriority());
        assertEquals(priorityItem3.getPriority(), item3.getPriority());
        assertEquals(item1, aList.get(0));
        assertEquals(item2, aList.get(2));
        assertEquals(item3, aList.get(3));
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

        assertEquals(calendar, item1.getDueDate());
        assertEquals(calendar2, item2.getDueDate());
        assertEquals(calendar3, item3.getDueDate());
        assertEquals("School", aList.indexOf(0));
        assertEquals("Eat", aList.indexOf(1));
        assertEquals("Sleep", aList.indexOf(2));
    }

    @org.junit.jupiter.api.Test
    void addItem() {
        Item item1 = new ItemImpl();
        item1.setItem("Homework");
        aList.add(item1);
        assertEquals("Homework", aList.contains("Homework"));
    }

    @org.junit.jupiter.api.Test
    void remove() {
        Priority high = new PriorityImpl();
        high.setPriority("High");

        Item item1 = new ItemImpl();
        item1.setItem("bread");
        item1.setItemState("Open");
        item1.setPriority(high);
        Calendar calendar = Calendar.getInstance();
        calendar.set(2022,12,1);
        item1.setDueDate(calendar);

        aList.add(item1);
        aList.remove(item1);

        assertEquals("bread", item1.getItem());
        assertEquals("Open", item1.getItemState());
        assertEquals("High", item1.getPriority().getPriority());
        assertEquals(calendar, item1.getDueDate());
        assertTrue(aList.isEmpty());
        assertEquals("Closed", item1.getItemState());
    }
}