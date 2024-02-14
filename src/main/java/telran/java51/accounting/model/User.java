package telran.java51.accounting.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.Singular;

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
    @Singular
    List<String> roles;
    
    public User() {
    	roles = new ArrayList<>();
    	roles.add("USER");
    }

	public User(String login, String firstName, String lastName, List<String> roles) {
		this.login = login;
		this.firstName = firstName;
		this.lastName = lastName;
		roles.add("USER");
		this.roles = roles;
	}
    
    public boolean addRole(String role) {
    	return roles.add(role);
    }
    
    public boolean removeRole(String role) {
    	return roles.remove(role);
    }

}
