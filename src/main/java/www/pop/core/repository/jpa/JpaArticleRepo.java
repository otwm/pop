package www.pop.core.repository.jpa;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.engine.internal.Collections;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import www.pop.core.models.entities.Article;
import www.pop.core.repository.ArticleRepo;

@Repository
public class JpaArticleRepo implements ArticleRepo {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Article> get(Map<String, Object> params) {
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Article.class);

		/*
		 * if (StringUtils.isEmpty(params.get("text"))) { } else
		 */
		if ("titleAndContent".equals(params.get("kind"))) {
			criteria.add(Restrictions.or(
					Restrictions.like("title", "%" + params.get("text") + "%")
							.ignoreCase(),
					Restrictions
							.like("content", "%" + params.get("text") + "%")
							.ignoreCase()));
		} else if ("title".equals(params.get("kind"))) {
			criteria.add(Restrictions.like("title",
					"%" + params.get("text") + "%").ignoreCase());
		} else if ("content".equals(params.get("kind"))) {
			criteria.add(Restrictions.like("content",
					"%" + params.get("text") + "%").ignoreCase());
		} else if ("writer".equals(params.get("kind"))) {
			criteria.add(Restrictions.like("writer",
					"%" + params.get("text") + "%").ignoreCase());
		}
		int firstResult = 0;
		int maxResults = 10;

		if (params.get("firstResult") != null) {
			firstResult = Integer.parseInt((String) params.get("firstResult"));
		}
		if (params.get("maxResults") != null) {
			maxResults = Integer.parseInt((String) params.get("maxResults"));
		}
		return criteria.addOrder(Order.desc("regDate")).setReadOnly(true)
				.setComment("article.find").setFirstResult(firstResult)
				.setMaxResults(maxResults).list();
	}

	@Override
	public Article get(Long id) {
		return entityManager.find(Article.class, id);
	}

	@Override
	public Article save(Article article) {
		if (article.getId() == null) {
			entityManager.persist(article);
		} else {
			entityManager.merge(article);
		}
		return article;
	}

	@Override
	public void delete(Long id) {
		entityManager.remove(get(id));
	}
}
