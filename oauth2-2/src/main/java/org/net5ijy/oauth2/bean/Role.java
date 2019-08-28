package org.net5ijy.oauth2.bean;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 角色
 *
 * @author xuguofeng
 * @date 2019/8/28 11:26
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role implements Serializable {

	private static final long serialVersionUID = 8551327484428498338L;

	private Integer id;

	private String name;

	public Role(String name) {
		super();
		this.name = name;
	}
}
