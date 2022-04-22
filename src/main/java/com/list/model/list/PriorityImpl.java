package com.list.model.list;

public class PriorityImpl implements Priority {
    private String priority;

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public int compareTo(Priority other) {
        int S = priority.compareTo(other.getPriority());
        return S;
    }
}
