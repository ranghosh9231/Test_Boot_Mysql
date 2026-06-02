package org.techcloud.test_boot_mysql.test.repo;

import org.techcloud.test_boot_mysql.test.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Custom query methods can be added here
    User findByEmail(String email);
}
