package user.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import user.bean.UserDTO;
import user.service.UserService;

@Component
//@Controller
@RequestMapping(value ="user") // /안넣어도 됨
public class UserController {
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value = "writeForm")
	public String writeForm() {
		return "user/writeForm";
	}
	
	@PostMapping(value = "write")
	@ResponseBody
	public void write(@ModelAttribute UserDTO userDTO ) {
		userService.write(userDTO);
	}
	
	@PostMapping(value = "getUser")
	@ResponseBody
	public String checkId(@RequestParam(required = false) String id) {
		System.out.println("id = "+id);
		String isUser = userService.getUser(id);
		System.out.println(isUser);
		
		return isUser;
	}
	
}
