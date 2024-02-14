package telran.java51.post.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import telran.java51.post.dao.PostRepository;
import telran.java51.post.dto.DatePeriodDto;
import telran.java51.post.dto.NewCommentDto;
import telran.java51.post.dto.NewPostDto;
import telran.java51.post.dto.PostDto;
import telran.java51.post.dto.exceptions.PostNotFoundException;
import telran.java51.post.model.Post;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
	
	final PostRepository postRepository;
	final ModelMapper modelMapper;

	@Override
	public PostDto addNewPost(String author, NewPostDto newPostDto) {
		Post post = modelMapper.map(newPostDto, Post.class);
		post.setAuthor(author);
		post = postRepository.save(post);
		return modelMapper.map(post, PostDto.class);
	}

	@Override
	public PostDto findPostById(String id) {
		Post post = postRepository.findById(id).orElseThrow(() -> new PostNotFoundException());
		return modelMapper.map(post, PostDto.class);
	}

	@Override
	public PostDto removePost(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PostDto updatePost(String id, NewPostDto newPostDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PostDto addComment(String id, String author, NewCommentDto newCommentDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addLike(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Iterable<PostDto> findPostByAuthor(String author) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<PostDto> findPostsByTags(List<String> tags) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<PostDto> findPostsByPeriod(DatePeriodDto datePeriodDto) {
		// TODO Auto-generated method stub
		return null;
	}

}
