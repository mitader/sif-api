package org.fao.mozfis.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.fao.mozfis.core.entity.BaseEntity;

/**
 * The domain entity for Users
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {

	@NotNull
	@Size(min = 8, max = 20)
	private String username;

	@NotNull
	private String password;

	@NotNull
	private String fullname;

	@Email
	private String email;
	private String phone;

	@NotNull
	@Column(name = "province_id", nullable = false, insertable = false, updatable = false)
	private Long provinceId;

	@NotNull
	@Column(name = "access_profile_id", nullable = false, insertable = false, updatable = false)
	private Long accessProfileId;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Long getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Long provinceId) {
		this.provinceId = provinceId;
	}

	public Long getAccessProfileId() {
		return accessProfileId;
	}

	public void setAccessProfileId(Long accessProfileId) {
		this.accessProfileId = accessProfileId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserEntity other = (UserEntity) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

}