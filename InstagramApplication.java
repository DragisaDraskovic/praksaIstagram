package Instagram;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import Instagram.jpa.UserJpa;
import Instagram.repository.UserRepository;

@SpringBootApplication
public class InstagramApplication {

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(InstagramApplication.class, args);
	}
	
	@Autowired
	UserRepository userRepository;
	/*
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args ->{
			System.out.println("Bean-ovi");
			String[] beanNames = ctx.getBeanDefinitionNames();
			for(String beanName : beanNames) {
				System.out.println(beanName);
			}
		};
	}
	*/

	@Bean public BCryptPasswordEncoder bCryptPasswordEncoder() {
	    return new BCryptPasswordEncoder(); 
	}
	/*
	@Override
	public void run(String... args) throws Exception {
		
	UserJpa user = new UserJpa();
	user.setId(1);
	user.setName("dto");
	user.setName("dto");
	user.setUsername("dto");
	user.setEmail("gmaildto");
	user.setPassword("pwdto");
	user.setRole("user");
	userRepository.save(user);
	}
	*/
}
