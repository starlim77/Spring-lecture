package com.comtroller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bean.SungJukDTO;

@Controller
public class SungJukController {
	
	@RequestMapping(value = "/input.do", method = RequestMethod.GET)
	public String input() {
		return "input";
	}
	
	@RequestMapping(value = "/result.do", method = RequestMethod.POST)
	public ModelAndView result(@ModelAttribute SungJukDTO sungJukDTO) {
		
		System.out.println(sungJukDTO.getName());
		sungJukDTO.calcTot();
		sungJukDTO.calcAvg();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", sungJukDTO);
		mav.setViewName("result");
		
		return mav;
	}
}
