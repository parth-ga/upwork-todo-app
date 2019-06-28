package com.todo.service;

import java.util.Map;

import com.todo.exception.TodoException;

@FunctionalInterface
public interface ICommonTodoService {

	Object commonService(Map<String, Object> commonServiceMap) throws TodoException;

}
