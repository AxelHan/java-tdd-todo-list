package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TodoListTestExtended {

    @Test
    public void testAdd() {
        TodoListExtended todolist = new TodoListExtended();

        todolist.add("Do laundry");
        Assertions.assertEquals("Do laundry", todolist.getTask("Do laundry").getName());
        Assertions.assertEquals("Task already in list", todolist.add("Do laundry"));
        todolist.add("Go fishing");
        Assertions.assertEquals("Go fishing", todolist.getTask("Go fishing").getName());
    }

    @Test
    public void testShowTasks() {
        TodoListExtended todolist = new TodoListExtended();
        ArrayList<String> testList = new ArrayList<>();
        testList.add("Do laundry");
        testList.add("Go fishing");
        todolist.add("Do laundry");
        todolist.add("Go fishing");
        Assertions.assertEquals(testList, todolist.getToDos());
    }
    @Test
    public void testShowTasksWhenEmpty() {
        TodoListExtended todolist = new TodoListExtended();
        ArrayList<String> testList = new ArrayList<>();
        Assertions.assertEquals(testList, todolist.getToDos());
    }

    @Test
    public void testChangeStatus() {
        TodoListExtended todolist = new TodoListExtended();
        todolist.add("Do laundry");

        Assertions.assertFalse((todolist.getTask("Do laundry")).isComplete);

        todolist.changeCompletion("Do laundry");

        Assertions.assertTrue((todolist.getTask("Do laundry")).isComplete);
    }

    @Test
    public void testGetTasksByCompletion() {
        TodoListExtended todolist = new TodoListExtended();
        ArrayList<String> testlistComplete = new ArrayList<>();
        ArrayList<String> testlistInComplete = new ArrayList<>();

        todolist.add("Do laundry");
        todolist.add("Go fishing");
        todolist.add("Cook");

        todolist.changeCompletion("Do laundry");

        testlistComplete.add("Do laundry");
        testlistInComplete.add("Go fishing");
        testlistInComplete.add("Cook");

        Assertions.assertTrue(
                testlistComplete.containsAll(todolist.getTasksByCompletion(true)) &&
                        todolist.getTasksByCompletion(true).containsAll(testlistComplete));
        Assertions.assertTrue(testlistInComplete.containsAll(todolist.getTasksByCompletion(false)) &&
                todolist.getTasksByCompletion(false).containsAll(testlistInComplete));
    }

    @Test
    public void testGetTask(){
        TodoListExtended todolist = new TodoListExtended();
        Assertions.assertEquals("Task doesn't exist" ,todolist.getTaskName("Go fishing"));
        todolist.add("Go fishing");
        Assertions.assertEquals("Go fishing" ,todolist.getTaskName("Go fishing"));
    }

    @Test
    public void testRemoveTaskWhenTaskInList(){
        TodoListExtended todolist = new TodoListExtended();
        todolist.add("Do laundry");
        Assertions.assertTrue(todolist.getToDos().contains("Do laundry"));
        todolist.remove("Do laundry");
        Assertions.assertFalse(todolist.getToDos().contains("Do laundry"));
    }

    @Test
    public void testRemoveTaskWhenTaskNotInList(){
        TodoListExtended todolist = new TodoListExtended();
        Assertions.assertEquals("Task is not in list", todolist.remove("Do laundry"));
    }

    @Test
    public void testSortAlphabetically(){
        TodoListExtended todolist = new TodoListExtended();
        ArrayList<String> testListAscending = new ArrayList<>();
        testListAscending.add("Do homework");
        testListAscending.add("Eat lunch");
        testListAscending.add("Sleep");
        ArrayList<String> testListDescending = new ArrayList<>();
        testListDescending.add("Sleep");
        testListDescending.add("Eat lunch");
        testListDescending.add("Do homework");

        todolist.add("Eat lunch");
        todolist.add("Do homework");
        todolist.add("Sleep");

        Assertions.assertEquals(testListAscending, todolist.getListAlphabeticly(true));
        Assertions.assertEquals(testListDescending, todolist.getListAlphabeticly(false));
    }

//    @Test
//    public void
}