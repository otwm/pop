package www.pop.core.services.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import www.pop.core.models.entities.Article;
import www.pop.core.repository.ArticleRepo;
import www.pop.core.services.ArticleService;

/**
 * 게시물 서비스 임플
 * 
 * @author kdo
 *
 */
@Service("articleService")
@Transactional
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleRepo articleRepo;

	@Override
	public List<Article> get(Map<String, Object> params) {
		return articleRepo.get(params);
	}

	@Override
	public Article get(Long id) {
		return articleRepo.get(id);
	}

	@Override
	public Article save(Article article) {
		return articleRepo.save(article);
	}

	@Override
	public void delete(Long id) {
		articleRepo.delete(id);
	}

}
