package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class TodoList {

    HashMap<String, Task> todoList;

    public TodoList(){
        this.todoList = new HashMap<>();
    }

    public String add(String name){
        if(getToDos().contains(name)){
            return "Task already in list";
        }
        this.todoList.put(name, new Task(name));
        return name + "Added to tasks";
    }

    public ArrayList<String> getToDos(){
        ArrayList<String> listOfNames = new ArrayList<>();
        for(Task task : this.todoList.values()){
            listOfNames.add(task.getName());
        }
        return listOfNames;
    }

    public void changeCompletion(String name) {
        getTask(name).changeCompletion();
    }

    public ArrayList<String> getTasksByCompletion(boolean isComplete){
        ArrayList<String> resComplete = new ArrayList<>();
        ArrayList<String> resInComplete = new ArrayList<>();

        for(Task task: this.todoList.values()){
            if(task.isComplete){
                resComplete.add(task.getName());
            }else {
                resInComplete.add((task.getName()));
            }
        }

        if (isComplete){
            return resComplete;
        }

        return resInComplete;
    }

    public Task getTask(String name) {
        if(getToDos().contains(name)){
            return this.todoList.get(name);
        }
        return null;
    }

    public String getTaskName(String name) {
        if(getToDos().contains(name)){
            return this.todoList.get(name).getName();
        }
        return "Task doesn't exist";
    }


    public String remove(String name){
        if (getToDos().contains(name)){
            this.todoList.remove(name);
            return name + " removed from list";
        }
        return "Task is not in list";

    }

    public ArrayList<String> getListAlphabeticly(boolean ascending){
        ArrayList<String> res = getToDos();
        Collections.sort(res);
        if (!ascending){
            Collections.reverse(res);
        }
        return res;
    }
}
