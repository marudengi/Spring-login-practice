//package hello.loginpractice.serviceImpl;
//
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.ModelMap;
//
//import hello.loginpractice.model.User;
//import hello.loginpractice.repository.UserRepository;
//import hello.loginpractice.service.UserService;
//
//public class UserServiceImpl implements UserService{
//	
//	@Autowired
//	private UserRepository repository;
//	
//	@Override
//	public List<User> list() {
//		
//		List<User> user = (List<User>) repository.findAll();
//		
//		return user;
//	}
//	
//	@Override
//	public void save(Map<String, User> param, ModelMap model) {
//		User user = new User();
//		user.setId(param.get());
//		
//	}
//}
