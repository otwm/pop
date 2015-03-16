package www.pop.core.services.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import www.pop.core.models.entities.Todo;
import www.pop.core.repository.TodoRepo;
import www.pop.core.services.TodoService;

/**
 * 게시물 서비스 임플
 * 
 * @author kdo
 *
 */
@Service("todoService")
@Transactional
public class TodoServiceImpl implements TodoService {

	@Autowired
	private TodoRepo todoRepo;

	@Override
	public List<Todo> get(Map<String, Object> params) {
		return todoRepo.get(params);
	}

	@Override
	public Todo get(Long id) {
		return todoRepo.get(id);
	}

	@Override
	public Todo save(Todo todo) {
		return todoRepo.save(todo);
	}

	@Override
	public void delete(Long id) {
		todoRepo.delete(id);
	}

}
