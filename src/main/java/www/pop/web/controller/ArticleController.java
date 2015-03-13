package www.pop.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import www.pop.article.domain.Article;

@Controller
@RequestMapping("article")
public class ArticleController {

	/**
	 * 리스트
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Article> list(
			@RequestParam HashMap<String, Object> param) {
		List<Article> result = new ArrayList<Article>();
		Article article1 = new Article();
		article1.setId(1L);
		article1.setTitle("hello, world");
		article1.setContent("hello, world!!!!");
		article1.setRegDate(new Date());
		result.add(article1);

		Article article2 = new Article();
		article2.setId(2L);
		article2.setTitle("hello, world2");
		article2.setContent("hello, world!!!!");
		article2.setRegDate(new Date());
		result.add(article2);
		return result;
	}

	/**
	 * 상세 조회
	 * 
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody Article get() {
		Article article1 = new Article();
		article1.setId(1L);
		article1.setTitle("hello, world");
		article1.setContent("hello, world!!!!");
		article1.setRegDate(new Date());
		return article1;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public @ResponseBody Article update(@RequestBody Article article,
			HttpServletRequest request) {
		System.out.println("23");
		return article;
		// TODO:
	}

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Article insert(@RequestBody Article article) {
		// TODO:
		return article;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public @ResponseBody boolean delete(@PathVariable Long id) {
		// TODO:
		return true;
	}
}
