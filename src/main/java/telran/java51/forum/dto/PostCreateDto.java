package telran.java51.forum.dto;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PostCreateDto {
	
	String user;
	String title; 
	String content; 
	Set <String> tags; 

}
