package www.pop.core.services;

import java.util.List;
import java.util.Map;

import www.pop.core.models.entities.Todo;

/**
 * 
 * @author YoungJoo
 *
 */
public interface TodoService {
	/**
	 * 리스트 조회
	 * 
	 * @return
	 */
	public List<Todo> get(Map<String, Object> params);

	/**
	 * 상세 조회
	 * 
	 * @param id
	 * @return
	 */
	public Todo get(Long id);

	/**
	 * 저장
	 * 
	 * @param todo
	 * @return
	 */
	public Todo save(Todo todo);

	/**
	 * 삭제
	 * 
	 * @param id
	 */
	public void delete(Long id);
}
