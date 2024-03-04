package com.nodji.swagger.starter.api;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/movie")
@Tag(name = "Movie", description = "the Movie Api")
public class MovieController {

	ConcurrentHashMap<String, Movie> movies = new ConcurrentHashMap<>();

	Logger logger = LoggerFactory.getLogger(MovieController.class);

	@Operation(summary = "Buscar um filme especifico", description = "buscar uma entidades da filme especifico e seus dados da base de dados")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Sucesso") })
	@GetMapping("/{id}")
	public ResponseEntity<Movie> getMovie(@PathVariable(name = "id") String id) {
		HttpStatus status = HttpStatus.OK;
		if (movies.isEmpty()) {
			status = HttpStatus.NO_CONTENT;
		}
		return new ResponseEntity<>(movies.get(id), status);
	}

	@Operation(summary = "Buscar todas os filmes", description = "buscar todas as entidades da filmes e seus dados da base de dados")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Sucesso") })
	@GetMapping("/list")
	public ResponseEntity<ArrayList<Movie>> getAll(@PathVariable(name = "id") String id) {
		HttpStatus status = HttpStatus.OK;
		if (movies.isEmpty()) {
			status = HttpStatus.NO_CONTENT;
		}
		return new ResponseEntity<>(new ArrayList<>(movies.values()), status);
	}

	@Operation(summary = "Adiciona um filme", description = "adiciona uma entidade da filme e seus dados da base de dados")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Sucesso") })
	@GetMapping("/add")
	public ResponseEntity<Movie> add(@RequestBody Movie movie) {
		HttpStatus status = HttpStatus.OK;
		if (movies.isEmpty()) {
			status = HttpStatus.NO_CONTENT;
		}
		movies.put(movie.getId(), movie);
		return new ResponseEntity<>(movie, status);
	}

}
