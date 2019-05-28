package com.sop.sopdal.repository;

import com.sop.sopdal.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    public User findOneByEmail(String email);

}
