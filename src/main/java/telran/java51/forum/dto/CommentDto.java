package telran.java51.forum.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
	
    String user; //"Stranger",
    String message; // "Awesome!!!",
    LocalDateTime dateCreated; //"2021-12-15T14:11:55",
    Integer likes;

}
