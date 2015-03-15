package www.pop.web.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import www.pop.core.models.entities.Article;
import www.pop.core.services.ArticleService;

public class ArticleControllerTest {
	@InjectMocks
	private ArticleController controller;

	@Mock
	private ArticleService service;

	private MockMvc mockMvc;

	private ArgumentCaptor<Article> articleCaptor;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		articleCaptor = ArgumentCaptor.forClass(Article.class);
	}
	
	@Test
	public void testList() throws Exception {
		
	}
}
