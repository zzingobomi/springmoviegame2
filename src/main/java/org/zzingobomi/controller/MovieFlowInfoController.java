package org.zzingobomi.controller;

import java.util.List;
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
	
	@GetMapping("/movieflowinfo/{mfno}")	
	public MovieFlowInfo getMovieFlowInfo(@PathVariable("mfno")Long mfno) {		
		
		log.info("Request movieitemname mfno: " + mfno);
		
		Optional<MovieFlowInfo> result = repo.findById(mfno);
		
		// 람다식 이용하는 법.. 공부해야 함
		//result.ifPresent(movieitem -> {
			//strResult = movieitem.getFilename();
		//});
		
		log.info("MFNO : " + result.get().getMfno().toString());
		log.info("FileName : " + result.get().getFilename());
		log.info("TotalTime : " + result.get().getMovietotaltime().toString());
		log.info("SelectTime : " + result.get().getMovieselecttime().toString());		
		
		return result.get();		
	}
	
	@GetMapping("/movienextflowinfo/{mfno}/{buttonindex}")	
	public MovieFlowInfo getMovieNextFlowInfo(@PathVariable("mfno")Long mfno, 
												@PathVariable("buttonindex")int buttonindex) {	
		
		log.info("Request movienextflowinfo mfno: " + mfno);
		log.info("Request movienextflowinfo buttonindex: " + buttonindex);
		
		
		Optional<MovieFlowInfo> resultCur = repo.findById(mfno);		
		List<Long> nextList = resultCur.get().getNextfilefnos();
		
		// 1. 마지막 영상 판단
		if(nextList.isEmpty()) {	
			log.info("------------- MovieGame End -----------------");
			return null;
		}
		
		// 2. ButtonIndex 가 0 이다.
		if(buttonindex == 0) {
			// 1. 무조건 다음으로 넘어가는 영상
			if(checkAbsoluteNextFile(nextList)) {
				buttonindex = 1;
			}
			
			// 2. 유저가 그냥 선택 안한 경우
			MovieFlowInfo noItem = new MovieFlowInfo();
			noItem.setMfno(-1L);
			
			return noItem;			
		}		
		
		Long nextMFNO = nextList.get(buttonindex - 1);
		
		Optional<MovieFlowInfo> nextMovie = repo.findById(nextMFNO);		
		
		return nextMovie.get();	
	}
	
	boolean checkAbsoluteNextFile(List<Long> nextList) {
		for(int i=0; i < nextList.size() - 1; i++) {
			if(nextList.get(i) != nextList.get(i+1)) {
				return false;
			}
		}
		
		return true;
	}

}
