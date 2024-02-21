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

public class User {
	@Id
	String login;
	@Setter
	String firstName;
	@Setter
	String lastName;
	@Setter
	String password;
	Set<Role> roles;

	public User() {
		roles = new HashSet<>();
		roles.add(Role.USER);
	}

	public User(String login, String password, String firstName, String lastName) {
		this();
		this.login = login;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
	}

	public boolean addRole(String role) {
		Role[] values = Role.values();
		for (Role role2 : values) {
			if (role.matches(role2.toString())) {
				return roles.add(role2);
			}
		}
		return false;
	}

	public boolean removeRole(String role) {
		Role[] values = Role.values();
		for (Role role2 : values) {
			if (role.matches(role2.toString())) {
				return roles.remove(role2);
			}
		}
		return false;
	}

}
