package com.voting.Controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.voting.Dto.UsersDto;
import com.voting.Entity.Users;
import com.voting.Service.UsersService;

@RestController
@RequestMapping("admin")
public class UsersContoller {

	@Autowired
	UsersService usersService;
	
	@PostMapping("/register")
	public String userRegistration(@RequestBody UsersDto userDto)
	{
		 usersService.userRegistation(userDto); 
		 return "success";
	}
	
	@GetMapping("/login")
	public String userLogin(@RequestBody UsersDto userDto){
		return usersService.login(userDto);
	}
	
	@PutMapping("/updateName")
	public String updateName(@RequestBody UsersDto usersDto) {
		return usersService.updateName(usersDto);
	}
	
	@PutMapping("/updateMobileNo")
	public String updateNo(@RequestBody UsersDto usersDto) {
		return usersService.updateMobileNo(usersDto);
	}
	
	@PutMapping("/updateAddress")
	public String updateAddress(@RequestBody UsersDto usersDto) {
		return usersService.updateAddress(usersDto);
	}
	
	@PutMapping("/updatePassword")
	public String updatePassword(@RequestBody UsersDto usersDto) {
		return usersService.updatePassword(usersDto);
	}
	
	@GetMapping("/viewProfile")
	public Optional<Users> viewProfile(@RequestBody UsersDto usersDto) {
		return usersService.viewUserprofile(usersDto);
	}
}
