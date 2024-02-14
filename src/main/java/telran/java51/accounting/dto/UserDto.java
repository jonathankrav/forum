package telran.java51.accounting.dto;

import java.util.List;

import lombok.Getter;

@Getter
public class UserDto {
    	
    String login; 
    String firstName; 
    String lastName; 
    List<String> roles;
    		
}
