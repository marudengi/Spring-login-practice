package hello.loginpractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hello.loginpractice.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
//	User getUserAccount(String userid);
	
	User save(User user);
}
