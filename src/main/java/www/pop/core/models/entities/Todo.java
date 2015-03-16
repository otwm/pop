package www.pop.core.models.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 
 * @author YoungJoo
 *
 */
@Entity
public class Todo {
	/**
	 * id
	 */
	@Id
	@GeneratedValue
	private Long id;

	/**
	 * 내용
	 */
	private String content;

	/**
	 * isDone
	 */
	private Boolean isDone;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Boolean getIsDone() {
		return isDone;
	}

	public void setIsDone(Boolean isDone) {
		this.isDone = isDone;
	}

}
