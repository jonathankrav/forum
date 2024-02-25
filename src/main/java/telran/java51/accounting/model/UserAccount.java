package telran.java51.accounting.model;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@EqualsAndHashCode(of = "login")
@Document(collection = "users")

public class UserAccount {
	@Id
	String login; 
    @Setter
	String firstName; 
    @Setter
    String lastName; 
    @Setter
    String password;
    Set<String> roles;
    
    public UserAccount() {
    	roles = new HashSet<>();
    	roles.add("USER");
    }

	public UserAccount(String login, String password, String firstName, String lastName) {
		this();
		this.login = login;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
	}
    
    public boolean addRole(String role) {
    	return roles.add(role.toUpperCase());
    }
    
    public boolean removeRole(String role) {
    	return roles.remove(role.toUpperCase());
    }

}
