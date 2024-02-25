package telran.java51.accounting.service;

import telran.java51.accounting.dto.UserRoleDto;
import telran.java51.accounting.dto.NewUserDto;
import telran.java51.accounting.dto.RegisterDto;
import telran.java51.accounting.dto.UserDto;

public interface UserAccountService {
	
	UserDto userRegister (RegisterDto registerDto);
	
	UserDto removeUser (String login);
	
	UserDto updateUser (String login, NewUserDto newUserDto);
	
	UserRoleDto addRole(String login, String role);
	
	UserRoleDto removeRole (String login, String role);
	
	UserDto getUser (String login);
	
	void changePassword(String login, String newPassword);
	
//	UserRoleDto changeRolesList(String login, String role, boolean isAddRole);
	

}
