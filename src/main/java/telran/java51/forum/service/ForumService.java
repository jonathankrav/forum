package telran.java51.forum.service;

import java.util.List;
import java.util.Set;

import telran.java51.forum.dto.FindPostsByPeriodDto;
import telran.java51.forum.dto.PostCreateDto;
import telran.java51.forum.dto.PostDto;
import telran.java51.forum.dto.UpdatePostDto;

public interface ForumService {
	
	PostDto addPost(String user, PostCreateDto postCreateDto);
	
	PostDto findPostById(Integer id);
	
	void addLike(Integer id);
	
    List<PostDto> findPostsByAuthor(String user);
	
	PostDto addComment(Integer id, String user, String message);
	
	PostDto deletePost(Integer id);
	
	List<PostDto> findPostsByTags(Set<String> tags);
	
	List<PostDto> findPostsByPeriod(FindPostsByPeriodDto findPostsByPeriodDto);

	PostDto updatePost(Integer id, UpdatePostDto updatePostDto);
	
}
