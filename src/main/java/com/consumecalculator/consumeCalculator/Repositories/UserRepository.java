package com.consumecalculator.consumeCalculator.Repositories;

import com.consumecalculator.consumeCalculator.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

}
