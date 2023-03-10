//package hello.loginpractice;
//
//import javax.transaction.Transactional;
//
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import hello.loginpractice.model.User;
//import hello.loginpractice.repository.UserRepository;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@Transactional
//public class userTest {
//	
//	@Autowired
//	private UserRepository userRepository;
//	
//	@Test
//	void insertTest() {
//		for(int i=0; i < 10;i++) {
//			User user = User.builder()
//					.userid("user"+i)
//					.password("abc"+i)
//					.name("ab")
//					.build();
//			
//			userRepository.save(user);
//			
//		}
//	}
//}