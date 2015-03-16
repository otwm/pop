package www.pop.core.models.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 사용자
 * 
 * @author kdo
 *
 */
//@Entity
public class User {
	/**
	 * 아이디
	 */
//	@Id
//	@GeneratedValue
	private Long id;
	/**
	 * 이름
	 */
	private String name;
	/**
	 * 이메일
	 */
	private String email;
	/**
	 * 이메일 수신 여부
	 */
	private Boolean isRecieveEmail;
	/**
	 * 전화번호
	 */
	private String phone;
	/**
	 * 등록일
	 */
	private Date regDate;
	/**
	 * 수정일
	 */
	private Date modDate;

	/**
	 * 생성자
	 */
	private User regUser;
	/**
	 * 수정자
	 */
	private User modUser;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the isRecieveEmail
	 */
	public Boolean getIsRecieveEmail() {
		return isRecieveEmail;
	}

	/**
	 * @param isRecieveEmail
	 *            the isRecieveEmail to set
	 */
	public void setIsRecieveEmail(Boolean isRecieveEmail) {
		this.isRecieveEmail = isRecieveEmail;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone
	 *            the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the regDate
	 */
	public Date getRegDate() {
		return regDate;
	}

	/**
	 * @param regDate
	 *            the regDate to set
	 */
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	/**
	 * @return the modDate
	 */
	public Date getModDate() {
		return modDate;
	}

	/**
	 * @param modDate
	 *            the modDate to set
	 */
	public void setModDate(Date modDate) {
		this.modDate = modDate;
	}

	/**
	 * @return the regUser
	 */
	public User getRegUser() {
		return regUser;
	}

	/**
	 * @param regUser
	 *            the regUser to set
	 */
	public void setRegUser(User regUser) {
		this.regUser = regUser;
	}

	/**
	 * @return the modUser
	 */
	public User getModUser() {
		return modUser;
	}

	/**
	 * @param modUser
	 *            the modUser to set
	 */
	public void setModUser(User modUser) {
		this.modUser = modUser;
	}

}
