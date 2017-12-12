package org.zzingobomi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zzingobomi.domain.WebBoard;
import org.zzingobomi.persistence.WebBoardRepository;
import org.zzingobomi.vo.PageMaker;
import org.zzingobomi.vo.PageVO;

import lombok.extern.java.Log;

@Controller
@RequestMapping("/boards/")
@Log
public class WebBoardController {

	
	@Autowired
	private WebBoardRepository repo;
	
	
	@GetMapping("/list")
	public ModelAndView list(@ModelAttribute("pageVO") PageVO vo) {
		
		Pageable page = vo.makePageable(0, "bno");
		
		Page<WebBoard> result = repo.findAll(repo.makePredicate(vo.getType(), vo.getKeyword()), page);
		
		log.info("" + page);
		log.info("" + result);
		
		log.info("TOTAL PAGE NUMBER: " + result.getTotalPages());		
		
		ModelAndView modelAndView = new ModelAndView("/boards/boardslist");
		modelAndView.addObject("result", new PageMaker(result));
		return modelAndView;
		
		//model.addAttribute("result", new PageMaker(result));
		//modelAndView.addObject("result", new PageMaker(result));
		//modelAndView.setViewName("list");		
	}	
	
	@GetMapping("/register")
	public ModelAndView registerGET(@ModelAttribute("vo")WebBoard vo) {		
		log.info("register get");
		
		ModelAndView modelAndView = new ModelAndView("/boards/boardsregister");
		return modelAndView;
	}
	
	@PostMapping("/register")
	public String registerPOST(@ModelAttribute("vo")WebBoard vo, RedirectAttributes rttr) {
		log.info("register post");
		log.info("" + vo);
		
		repo.save(vo);
		rttr.addFlashAttribute("msg", "success");		
		
		return "redirect:/boards/list";
	}
	
	@GetMapping("/view")
	public ModelAndView view(Long bno, @ModelAttribute("pageVO") PageVO vo) {
		
		log.info("BNO: " + bno);
		
		ModelAndView modelAndView = new ModelAndView("/boards/boardsview");
		
		repo.findById(bno).ifPresent(board -> modelAndView.addObject("vo", board));
		
		return modelAndView;
	}
	
	@GetMapping("/modify")
	public ModelAndView modify(Long bno, @ModelAttribute("pageVO") PageVO vo) {
		
		log.info("MODIFY BNO: " + bno);
		
		ModelAndView modelAndView = new ModelAndView("/boards/boardsmodify");
		
		repo.findById(bno).ifPresent(board -> modelAndView.addObject("vo", board));
		
		return modelAndView;
	}
	
	@PostMapping("/modify")
	public String modifyPost(WebBoard board, PageVO vo, RedirectAttributes rttr) {
		log.info("Modify WebBoard: " + board);
		
		repo.findById(board.getBno()).ifPresent(origin -> {
			origin.setTitle(board.getTitle());
			origin.setContent(board.getContent());
			
			repo.save(origin);
			rttr.addFlashAttribute("msg", "success");
			rttr.addAttribute("bno", origin.getBno());
		});
		
		rttr.addAttribute("page", vo.getPage());
		rttr.addAttribute("size", vo.getSize());
		rttr.addAttribute("type", vo.getType());
		rttr.addAttribute("keyword", vo.getKeyword());		
		
		return "redirect:/boards/view";
	}
	
	@PostMapping("/delete")
	public String delete(Long bno, PageVO vo, RedirectAttributes rttr) {
		
		log.info("DELETE BNO: " + bno);
		
		repo.deleteById(bno);
		
		rttr.addFlashAttribute("msg", "success");
		
		rttr.addAttribute("page", vo.getPage());
		rttr.addAttribute("size", vo.getSize());
		rttr.addAttribute("type", vo.getType());
		rttr.addAttribute("keyword", vo.getKeyword());		
		
		return "redirect:/boards/list";
	}
}
