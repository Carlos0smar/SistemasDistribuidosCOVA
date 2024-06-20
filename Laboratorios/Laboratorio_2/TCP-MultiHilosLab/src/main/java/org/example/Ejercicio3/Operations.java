package org.example.Ejercicio3;

import java.util.List;

public class Operations {
    List<Task> tasks;

    public Operations(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void addTask(String name, String description) {
        Task task = new Task(name, description);
        tasks.add(task);
    }

    public void removeTask(String name) {
        for(Task t  : tasks){
            if(t.getName().equals(name)){
                tasks.remove(t);
                return;
            }
        }
    }
}
