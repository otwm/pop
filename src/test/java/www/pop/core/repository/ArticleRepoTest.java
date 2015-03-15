package www.pop.core.repository;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import www.pop.core.models.entities.Article;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:config/business-config.xml")
public class ArticleRepoTest {

	@Autowired
	private ArticleRepo repo;

	private Article article;

	@Before
	@Transactional
	@Rollback(false)
	public void setup() {
		article = new Article();
		article.setTitle("title");
		article.setContent("content");
		repo.save(article);
	}

	@Test
	@Transactional
	public void testFind() {
		Article article = repo.get(this.article.getId());
		assertNotNull(article);
		assertEquals(article.getTitle(), "title");
		assertEquals(article.getContent(), "content");
	}
}
