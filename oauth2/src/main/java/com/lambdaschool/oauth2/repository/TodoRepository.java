package com.lambdaschool.oauth2.repository;

import com.lambdaschool.oauth2.models.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Long>
{
}
