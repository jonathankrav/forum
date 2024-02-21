package telran.java51.security.filter;

import java.io.IOException;
import java.security.Principal;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import telran.java51.accounting.dao.UserRepository;
import telran.java51.accounting.model.User;
import telran.java51.post.dao.PostRepository;

@Component
@RequiredArgsConstructor
@Order(50)
public class DeletePostFilter implements Filter {

	final PostRepository postRepository;
	final UserRepository userRepository;
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		if (checkEndPoint(request.getMethod(), request.getServletPath())) {
			Principal principal = request.getUserPrincipal();
			String[] arr = request.getServletPath().split("/");
			String postId = arr[arr.length-1];	
			String author = postRepository.findById(postId).get().getAuthor();
			User user2 = userRepository.findById(request.getUserPrincipal().getName()).get();
			if(!(principal.getName().equalsIgnoreCase(author) || user2.getRoles().contains("MODERATOR"))) {
				response.sendError(403, "Permission denied");
				return;
			}
			
		}
		chain.doFilter(request, response);

	}
	
	private boolean checkEndPoint(String method, String path) {		
		return HttpMethod.DELETE.matches(method) && path.matches("/forum/post/\\w+");
	}

}
