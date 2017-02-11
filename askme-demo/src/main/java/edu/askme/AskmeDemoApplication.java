package edu.askme;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.askme.dao.domain.UserRepository;
import edu.askme.dao.entities.Question;
import edu.askme.dao.entities.User;

@SpringBootApplication
public class AskmeDemoApplication implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(AskmeDemoApplication.class, args); 
	}
	
	@Override
	@Transactional
	public void run(String... arg0) throws Exception {
		User user = new User("hamada", "hello");
		Question question = new Question("what is your name?", "hamada");
		List<Question> questions = new ArrayList<>();
		questions.add(question);
		user.setQuestions(questions);
		userRepository.save(user);
		System.out.println(userRepository.findAll());
	}
}
