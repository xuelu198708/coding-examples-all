package com.example.jdbc.service;

import com.example.jdbc.model.ToDo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ToDoServiceTest {

    @Autowired
    private ToDoService toDoService;

    @Test
    public void testCreateToDo(){
        ToDo toDo = new ToDo();
        toDo.setContent("test2");
        toDo.setCreator("xxx");
        toDo.setGmtCreate(new Date());
        toDo.setGmtModified(new Date());
        toDo.setStatus("valid");
        toDo.setType("study");
        toDo.setIsDeleted("0");
        toDoService.createToDo(toDo);
    }
}