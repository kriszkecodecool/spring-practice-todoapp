package dao;

import java.util.List;

import model.Todo;

public interface TodoDao {
	void insert(Todo todo);

	List<Todo> selectAll();

	Todo select(int id);

}
