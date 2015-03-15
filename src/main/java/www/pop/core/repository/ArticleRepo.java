package www.pop.core.repository;

import java.util.List;
import java.util.Map;

import www.pop.core.models.entities.Article;

/**
 * article repository
 * 
 * @author kdo
 *
 */
public interface ArticleRepo {
	/**
	 * 리스트 조회
	 * 
	 * @return
	 */
	public List<Article> get(Map<String, Object> params);

	/**
	 * 상세 조회
	 * 
	 * @param id
	 * @return
	 */
	public Article get(Long id);

	/**
	 * 저장
	 * 
	 * @param article
	 * @return
	 */
	public Article save(Article article);

	/**
	 * 삭제
	 * 
	 * @param id
	 */
	public void delete(Long id);
}
