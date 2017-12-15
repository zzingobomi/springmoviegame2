package org.zzingobomi;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import javax.sound.midi.MidiDevice.Info;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.zzingobomi.domain.MovieFlowInfo;
import org.zzingobomi.persistence.MovieFlowInfoRepository;

import com.jayway.jsonpath.MapFunction;

import lombok.extern.java.Log;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
@Commit
public class MovieFlowInfoRepositoryTests {

	@Autowired
	MovieFlowInfoRepository repo;


	@Test
	public void insertMovieFlowInfoDummies() {	
		
		// Sample1
		MovieFlowInfo movieFlowInfo1 = new MovieFlowInfo();
		movieFlowInfo1.setFilename("Chapter_01");
		movieFlowInfo1.setMovietotaltime(20F);
		movieFlowInfo1.setMovieselecttime(10F);
		  
		List<Long> nextfilefnos1 = new ArrayList<>(); 
		nextfilefnos1.add(2L);
		nextfilefnos1.add(3L); 
	
		movieFlowInfo1.setNextfilefnos(nextfilefnos1);
		  
		repo.save(movieFlowInfo1);
		
		
		// Sample2
		MovieFlowInfo movieFlowInfo2 = new MovieFlowInfo();
		movieFlowInfo2.setFilename("Chapter_02");
		movieFlowInfo2.setMovietotaltime(20F);
		movieFlowInfo2.setMovieselecttime(10F);
		  
		List<Long> nextfilefnos2 = new ArrayList<>(); 
		nextfilefnos2.add(4L);
		nextfilefnos2.add(5L); 
	
		movieFlowInfo2.setNextfilefnos(nextfilefnos2);
		  
		repo.save(movieFlowInfo2);
		
		// Sample3
		MovieFlowInfo movieFlowInfo3 = new MovieFlowInfo();
		movieFlowInfo3.setFilename("Chapter_03");
		movieFlowInfo3.setMovietotaltime(20F);
		movieFlowInfo3.setMovieselecttime(10F);
		  
		List<Long> nextfilefnos3 = new ArrayList<>(); 
		nextfilefnos3.add(6L);
		nextfilefnos3.add(7L); 		
		movieFlowInfo3.setNextfilefnos(nextfilefnos3);
		  
		repo.save(movieFlowInfo3);
		
		// Sample4
		MovieFlowInfo movieFlowInfo4 = new MovieFlowInfo();
		movieFlowInfo4.setFilename("Chapter_04");		
		movieFlowInfo4.setMovietotaltime(20F);
		movieFlowInfo4.setMovieselecttime(10F);
		  
		repo.save(movieFlowInfo4);
		
		// Sample5
		MovieFlowInfo movieFlowInfo5 = new MovieFlowInfo();
		movieFlowInfo5.setFilename("Chapter_05");	
		movieFlowInfo5.setMovietotaltime(20F);
		movieFlowInfo5.setMovieselecttime(10F);
		  
		repo.save(movieFlowInfo5);
		
		// Sample6
		MovieFlowInfo movieFlowInfo6 = new MovieFlowInfo();
		movieFlowInfo6.setFilename("Chapter_06");		
		movieFlowInfo6.setMovietotaltime(20F);
		movieFlowInfo6.setMovieselecttime(10F);
		  
		repo.save(movieFlowInfo6);
		
		// Sample7
		MovieFlowInfo movieFlowInfo7 = new MovieFlowInfo();
		movieFlowInfo7.setFilename("Chapter_07");	
		movieFlowInfo7.setMovietotaltime(20F);
		movieFlowInfo7.setMovieselecttime(10F);
		  
		repo.save(movieFlowInfo7);
	}
	
	/*
	@Test
	public void testRead() {
		Optional<MovieFlowInfo> result = repo.findById(3L);
		result.ifPresent(movie -> {
			List<Long> nexlists = movie.getNextfilefnos();
			
			log.info("Index[0] : " + nexlists.get(0).toString());
			log.info("Index[1] : " + nexlists.get(1).toString());
			
			//for (Long next : nexlists) {
				//log.info("Next : " + next);
			//}			
		});
	}
	*/
}
