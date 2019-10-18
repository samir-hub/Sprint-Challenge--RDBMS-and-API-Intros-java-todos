package com.lambdaschool.oauth2.services;

import com.lambdaschool.oauth2.models.Todo;

public interface TodoService
{
    Todo update(Todo todo,
                long id);

    Todo save(Todo todo);
}
