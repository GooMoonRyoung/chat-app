package com.chatapp.server.repository;

import com.chatapp.server.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository // Tells Spring this is a Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // JpaRepository<User, Long> means it's a repository for the 'User' entity,
    // and the ID type is 'Long'.

    // Spring Data JPA will automatically create this method for us
    // based on the name!
    Optional<User> findByUsername(String username);

    @Transactional
    void deleteByUsername(String username);
}