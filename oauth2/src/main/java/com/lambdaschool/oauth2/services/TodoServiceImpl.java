package com.lambdaschool.oauth2.services;


import com.lambdaschool.oauth2.models.Todo;
import com.lambdaschool.oauth2.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Date;

@Transactional
@Service(value = "todoService")
public class TodoServiceImpl implements TodoService
{
    @Autowired
    private TodoRepository todorepos;

    @Override
    public Todo update(Todo todo,
                       long id)
    {
        Todo currentTodo = todorepos.findById(id).orElseThrow(() -> new EntityNotFoundException((Long.toString(id))));
        if (todo.getDatestarted() != null){
            currentTodo.setDatestarted(todo.getDatestarted());
        }
        if (todo.getDescription() != null){
            currentTodo.setDescription(todo.getDescription());
        }
        if (todo.isCompleted()){
            currentTodo.setCompleted(true);
        }else{
            currentTodo.setCompleted(false);
        }
        todorepos.save(currentTodo);
        return currentTodo;
    }

    @Override
    public Todo save(Todo todo)
    {
//        Todo newTodo = new Todo();

//        newTodo.setDescription(todo.getDescription());
//        newTodo.setDatestarted(todo.getDatestarted());
//        newTodo.setCompleted(todo.isCompleted());

        return todorepos.save(todo);
    }


}
