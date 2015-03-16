package www.pop.core.repository.jpa;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import www.pop.core.models.entities.Todo;
import www.pop.core.repository.TodoRepo;

@Repository
public class JpaTodoRepo implements TodoRepo {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Todo> get(Map<String, Object> params) {
		Query query = entityManager.createQuery("SELECT a FROM Todo a");
		return query.getResultList();
	}

	@Override
	public Todo get(Long id) {
		return entityManager.find(Todo.class, id);
	}

	@Override
	public Todo save(Todo todo) {
		if (todo.getId() == null) {
			entityManager.persist(todo);
		} else {
			entityManager.merge(todo);
		}
		return todo;
	}

	@Override
	public void delete(Long id) {
		entityManager.remove(get(id));
	}
}
