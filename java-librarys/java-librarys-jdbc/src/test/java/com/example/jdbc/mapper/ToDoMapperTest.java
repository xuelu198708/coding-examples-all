package com.example.jdbc.mapper;

import com.example.jdbc.model.ToDo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by xuelu
 * 2020-08-03.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ToDoMapperTest {

    @Autowired
    private ToDoMapper toDoMapper;

    @Test
    public void testSelectByPrimaryKey(){
        ToDo toDo = toDoMapper.selectByPrimaryKey(1L);
        System.out.println(toDo.getContent());
    }


}