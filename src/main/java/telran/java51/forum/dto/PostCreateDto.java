package telran.java51.forum.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PostCreateDto {
	
	String title; 
	String content; 
	String[] tags; 

}
