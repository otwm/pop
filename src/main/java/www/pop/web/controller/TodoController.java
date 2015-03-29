package www.pop.web.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import www.pop.core.models.entities.Todo;
import www.pop.core.services.TodoService;

@Controller
@RequestMapping("/todo")
public class TodoController {

	@Autowired(required = false)
	private TodoService todoService;
	
	/**
	 * 리스트 뷰
	 * 
	 * @return
	 */
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String listView() {
		return "/todo/list";
	}

	/**
	 * 리스트
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Todo> list(
			@RequestParam HashMap<String, Object> params) {
		return todoService.get(params);
	}

	/**
	 * 상세 조회
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody Todo get(@PathVariable Long id) {
		return todoService.get(id);
	}

	/**
	 * 수정
	 * 
	 * @param todo
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public @ResponseBody Todo update(@RequestBody Todo todo) {
		return todoService.save(todo);
	}

	/**
	 * 삽입
	 * 
	 * @param todo
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Todo insert(@RequestBody Todo todo) {
		return todoService.save(todo);
	}

	/**
	 * 삭제
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public @ResponseBody boolean delete(@PathVariable Long id) {
		todoService.delete(id);
		return true;
	}
}
