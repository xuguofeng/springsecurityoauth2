package org.net5ijy.oauth2.bean;

import java.io.Serializable;

public class Role implements Serializable {

	private static final long serialVersionUID = 8551327484428498338L;

	private Integer id;

	private String name;

	public Role() {
		super();
	}

	public Role(String name) {
		super();
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + "]";
	}
}
