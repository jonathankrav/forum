package telran.java51.forum.service;

import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import telran.java51.forum.dao.ForumRepository;
import telran.java51.forum.dto.FindPostsByPeriodDto;
import telran.java51.forum.dto.PostCreateDto;
import telran.java51.forum.dto.PostDto;
import telran.java51.forum.dto.UpdatePostDto;

@Service
@RequiredArgsConstructor
public class ForumServiceImpl implements ForumService {
	
	final ForumRepository forumRepository;
	final ModelMapper modelMapper;

	@Override
	public PostDto addPost(String user, PostCreateDto postCreateDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PostDto findPostById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addLike(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<PostDto> findPostsByAuthor(String user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PostDto addComment(Integer id, String user, String message) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PostDto deletePost(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostDto> findPostsByTags(Set<String> tags) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostDto> findPostsByPeriod(FindPostsByPeriodDto findPostsByPeriodDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PostDto updatePost(Integer id, UpdatePostDto updatePostDto) {
		// TODO Auto-generated method stub
		return null;
	}

}
