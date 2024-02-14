package telran.java51.post.dao;

import org.springframework.data.repository.CrudRepository;

import telran.java51.post.model.Post;
import java.util.stream.Stream;
import java.time.LocalDate;
import java.util.List;



public interface PostRepository extends CrudRepository<Post, String> {
	
	Stream<Post> findByAuthorIgnoreCase(String author);
	
	Stream<Post> findByTagsInIgnoreCase(List<String> tags);
	
	Stream<Post> findByDateCreatedBetween(LocalDate from, LocalDate to);

}
