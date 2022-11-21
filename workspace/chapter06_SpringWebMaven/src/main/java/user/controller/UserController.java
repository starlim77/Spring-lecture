package user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import user.bean.UserDTO;
import user.service.UserService;

@Component
//@Controller
@RequestMapping(value ="user") //    /안넣어도 됨
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
	public String checkId(@RequestParam String id) {
//		System.out.println("id = "+id);
		String isUser = userService.getUser(id);
//		System.out.println(isUser);
		
		return isUser;
	}
	
	@GetMapping(value = "list")
	public String list() {
		return "user/list";
	}
	
	@PostMapping(value = "getList")
	@ResponseBody   // List를 json으로 자동으로 바꿔서 jQuery쪽으로 넘겨주게 된다.
	public List<UserDTO> getList() {
		return userService.getList();
	}
	
	@RequestMapping(value = "updateForm")
	public String updateForm() {
		return "user/updateForm";
	}
	
	@RequestMapping(value = "getUpdateUser")
	@ResponseBody
	public UserDTO getUpdateUser(@RequestParam String id) {
		System.out.println(userService.getUpdateUser(id));
		return userService.getUpdateUser(id);
	}
	
	@PostMapping(value = "update")
	@ResponseBody
	public void update(@ModelAttribute UserDTO userDTO) {
		userService.update(userDTO);
	}
	
	@GetMapping(value = "deleteForm")
	public String deleteForm() {
		return "user/deleteForm";
	}
	
	@RequestMapping(value ="delete")
	@ResponseBody
	public void delete(@RequestParam String id) {
		userService.delete(id);
	}
	
}
