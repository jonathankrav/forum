package telran.java51.forum.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@EqualsAndHashCode(of = "id")
@Document(collection = "forum")
@NoArgsConstructor
public class Post {
	
	   int id; 
	   @Setter
	   String title; 
	   @Setter
	   String content; 
	   @Setter
	   String author; 
	   LocalDateTime  dateCreated; 
	   @Setter
	   Set <String> tags; 
	   @Setter
	   Integer likes;
	   @Setter
	   List<Comment> comments;
	   
	public Post(int id, String title, String content, String author, LocalDateTime dateCreated, Set<String> tags) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.author = author;
		this.dateCreated = dateCreated;
		this.tags = tags;
		comments = new ArrayList<>(); 
	}
	
	public boolean addComment(Integer id, String user, String message) {
		return comments.add(new Comment(id, user, message));
	}
	   
	   

}
