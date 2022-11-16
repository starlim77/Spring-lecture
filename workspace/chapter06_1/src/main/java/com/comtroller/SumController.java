package com.comtroller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bean.SumDTO;

@Controller
public class SumController {
	
	//@GetMapping
	//@PostMapping
	@RequestMapping(value = "/input.do", method = RequestMethod.GET)
	public String input() {
		return "input";
	}
	
//	@RequestMapping(value = "/result.do", method = RequestMethod.GET)
//	public ModelAndView result(SumDTO sumDTO, HttpServletRequest request) {
////	public ModelAndView result(@RequestParam int x, @RequestParam int y) {
////	public ModelAndView result(@RequestParam(required = false, defaultValue="0") String x,
//		 					// @RequestParam(reuqired = flase, defaultValue="0") String y) {
//		
//		int x = Integer.parseInt(request.getParameter("x"));
//		int y = Integer.parseInt(request.getParameter("y"));
//		
//		sumDTO.setX(x);
//		sumDTO.setY(y);
//		sumDTO.sum();
//		
//		ModelAndView mav = new ModelAndView();
//		String result = sumDTO.getX() + " + " + sumDTO.getY() + " = " + sumDTO.getSum();
//		mav.addObject("result", result);
//		mav.setViewName("result");
//		return mav;
//	}
	
	
//	@GetMapping(value = "/result.do")
//	public String result(@RequestParam Map<String,String> map, ModelMap modelMap) {
//	  
//		modelMap.put("x", map.get("x"));
//		modelMap.put("y", map.get("y"));
//	  
//		return "result";
//	}
	
//	@GetMapping(value = "/result.do")
//	public String result(@ModelAttribute SumDTO sumDTO, ModelMap modelMap) {
//		
//		modelMap.put("x", sumDTO.getX());
//		modelMap.put("y", sumDTO.getY());
//	  
//		return "result";
//  }
	
	@GetMapping(value = "/result.do")
	public String result(@ModelAttribute SumDTO sumDTO, Model model) {
		
		model.addAttribute("x", sumDTO.getX());
		model.addAttribute("y", sumDTO.getY());
	  
		return "result";
  }
	
	
}
