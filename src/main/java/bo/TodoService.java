package bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.TodoDao;
import model.Todo;

@Service
@Transactional
public class TodoService {
	@Autowired
	private TodoDao todoDao;

	public TodoDao getTodoDao() {
		return todoDao;
	}

	public void setTodoDao(TodoDao todoDao) {
		this.todoDao = todoDao;
	}

	@Transactional
	public void addTodo(Todo todo) {
		todoDao.insert(todo);
	}

	public List<Todo> fetchAllTodo() {
		return todoDao.selectAll();
	}

}
