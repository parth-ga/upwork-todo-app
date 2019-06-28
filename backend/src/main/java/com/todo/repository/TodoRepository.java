package com.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todo.entity.ToDoEntity;


@Repository
public interface TodoRepository extends JpaRepository<ToDoEntity, Long>{
	

}
