package com.consumecalculator.consumeCalculator.Repositories;

import com.consumecalculator.consumeCalculator.Entities.ConsumeMonth;
import com.consumecalculator.consumeCalculator.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsumeMonthRepository extends JpaRepository<ConsumeMonth, String> {
    List<ConsumeMonth> findByUser(User user);

    List<ConsumeMonth> findByUserAndDate(User user, String date);

    void deleteByUserAndDate(User user, String date);
}
