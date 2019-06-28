package com.todo.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.common.Constant;
import com.todo.common.EntitiesName;
import com.todo.dto.TodoDto;
import com.todo.entity.ToDoEntity;
import com.todo.exception.TodoException;
import com.todo.service.ICommonTodoService;
import com.todo.util.CommonUtility;

@RestController
@RequestMapping(value = { "/todo" })
public class TodoController {

	private static final Logger logger = Logger.getLogger(TodoController.class);

	@Autowired
	@Qualifier("TodoServiceImpl")
	ICommonTodoService todoserviceImpl;

	/**
	 * Description : Get All todoList.
	 * 
	 */
	@GetMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, Object>> getTodoList() throws TodoException {
		logger.info("Get All Todo List Called");
		Map<String, Object> todoMap = new HashMap<>();
		todoMap.put(Constant.FUNCTION_TYPE, Constant.GET_TODO_LIST);
		Object responseObject = todoserviceImpl.commonService(todoMap);
		logger.info("Get All Todo List End");
		return new ResponseEntity<>(CommonUtility.prepareResponse(responseObject), HttpStatus.OK);
	}

	/**
	 * Description : Create and Update todoObject.
	 * 
	 */
	@PostMapping(value = "/save", headers = "Accept=application/json")
	public ResponseEntity<Map<String, Object>> createTodo(@RequestBody ToDoEntity todoObject) throws TodoException {
		logger.info("Create todo Called.");
		Map<String, Object> todoMap = new HashMap<>();
		todoMap.put(Constant.FUNCTION_TYPE, Constant.CREATE_TODO);
		todoMap.put(EntitiesName.TODO_ENTITY, todoObject);
		Object responseObject = todoserviceImpl.commonService(todoMap);
		logger.info("Create todo end.");
		return new ResponseEntity<>(CommonUtility.prepareResponse(responseObject), HttpStatus.CREATED);
	}

	/**
	 * Description : Delete todoObjects.
	 * 
	 */
	@DeleteMapping(value = "/delete")
	public ResponseEntity<Map<String, Object>> deleteTodo(@RequestBody TodoDto todoIds) throws TodoException {
		logger.info("Delete todo called.");
		Map<String, Object> todoMap = new HashMap<>();
		todoMap.put(Constant.FUNCTION_TYPE, Constant.DELETE_TODO);
		todoMap.put(Constant.LIST_OF_TODOS, todoIds);
		Object responseObject = todoserviceImpl.commonService(todoMap);
		logger.info("Delete todo end.");
		return new ResponseEntity<>(CommonUtility.prepareResponse(responseObject), HttpStatus.CREATED);
	}

}
