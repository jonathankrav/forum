package telran.java51.forum.dto;

import java.time.LocalDateTime;

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
   LocalDateTime  dateCreated; //"2021-12-14T11:39:05",
   String[] tags; 
   Integer likes;
   CommentDto[] comments;

}
