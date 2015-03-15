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

import www.pop.core.models.entities.Article;
import www.pop.core.services.ArticleService;

@Controller
@RequestMapping("/article")
public class ArticleController {

	@Autowired(required=false)
	private ArticleService articleService;

	/**
	 * 리스트
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Article> list(
			@RequestParam HashMap<String, Object> params) {
		return articleService.get(params);
	}

	/**
	 * 상세 조회
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody Article get(@PathVariable Long id) {
		return articleService.get(id);
	}

	/**
	 * 수정
	 * 
	 * @param article
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public @ResponseBody Article update(@RequestBody Article article) {
		return articleService.save(article);
	}

	/**
	 * 삽입
	 * 
	 * @param article
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Article insert(@RequestBody Article article) {
		return articleService.save(article);
	}

	/**
	 * 삭제
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public @ResponseBody boolean delete(@PathVariable Long id) {
		articleService.delete(id);
		return true;
	}
}
