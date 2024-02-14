package telran.java51.accounting.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import telran.java51.accounting.dao.UserRepository;
import telran.java51.accounting.dto.NewUserDto;
import telran.java51.accounting.dto.RegisterDto;
import telran.java51.accounting.dto.UserDto;
import telran.java51.accounting.dto.UserRoleDto;
import telran.java51.accounting.dto.exceptions.UserNotFoundException;
import telran.java51.accounting.model.User;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	
	final UserRepository userRepository;
	final ModelMapper modelMapper;

	@Override
	public UserDto userRegister(RegisterDto registerDto) {
		User  user = modelMapper.map(registerDto, User.class);
		user =  userRepository.save(user);
		return modelMapper.map(user, UserDto.class);
	}

	@Override
	public UserDto removeUser(String login) {
		User user = userRepository.findById(login).orElseThrow(UserNotFoundException::new);
		userRepository.delete(user);
		return modelMapper.map(user, UserDto.class);
	}

	@Override
	public UserDto updateUser(String login, NewUserDto newUserDto) {
		User user = userRepository.findById(login).orElseThrow(UserNotFoundException::new);
		if (newUserDto.getFirstName() != null) {
			user.setFirstName(newUserDto.getFirstName());
		}
		if (newUserDto.getLastName() != null) {
			user.setLastName(newUserDto.getLastName());
		}
		user =  userRepository.save(user);
		return modelMapper.map(user, UserDto.class);
	}

	@Override
	public UserRoleDto addRole(String login, String role) {
		User user = userRepository.findById(login).orElseThrow(UserNotFoundException::new);
		user.addRole(role.toUpperCase());
		user =  userRepository.save(user);
		return modelMapper.map(user, UserRoleDto.class);
	}

	@Override
	public UserRoleDto removeRole(String login, String role) {
		User user = userRepository.findById(login).orElseThrow(UserNotFoundException::new);
		user.removeRole(role.toUpperCase());
		user =  userRepository.save(user);
		return modelMapper.map(user, UserRoleDto.class);
	}

	@Override
	public UserDto getUser(String login) {
		User user = userRepository.findById(login).orElseThrow(UserNotFoundException::new);
		return modelMapper.map(user, UserDto.class);
	}

}
