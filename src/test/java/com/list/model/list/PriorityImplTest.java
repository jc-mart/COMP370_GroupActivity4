package com.list.model.list;

import com.list.model.list.Item;
import com.list.model.list.ItemImpl;
import com.list.model.list.Priority;
import com.list.model.list.PriorityImpl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

class PriorityImplTest {

    @org.junit.jupiter.api.Test
    void compareTo() {
        List<Item> aList = new ArrayList<>();
        Priority priorityItem1 = new PriorityImpl();
        Priority priorityItem2 = new PriorityImpl();
        priorityItem1.setPriority("High");
        priorityItem2.setPriority("Medium");

        Item item1 = new ItemImpl();
        Item item2 = new ItemImpl();
        item1.setItem("Feed cat");
        item1.setPriority(priorityItem1);
        item2.setItem("Feed myself");
        item2.setPriority(priorityItem2);

        aList.add(item1);
        aList.add(item2);

        String a = priorityItem1.getPriority();
        System.out.println(a);
        String b = priorityItem2.getPriority();

        //Return - 5 (first letter number of letters away from each other) since priority for item1 (H)
        // comes before priority for item2 (M)
        assertEquals(-5, a.compareToIgnoreCase(b));
        assertEquals(0, aList.indexOf(item1));
        assertEquals(1, aList.indexOf(item2));
    }
}