package org.zzingobomi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.zzingobomi.domain.MovieGameItem;
import org.zzingobomi.persistence.MovieGameItemRepository;

import lombok.extern.java.Log;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
@Commit
public class MovieGameItemRepositoryTests {
	
	@Autowired
	MovieGameItemRepository repo;
	
	
	@Test
	public void insertMovieGameItemDummies() {
		
		// Sample
		MovieGameItem movie1 = new MovieGameItem();
		movie1.setTitle("Sample");
		movie1.setDirector("zzingo");
		movie1.setDescription("This is sample");
		
		repo.save(movie1);
		
		// InTheRoom
		MovieGameItem movie2 = new MovieGameItem();
		movie2.setTitle("InTheRoom");
		movie2.setDirector("zzingo");
		movie2.setDescription("This is InTheRoom");
		
		repo.save(movie2);
		
		// Tutorial
		MovieGameItem movie3 = new MovieGameItem();
		movie3.setTitle("Tutorial");
		movie3.setDirector("zzingo");
		movie3.setDescription("This is Tutorial");
		
		repo.save(movie3);
	
	}
}
