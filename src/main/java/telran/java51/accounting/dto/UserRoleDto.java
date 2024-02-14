package telran.java51.accounting.dto;

import java.util.List;

import lombok.Getter;

@Getter
public class UserRoleDto {
	
	 String login; 
	 List<RoleDto> roles;
}
