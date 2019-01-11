package com.vedatech.admin.data.user;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Getter
@Setter
@Entity
@Table(name = "authorities", uniqueConstraints= {@UniqueConstraint(columnNames= {"user_id", "authority"})})
public class Role implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String authority;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
