package www.pop.core.repository.jpa;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import www.pop.core.models.entities.Article;
import www.pop.core.repository.ArticleRepo;

@Repository
public class JpaArticleRepo implements ArticleRepo {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Article> get(Map<String, Object> params) {
		Query query = entityManager.createQuery("SELECT a FROM Article a");
		return query.getResultList();
	}

	@Override
	public Article get(Long id) {
		return entityManager.find(Article.class, id);
	}

	@Override
	public Article save(Article article) {
		if (article.getId() == null) {
			entityManager.persist(article);
		}else{
			entityManager.merge(article);
		}
		return article;
	}

	@Override
	public void delete(Long id) {
		entityManager.remove(get(id));
	}
}
