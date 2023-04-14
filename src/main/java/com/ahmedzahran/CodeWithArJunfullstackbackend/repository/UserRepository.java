package com.ahmedzahran.CodeWithArJunfullstackbackend.repository;

import com.ahmedzahran.CodeWithArJunfullstackbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
