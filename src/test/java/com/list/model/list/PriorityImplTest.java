package com.list.model.list;
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

        //Return 1 since item1 has a higher priority than item1
        assertEquals(1, priorityItem1.compareTo(priorityItem2));
        assertEquals("Feed dog", aList.indexOf(0));
        assertEquals("Feed myself", aList.indexOf(1));
    }
}