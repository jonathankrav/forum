package telran.java51.accounting.service;

import org.mindrot.jbcrypt.BCrypt;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import telran.java51.accounting.dao.UserRepository;
import telran.java51.accounting.dto.NewUserDto;
import telran.java51.accounting.dto.RegisterDto;
import telran.java51.accounting.dto.UserDto;
import telran.java51.accounting.dto.UserRoleDto;
import telran.java51.accounting.dto.exceptions.UserAlreadyExistsException;
import telran.java51.accounting.dto.exceptions.UserNotFoundException;
import telran.java51.accounting.model.UserAccount;

@Service
@RequiredArgsConstructor
public class UserAccountServiceImpl implements UserAccountService {

	final UserRepository userRepository;
	final ModelMapper modelMapper;

	@Override
	public UserDto userRegister(RegisterDto registerDto) {
		if (userRepository.existsById(registerDto.getLogin())) {
			throw new UserAlreadyExistsException();
		}
		UserAccount user = modelMapper.map(registerDto, UserAccount.class);
		String password = BCrypt.hashpw(registerDto.getPassword(), BCrypt.gensalt());
		user.setPassword(password );
		user = userRepository.save(user);
		return modelMapper.map(user, UserDto.class);
	}

	@Override
	public UserDto removeUser(String login) {
		UserAccount user = userRepository.findById(login).orElseThrow(UserNotFoundException::new);
		userRepository.delete(user);
		return modelMapper.map(user, UserDto.class);
	}

	@Override
	public UserDto updateUser(String login, NewUserDto newUserDto) {
		UserAccount user = userRepository.findById(login).orElseThrow(UserNotFoundException::new);
		if (newUserDto.getFirstName() != null) {
			user.setFirstName(newUserDto.getFirstName());
		}
		if (newUserDto.getLastName() != null) {
			user.setLastName(newUserDto.getLastName());
		}
		user = userRepository.save(user);
		return modelMapper.map(user, UserDto.class);
	}

	@Override
	public UserRoleDto addRole(String login, String role) {
		UserAccount user = userRepository.findById(login).orElseThrow(UserNotFoundException::new);
		user.addRole(role.toUpperCase());
		user = userRepository.save(user);
		return modelMapper.map(user, UserRoleDto.class);
	}

	@Override
	public UserRoleDto removeRole(String login, String role) {
		UserAccount user = userRepository.findById(login).orElseThrow(UserNotFoundException::new);
		user.removeRole(role.toUpperCase());
		user = userRepository.save(user);
		return modelMapper.map(user, UserRoleDto.class);
	}

	@Override
	public UserDto getUser(String login) {
		UserAccount user = userRepository.findById(login).orElseThrow(UserNotFoundException::new);
		return modelMapper.map(user, UserDto.class);
	}
	
	
	@Override
	public void changePassword(String login, String newPassword) {
		UserAccount userAccount = userRepository.findById(login).orElseThrow(UserNotFoundException::new);
		String password = BCrypt.hashpw(newPassword, BCrypt.gensalt());
		userAccount.setPassword(password);
		userRepository.save(userAccount);
	}

}