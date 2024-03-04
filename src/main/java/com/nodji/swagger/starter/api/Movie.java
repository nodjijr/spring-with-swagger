package com.nodji.swagger.starter.api;

import lombok.Data;
import lombok.NoArgsConstructor;
import nonapi.io.github.classgraph.json.Id;


@Data
@NoArgsConstructor
public class Movie {

	@Id
	private String id;

	private Integer year;

	private String title;

	private Boolean winner;

}
