package org.zzingobomi.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.zzingobomi.domain.MovieFlowInfo;
import org.zzingobomi.persistence.MovieFlowInfoRepository;

import lombok.extern.java.Log;

@Log
@RestController
public class MovieFlowInfoController {
	
	@Autowired
	private MovieFlowInfoRepository repo;
	
	@GetMapping("/movieitemname/{mfno}")	
	public String getMovieNameByMFNO(@PathVariable("mfno")Long bmno) {		
		
		log.info("Request movieitemname bmno: " + bmno);
		
		Optional<MovieFlowInfo> result = repo.findById(bmno);
		
		//result.ifPresent(movieitem -> {
			//strResult = movieitem.getFilename();
		//});
		
		log.info(result.get().getFilename());
		
		return result.get().getFilename();		
	}

}
