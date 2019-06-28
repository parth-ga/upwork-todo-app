package com.todo.service.impl;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.todo.common.Constant;
import com.todo.common.EntitiesName;
import com.todo.dto.TodoDto;
import com.todo.entity.ToDoEntity;
import com.todo.exception.ErrorCodes;
import com.todo.exception.TodoException;
import com.todo.repository.TodoRepository;
import com.todo.service.ICommonTodoService;

@Service
@Component("TodoServiceImpl")
public class TodoServiceImpl implements ICommonTodoService {

	private static final Logger logger = Logger.getLogger(TodoServiceImpl.class);

	@Autowired
	TodoRepository todoRepository;

	@Override
	public Object commonService(Map<String, Object> map) throws TodoException {

		Object responseObject = null;
		logger.info("contactMap .Type ::" + map.get(Constant.FUNCTION_TYPE));

		if (map.isEmpty()) {
			logger.error("Request must contain some value.");
			throw new TodoException(ErrorCodes.POLICY_VIOLATION, "Request must contain some value.");
		}

		String value = (String) map.get(Constant.FUNCTION_TYPE);
		switch (value) {
		case Constant.CREATE_TODO:
			responseObject = createTodo(map);
			break;

		case Constant.GET_TODO_LIST:
			responseObject = getAllTodoList();
			break;

		case Constant.DELETE_TODO:
			responseObject = deleteTodoList(map);
			break;
		default:
			logger.error("Function type should not be null.");
			break;
		}

		return responseObject;
	}

	private Object deleteTodoList(Map<String, Object> map) throws TodoException {
		TodoDto listOfTodo = (TodoDto) map.get(Constant.LIST_OF_TODOS);

		if (listOfTodo.getTodoIds().isEmpty()) {
			logger.error("List must contain one value.");
			throw new TodoException(ErrorCodes.LIST_EMPTY);
		}
		listOfTodo.getTodoIds().forEach(l -> todoRepository.delete(l));
		
		return "Delete selected records.";
	}

	private Object getAllTodoList() {
		return todoRepository.findAll();
	}

	private Object createTodo(Map<String, Object> map) throws TodoException {
		ToDoEntity todoObject = (ToDoEntity) map.get(EntitiesName.TODO_ENTITY);

		if (todoObject.getName().isEmpty() || todoObject.getName() == null) {
			logger.error("Todo Name is mandatory.");
			throw new TodoException(ErrorCodes.NAME_EMPTY);
		}

		if (todoObject.getDescription().isEmpty() || todoObject.getDescription() == null) {
			logger.error("Description is mndatory.");
			throw new TodoException(ErrorCodes.DESC_EMPTY);
		}

		return todoRepository.save(todoObject);
	}

}
