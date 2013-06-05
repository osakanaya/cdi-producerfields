package producerfields.ejb;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.EJBException;
import javax.ejb.Stateful;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import producerfields.db.UserDatabase;
import producerfields.entity.ToDo;

@ConversationScoped
@Stateful
public class RequestBean {
	@Inject
	@UserDatabase
	EntityManager em;
	
	public ToDo createToDo(String inputString) {
		ToDo todo;
		Date currentTime = Calendar.getInstance().getTime();
		
		try {
			todo = new ToDo();
			todo.setTaskText(inputString);
			todo.setTimeCreated(currentTime);
			
			em.persist(todo);
			
			return todo;
		} catch (Exception e) {
			throw new EJBException(e.getMessage());
		}
	}
	
	public List<ToDo> getToDos() {
		try {
			TypedQuery<ToDo> query = em.createQuery("SELECT t FROM ToDo t ORDER BY t.timeCreated", ToDo.class);
			List<ToDo> todos = query.getResultList();
			
			return todos;
		} catch (Exception e) {
			throw new EJBException(e.getMessage());
		}
		
	}
}
