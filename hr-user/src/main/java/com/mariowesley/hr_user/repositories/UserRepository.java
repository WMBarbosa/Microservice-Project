package com.mariowesley.hr_user.repositories;

import com.mariowesley.hr_user.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
