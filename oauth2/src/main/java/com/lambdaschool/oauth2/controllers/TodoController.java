package com.lambdaschool.oauth2.controllers;


import com.lambdaschool.oauth2.models.Todo;
import com.lambdaschool.oauth2.models.User;
import com.lambdaschool.oauth2.services.TodoService;
import com.lambdaschool.oauth2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController
{

    @Autowired
    private TodoService todoService;

    // PUT http://localhost:2019/todos/todoid/3
    @PutMapping(value = "/todoid/{todoid}",
                consumes = {"application/json"})
    public ResponseEntity<?> updateTodo(HttpServletRequest request,
                                        @RequestBody
                                                Todo updateTodo,
                                        @PathVariable
                                                long todoid)
    {

        return new ResponseEntity<>(todoService.update(updateTodo, todoid), HttpStatus.OK);
    }

}
