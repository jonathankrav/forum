package telran.java51.accounting.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import telran.java51.accounting.dto.RoleDto;

@Getter
@EqualsAndHashCode(of = "login")
@Document(collection = "users")

public class User {
	@Id
	String login; 
    @Setter
	String firstName; 
    @Setter
    String lastName; 
    List<RoleDto> roles;
    
    public User() {
    	roles = new ArrayList<>();
    	roles.add(RoleDto.USER);
    }

	public User(String login, String firstName, String lastName, List<RoleDto> roles) {
		this.login = login;
		this.firstName = firstName;
		this.lastName = lastName;
		roles.add(RoleDto.USER);
		this.roles = roles;
	}
    
    public boolean addRole(RoleDto role) {
    	return roles.add(role);
    }
    
    public boolean removeRole(RoleDto role) {
    	return roles.remove(role);
    }

}
