package com.list.model.list;

public interface Priority {
    String getPriority();
    void setPriority(String priority);
    int compareTo(Priority other);
}
