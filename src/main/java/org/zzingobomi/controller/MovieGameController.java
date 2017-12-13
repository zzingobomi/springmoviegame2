package org.zzingobomi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.zzingobomi.domain.MovieGameItem;
import org.zzingobomi.persistence.MovieGameItemRepository;
import org.zzingobomi.vo.PageMaker;
import org.zzingobomi.vo.PageVO;

import lombok.extern.java.Log;

@Controller
@RequestMapping("/moviegame/")
@Log
public class MovieGameController {
	
	@Autowired
	private MovieGameItemRepository repo;	
	
	@GetMapping("/list")
	public ModelAndView list(@ModelAttribute("pageVO") PageVO vo) {
		
		log.info("MovieGame Request!!");
		
		Pageable page = vo.makePageable(0, "mno");
		
		Page<MovieGameItem> result = repo.findAll(repo.makePredicate(vo.getType(), vo.getKeyword()), page);
		
		log.info("" + page);
		log.info("" + result);
		
		log.info("TOTAL PAGE NUMBER: " + result.getTotalPages());		
		
		ModelAndView modelAndView = new ModelAndView("/moviegame/moviegamelist");
		modelAndView.addObject("result", new PageMaker(result));
		return modelAndView;
	}	
	
	@GetMapping("/view")
	public ModelAndView view(Long mno, @ModelAttribute("pageVO") PageVO vo) {
		
		log.info("MNO: " + mno);
		
		ModelAndView modelAndView = new ModelAndView("/moviegame/moviegameview");
		
		repo.findById(mno).ifPresent(movieitem -> modelAndView.addObject("vo", movieitem));
		
		return modelAndView;
	}

	
	
	/*
	@GetMapping("/addlist") 
	public void addlist() {
		
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
		
		
		// Sample4
		MovieGameItem movie4 = new MovieGameItem();
		movie4.setTitle("Sample4");
		movie4.setDirector("zzingo4");
		movie4.setDescription("This is 4");
		
		repo.save(movie4);
		
		// Sample4
		MovieGameItem movie5 = new MovieGameItem();
		movie5.setTitle("Sample5");
		movie5.setDirector("zzingo5");
		movie5.setDescription("This is 5");
		
		repo.save(movie5);		
	}
	*/
}
