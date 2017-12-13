package org.zzingobomi.persistence;

import org.springframework.data.repository.CrudRepository;
import org.zzingobomi.domain.MovieGameItem;

public interface MovieGameItemRepository extends CrudRepository<MovieGameItem, Long> {
	
}
