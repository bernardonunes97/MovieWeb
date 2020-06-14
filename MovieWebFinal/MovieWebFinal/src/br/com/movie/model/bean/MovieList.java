package br.com.movie.model.bean;
import java.util.List;

public class MovieList {	
	
	private List<MovieBean> results;

	public List<MovieBean> getResults() {
		return results;
	}
	
	@Override
	public String toString() {
		
		String value = "[ ";
		
		for (MovieBean movie : results) {
			value += " Movie: " + movie.getVote() + ",";
		}
		
		value += "]";
		return value;
	}
	
}
