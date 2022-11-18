package main.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Component
public class MainController {
	
	@RequestMapping(value = "/")
	public String index(HttpServletRequest request) {
		return "index";
	}
	
}
