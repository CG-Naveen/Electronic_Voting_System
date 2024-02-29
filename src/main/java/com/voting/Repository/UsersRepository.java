package com.voting.Repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.voting.Entity.Users;



public interface UsersRepository extends JpaRepository<Users, Integer>{
	
	Optional<Users> findByAadharNo(long aadharNo);
	Optional<Users> findByUserId(int userId);
}
