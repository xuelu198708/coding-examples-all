package com.example.jdbc.service;

import com.example.jdbc.mapper.ToDoMapper;
import com.example.jdbc.model.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.Executors;

@Service
public class ToDoService {

    @Autowired
    private ToDoMapper toDoMapper;

    @Transactional
    public boolean createToDo(ToDo toDo){
        int i = toDoMapper.insert(toDo);

        //在新的线程下执行另一段逻辑
        Executors.newSingleThreadExecutor().submit(() -> {
            toDoMapper.insert(toDo);
            throw new RuntimeException("exception");
        });
        return i > 0;
    }
}
