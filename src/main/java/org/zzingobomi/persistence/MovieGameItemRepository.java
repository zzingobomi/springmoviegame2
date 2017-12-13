package org.zzingobomi.persistence;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.zzingobomi.domain.MovieGameItem;
import org.zzingobomi.domain.QMovieGameItem;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;

public interface MovieGameItemRepository extends CrudRepository<MovieGameItem, Long>, QuerydslPredicateExecutor<MovieGameItem> {
	
	public default Predicate makePredicate(String type, String keyword) {
		
		BooleanBuilder builder = new BooleanBuilder();
		QMovieGameItem movie = QMovieGameItem.movieGameItem;		
		builder.and(movie.mno.gt(0));
		
		if(type == null) {
			return builder;
		}
		
		switch (type) {
		case "t":
			builder.and(movie.title.like("%" + keyword + "%"));
			break;
			
		case "d":
			builder.and(movie.director.like("%" + keyword + "%"));
			break;
			
		case "desc":
			builder.and(movie.description.like("%" + keyword + "%"));
			break;		
		}
		
		return builder;
	}
}
