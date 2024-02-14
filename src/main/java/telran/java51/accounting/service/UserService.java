package telran.java51.accounting.service;

import telran.java51.accounting.dto.UserRoleDto;
import telran.java51.accounting.dto.NewUserDto;
import telran.java51.accounting.dto.RegisterDto;
import telran.java51.accounting.dto.RoleDto;
import telran.java51.accounting.dto.UserDto;

public interface UserService {
	
	UserDto userRegister (RegisterDto registerDto);
	
	UserDto removeUser (String login);
	
	UserDto updateUser (String login, NewUserDto newUserDto);
	
	UserRoleDto addRole(String login, RoleDto role);
	
	UserRoleDto removeRole (String login, RoleDto role);
	
	UserDto getUser (String login);
	

}
