package br.com.movie.model.network;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.movie.model.bean.MovieBean;
import br.com.movie.model.bean.MovieList;

public class MoviesAPI {
	
	private final String apiKey = "10983a66b000b2b0daf1d3e468679f5c";
	private final String baseURL = "https://api.themoviedb.org/3/movie";
	private final String language = "pt-BR";
	private RestTemplate template;
	private HttpHeaders headers;
	
	public MoviesAPI() {
		template = new RestTemplate();
		headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
	}
	
	public MovieList getMovies(int page) {
		
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(baseURL)
				.pathSegment("popular") 
				.queryParam("api_key", apiKey)
				.queryParam("language", language)
				.queryParam("page", page);
		
		return template.exchange(builder.toUriString(), HttpMethod.GET, entity, MovieList.class).getBody();
	}
	
	public MovieBean getMovie(int id) {
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(baseURL)
				.pathSegment(Integer.toString(id))
				.queryParam("api_key", apiKey)
				.queryParam("language", language);
		
		return template.exchange(builder.toUriString(), HttpMethod.GET, entity, MovieBean.class).getBody();
	}
}
