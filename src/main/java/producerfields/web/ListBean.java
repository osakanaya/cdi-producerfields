package producerfields.web;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

import producerfields.ejb.RequestBean;
import producerfields.entity.ToDo;

@Named
@ConversationScoped
public class ListBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private RequestBean requestBean;
	
	@NotNull
	private String inputString;
	private ToDo todo;

	public void createTask() {
		this.todo = requestBean.createToDo(inputString);
	}
	
	public String getInputString() {
		return inputString;
	}

	public void setInputString(String inputString) {
		this.inputString = inputString;
	}

	public ToDo getTodo() {
		return todo;
	}

	public void setTodo(ToDo todo) {
		this.todo = todo;
	}

	public List<ToDo> getTodos() {
		return requestBean.getToDos();
	}
}
