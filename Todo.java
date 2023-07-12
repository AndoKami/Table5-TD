package com.todo;

import java.util.Date;

public class Todo {
    private int id;
    private String title;
    private Date deadline;
    private int priority;
    private boolean done;
    private String description;

    public Todo(int id, String title, Date deadline, int priority, boolean done, String description) {
        this.id = id;
        this.title = title;
        this.deadline = deadline;
        this.priority = priority;
        this.done = done;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Date getDeadline() {
        return deadline;
    }

    public int getPriority() {
        return priority;
    }

    public boolean isDone() {
        return done;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "id = " + this.id + "\n" +
                "title : " + this.title + "\n" +
                "deadline : " + this.deadline + "\n" +
                "priority : " + this.priority + "\n" +
                "is done : " + this.done + "\n" +
                "description : '" + this.description + "'";
    }
}
