package telran.java51.forum.model;

import java.time.LocalDateTime;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@EqualsAndHashCode(of = {"postId","dateCreated", "message"} )
@NoArgsConstructor
public class Comment {
	
		int postId;
	    String user; 
	    String message; 
	    LocalDateTime dateCreated; 
	    Integer likes;
	    
		public Comment(Integer postId, String user, String message) {
			this.postId = postId;
			this.user = user;
			this.message = message;
			this.dateCreated = LocalDateTime.now(); 
			likes = 0;
		}
	    
	    

}
