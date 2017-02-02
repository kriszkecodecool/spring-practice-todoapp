package mainTest;

import java.text.ParseException;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import bo.TodoService;
import config.TodoConfig;
import model.Todo;

public class MyMainMethod {

	public static void main(String[] args) throws ParseException {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(TodoConfig.class);
		// SessionFactory tstfcty = ctx.getBean(SessionFactory.class,
		// "sessionFactory");
		// System.out.println(tstfcty);
		java.util.Date dt = new java.util.Date();

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");

		Date currentTime = (Date) sdf.parse("2017-02-01");
		Todo todo = new Todo("János", "TestDescription", true, currentTime);

		TodoService testTodo = ctx.getBean(TodoService.class, "todoService");

		testTodo.addTodo(todo);

	}

}
