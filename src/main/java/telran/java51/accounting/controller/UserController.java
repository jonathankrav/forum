package telran.java51.accounting.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import telran.java51.accounting.dto.NewUserDto;
import telran.java51.accounting.dto.RegisterDto;
import telran.java51.accounting.dto.UserDto;
import telran.java51.accounting.dto.UserRoleDto;
import telran.java51.accounting.service.UserService;


@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class UserController {
	
	final UserService userService;

	@PostMapping("/register")
	public UserDto userRegister(@RequestBody RegisterDto registerDto) {
		return userService.userRegister(registerDto);
	}

	@DeleteMapping("/user/{user}")
	public UserDto removeUser(@PathVariable("user") String login) {
		return userService.removeUser(login);
	}

	@PutMapping("/user/{user}")
	public UserDto updateUser(@PathVariable("user") String login,@RequestBody NewUserDto newUserDto) {
		return userService.updateUser(login, newUserDto);
	}

	@PutMapping("/user/{user}/role/{role}")
	public UserRoleDto addRole(@PathVariable("user") String login,@PathVariable String role) {
		return userService.addRole(login, role);
	}

	@DeleteMapping("/user/{user}/role/{role}")
	public UserRoleDto removeRole(@PathVariable("user") String login,@PathVariable String role) {
		return userService.removeRole(login, role);
	}

	@GetMapping("/user/{user}")
	public UserDto getUser(@PathVariable("user") String login) {
		return userService.getUser(login);
	}

}
