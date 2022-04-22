package com.list.model.list;

import java.util.Calendar;
import java.util.Date;

public interface Item {
    String getItem();
    void setItem(String item);
    Calendar getDueDate();
    void setDueDate(Calendar dueDate);
    Priority getPriority();
    void setPriority(Priority priority);
    void setItemState(String itemState);
}
