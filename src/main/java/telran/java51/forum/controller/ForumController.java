package telran.java51.forum.controller;

import java.util.List;
import java.util.Set;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import telran.java51.forum.dto.FindPostsByPeriodDto;
import telran.java51.forum.dto.PostCreateDto;
import telran.java51.forum.dto.PostDto;
import telran.java51.forum.dto.UpdatePostDto;
import telran.java51.forum.service.ForumService;

@RestController
@RequiredArgsConstructor
public class ForumController {
	
	ForumService forumService;

	@PostMapping("/forum/post/{user}")
	public PostDto addPost(@PathVariable ("user") String author, @RequestBody PostCreateDto postCreateDto) {
		return forumService.addPost(author, postCreateDto);
	}

	@GetMapping("/forum/post/{postId}")
	public PostDto findPostById(@PathVariable("postId") Integer id) {
		return forumService.findPostById(id);
	}

	@PutMapping("/forum/post/{postId}/like")
	public void addLike(@PathVariable("postId") Integer id) {
		forumService.addLike(id);	
	}

	@GetMapping("/forum/posts/author/{user}")
	public List<PostDto> findPostsByAuthor(@PathVariable String user) {
		return forumService.findPostsByAuthor(user);
	}

	@PutMapping("/forum/post/{postId}/comment/{user}")
	public PostDto addComment(@PathVariable("postId") Integer id, @RequestBody String message, @PathVariable ("user") String author) {
		return forumService.addComment(id, message, author);
	}

	@DeleteMapping("/forum/post/{postId}")
	public PostDto deletePost(@PathVariable("postId") Integer id) {
		return forumService.deletePost(id);
	}

	@PostMapping("/forum/posts/tags")
	public List<PostDto> findPostsByTags(@RequestBody Set<String> tags) {
		return forumService.findPostsByTags(tags);
	}

	@PostMapping("/forum/posts/period")
	public List<PostDto> findPostsByPeriod(@RequestBody FindPostsByPeriodDto findPostsByPeriodDto) {
		return forumService.findPostsByPeriod(findPostsByPeriodDto);
	}

	@PutMapping("/forum/post/{postId}")
	public PostDto updatePost(@PathVariable("postId") Integer id, @RequestBody UpdatePostDto updatePostDto) {
		return forumService.updatePost(id, updatePostDto);
	}
	
	
	

}
