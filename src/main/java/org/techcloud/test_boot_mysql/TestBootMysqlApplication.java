package org.techcloud.test_boot_mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.techcloud.test_boot_mysql.test.model.User;
import org.techcloud.test_boot_mysql.test.service.UserService;

@SpringBootApplication
public class TestBootMysqlApplication implements CommandLineRunner {

    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(TestBootMysqlApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Insert test data when application starts
        User user1 = new User(null, "John Doe", "john@example.com", 25);
        User user2 = new User(null, "Jane Smith", "jane@example.com", 30);

        userService.saveUser(user1);
        userService.saveUser(user2);

        System.out.println("=== Test Users Added to H2 Database ===");
        userService.getAllUsers().forEach(user ->
                System.out.println("User: " + user.getName() + " | Email: " + user.getEmail())
        );
    }


}


