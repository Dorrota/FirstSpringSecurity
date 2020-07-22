package com.ailleron.security.repository;

import com.ailleron.security.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName(String userName);
    @Query("select u from User u where u.userName = ?1 and u.enabled = ?2")
    User findByUserNameAndEnabledEquals(String userName, int enabled);
}
