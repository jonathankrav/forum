package telran.java51.forum.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {

   Integer id; 
   String title; 
   String content; 
   String author; 
   LocalDateTime  dateCreated;
   Set <String> tags; 
   Integer likes;
   List<CommentDto> comments;

}
