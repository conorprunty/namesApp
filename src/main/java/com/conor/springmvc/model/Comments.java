package com.conor.springmvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "COMMENTS")
public class Comments {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull
	@NotBlank
	@Column(name = "NAME", nullable = false)
	private String name;

	@Size(min=5, max=100)
	@Column(name = "COMMENTS", nullable = false)
	private String comments;

	@Column(name = "MODCOMMENTS")
	private String modcomments;

	@Column(name = "MODERATED")
	private String moderated;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModerated() {
		return moderated;
	}

	public void setModerated(String moderated) {
		this.moderated = moderated;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getModcomments() {
		return modcomments;
	}

	public void setModcomments(String modcomments) {
		this.modcomments = modcomments;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + id;
		result = prime * result + ((modcomments == null) ? 0 : modcomments.hashCode());
		result = prime * result + ((moderated == null) ? 0 : moderated.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comments other = (Comments) obj;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (id != other.id)
			return false;
		if (modcomments == null) {
			if (other.modcomments != null)
				return false;
		} else if (!modcomments.equals(other.modcomments))
			return false;
		if (moderated == null) {
			if (other.moderated != null)
				return false;
		} else if (!moderated.equals(other.moderated))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Comments [id=" + id + ", name=" + name + ", comments=" + comments + ", modcomments=" + modcomments
				+ ", moderated=" + moderated + "]";
	}

}
