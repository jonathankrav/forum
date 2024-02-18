package telran.java51.accounting.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    	
    String login; 
    String firstName; 
    String lastName; 
    List<String> roles;
    		
}
