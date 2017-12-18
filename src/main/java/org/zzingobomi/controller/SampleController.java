package org.zzingobomi.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.Transactional;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zzingobomi.domain.MovieFlowInfo;
import org.zzingobomi.domain.MovieGameItem;
import org.zzingobomi.persistence.MovieFlowInfoRepository;
import org.zzingobomi.persistence.MovieGameItemRepository;

import lombok.extern.java.Log;

@RestController
@Log
public class SampleController {
	
	@Autowired
	private MovieGameItemRepository movieGameItemRepository;
	
	@Autowired
	private MovieFlowInfoRepository movieFlowInfoRepository;
	
	@Transactional
	@GetMapping("/addlist") 
	public void addlist() {
		
		///
		/// MovieGameItem -----------------------------------------------------------------
		///
		
		// Sample
		MovieGameItem movie1 = new MovieGameItem();
		movie1.setTitle("Sample");
		movie1.setDirector("zzingo");
		movie1.setDescription("This is sample");
		movie1.setPoster("sampleposter");
		movie1.setStartmfno(1L);
		
		movieGameItemRepository.save(movie1);
		
		
		// InTheRoom
		MovieGameItem intheroom = new MovieGameItem();
		intheroom.setTitle("InTheRoom");
		intheroom.setDirector("zzingo");
		intheroom.setDescription("This is InTheRoom");
		intheroom.setPoster("intheroomposter");
		intheroom.setStartmfno(8L);
		
		movieGameItemRepository.save(intheroom);
		
		
		// InTheRoom
		MovieGameItem tutorial = new MovieGameItem();
		tutorial.setTitle("Tutorial");
		tutorial.setDirector("zzingo");
		tutorial.setDescription("This is Tutorial");
		tutorial.setPoster("tutorialposter");
		tutorial.setStartmfno(11L);
		
		movieGameItemRepository.save(tutorial);
				
				
		
		
		///
		/// MovieFlowInfo -----------------------------------------------------------------
		///
		
		// Sample1		// 1
		MovieFlowInfo movieFlowInfo1 = new MovieFlowInfo();
		movieFlowInfo1.setFilename("Chapter_01");
		movieFlowInfo1.setMovietotaltime(20F);
		movieFlowInfo1.setMovieselecttime(10F);
		  
		List<Long> nextfilefnos1 = new ArrayList<>(); 
		nextfilefnos1.add(2L);
		nextfilefnos1.add(3L); 
	
		movieFlowInfo1.setNextfilefnos(nextfilefnos1);
		  
		movieFlowInfoRepository.save(movieFlowInfo1);
		
		
		// Sample2		// 2
		MovieFlowInfo movieFlowInfo2 = new MovieFlowInfo();
		movieFlowInfo2.setFilename("Chapter_02");
		movieFlowInfo2.setMovietotaltime(20F);
		movieFlowInfo2.setMovieselecttime(10F);
		  
		List<Long> nextfilefnos2 = new ArrayList<>(); 
		nextfilefnos2.add(4L);
		nextfilefnos2.add(5L); 
	
		movieFlowInfo2.setNextfilefnos(nextfilefnos2);
		  
		movieFlowInfoRepository.save(movieFlowInfo2);
		
		// Sample3		// 3
		MovieFlowInfo movieFlowInfo3 = new MovieFlowInfo();
		movieFlowInfo3.setFilename("Chapter_03");
		movieFlowInfo3.setMovietotaltime(20F);
		movieFlowInfo3.setMovieselecttime(10F);
		  
		List<Long> nextfilefnos3 = new ArrayList<>(); 
		nextfilefnos3.add(6L);
		nextfilefnos3.add(7L); 		
		movieFlowInfo3.setNextfilefnos(nextfilefnos3);
		  
		movieFlowInfoRepository.save(movieFlowInfo3);
		
		// Sample4		// 4
		MovieFlowInfo movieFlowInfo4 = new MovieFlowInfo();
		movieFlowInfo4.setFilename("Chapter_04");		
		movieFlowInfo4.setMovietotaltime(20F);
		movieFlowInfo4.setMovieselecttime(10F);
		  
		movieFlowInfoRepository.save(movieFlowInfo4);
		
		// Sample5		// 5
		MovieFlowInfo movieFlowInfo5 = new MovieFlowInfo();
		movieFlowInfo5.setFilename("Chapter_05");	
		movieFlowInfo5.setMovietotaltime(20F);
		movieFlowInfo5.setMovieselecttime(10F);
		  
		movieFlowInfoRepository.save(movieFlowInfo5);
		
		// Sample6		// 6
		MovieFlowInfo movieFlowInfo6 = new MovieFlowInfo();
		movieFlowInfo6.setFilename("Chapter_06");		
		movieFlowInfo6.setMovietotaltime(20F);
		movieFlowInfo6.setMovieselecttime(10F);
		  
		movieFlowInfoRepository.save(movieFlowInfo6);
		
		// Sample7		// 7
		MovieFlowInfo movieFlowInfo7 = new MovieFlowInfo();
		movieFlowInfo7.setFilename("Chapter_07");	
		movieFlowInfo7.setMovietotaltime(20F);
		movieFlowInfo7.setMovieselecttime(10F);
		  
		movieFlowInfoRepository.save(movieFlowInfo7);
		
		
		///////////////////////////////////////////////////////////////////////////////
		
		
		// InTheRoom_01		// 8
		MovieFlowInfo intheroom01 = new MovieFlowInfo();
		intheroom01.setFilename("InTheRoom_01");	
		intheroom01.setMovietotaltime(70F);
		intheroom01.setMovieselecttime(62F);
		
		List<Long> intheroomNextfilefnos = new ArrayList<>(); 
		intheroomNextfilefnos.add(9L);
		intheroomNextfilefnos.add(10L); 
	
		intheroom01.setNextfilefnos(intheroomNextfilefnos);
		  
		movieFlowInfoRepository.save(intheroom01);
		
		// InTheRoom_02_01		// 9
		MovieFlowInfo intheroom02_01 = new MovieFlowInfo();
		intheroom02_01.setFilename("InTheRoom_02_01");	
		intheroom02_01.setMovietotaltime(70F);
		intheroom02_01.setMovieselecttime(62F);
		  
		movieFlowInfoRepository.save(intheroom02_01);
		
		// InTheRoom_02_02		// 10
		MovieFlowInfo intheroom02_02 = new MovieFlowInfo();
		intheroom02_02.setFilename("InTheRoom_02_02");	
		intheroom02_02.setMovietotaltime(70F);
		intheroom02_02.setMovieselecttime(62F);
		  
		movieFlowInfoRepository.save(intheroom02_02);
		
		
		///////////////////////////////////////////////////////////////////////////////
		
		
		// Tutorial_01		// 11
		MovieFlowInfo tutorial01 = new MovieFlowInfo();
		tutorial01.setFilename("Tutorial_01");	
		tutorial01.setMovietotaltime(70F);
		tutorial01.setMovieselecttime(45F);
		
		List<Long> tutorialNextfilefnos = new ArrayList<>(); 
		tutorialNextfilefnos.add(12L);
		tutorialNextfilefnos.add(13L); 
	
		tutorial01.setNextfilefnos(tutorialNextfilefnos);
		  
		movieFlowInfoRepository.save(tutorial01);
		
		// Tutorial_02_01		// 12
		MovieFlowInfo tutorial02_01 = new MovieFlowInfo();
		tutorial02_01.setFilename("Tutorial_02_01");	
		tutorial02_01.setMovietotaltime(70F);
		tutorial02_01.setMovieselecttime(0F);
		
		List<Long> tutorial02_01Nextfilefnos = new ArrayList<>(); 
		tutorial02_01Nextfilefnos.add(14L);
		tutorial02_01Nextfilefnos.add(14L); 
	
		tutorial02_01.setNextfilefnos(tutorial02_01Nextfilefnos);
		  
		movieFlowInfoRepository.save(tutorial02_01);
		
		// Tutorial_02_02		// 13
		MovieFlowInfo tutorial02_02 = new MovieFlowInfo();
		tutorial02_02.setFilename("Tutorial_02_02");	
		tutorial02_02.setMovietotaltime(70F);
		tutorial02_02.setMovieselecttime(0F);
		
		List<Long> tutorial02_02Nextfilefnos = new ArrayList<>(); 
		tutorial02_02Nextfilefnos.add(14L);
		tutorial02_02Nextfilefnos.add(14L); 
	
		tutorial02_02.setNextfilefnos(tutorial02_02Nextfilefnos);
		  
		movieFlowInfoRepository.save(tutorial02_02);
		
		// Tutorial_03		// 14
		MovieFlowInfo tutorial03 = new MovieFlowInfo();
		tutorial03.setFilename("Tutorial_03");	
		tutorial03.setMovietotaltime(70F);
		tutorial03.setMovieselecttime(0F);		
		  
		movieFlowInfoRepository.save(tutorial03);
	}

	/*
	@GetMapping("/hello")	
	public JSONObject sayHello() throws JSONException {
		
		log.info("Hello Request!");
		
		JSONObject json = new JSONObject();
		json.put("result", "Hello JongChan, Bomi. I'm Crazy Happy");

		return json;
		
		//return "Hello JongChan, Bomi. I'm Crazy Happy";
	}
	*/
}
