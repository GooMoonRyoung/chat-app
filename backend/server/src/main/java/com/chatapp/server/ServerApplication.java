package com.chatapp.server;

import com.chatapp.server.model.User;
import com.chatapp.server.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@SpringBootApplication
public class ServerApplication {

    // Set up a logger for clean console output
    private static final Logger log = LoggerFactory.getLogger(ServerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}

    // This 'CommandLineRunner' bean will run ONCE, right after the app starts.
    // It's the perfect place to test our database connection.
    @Bean
    public CommandLineRunner testDatabase(UserRepository repository) {
        return (args) -> {
            log.info("--- DATABASE TEST START ---");

            // Delete all users just in case
            repository.deleteAll();

            // Create a new test user
            User testUser = new User("test_user", "abc123_hashed_password");

            // Save the user to the database
            log.info("Saving new user...");
            repository.save(testUser);

            // Fetch all users from the database
            log.info("Fetching all users:");
            List<User> users = repository.findAll();

            // Print them to the console
            for (User user : users) {
                log.info(user.toString());
            }

            // Test the 'findByUsername' method
            log.info("Finding user 'test_user':");
            repository.findByUsername("test_user").ifPresent(user -> {
                log.info(user.toString());
            });

//            repository.deleteByUsername("test_user");
//            if (repository.findByUsername("test_user").isEmpty()){
//                log.info("This user no longer exists");
//            }

            log.info("--- DATABASE TEST COMPLETE ---");
        };
    }
}
