package com.example.demo.model.Goal;

import com.example.demo.repo.GoalRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class GoalConfig {

    @Bean
    CommandLineRunner commandLineRunner(GoalRepository goalRepository) {
        return args -> {
            Goal goal =  new Goal("goal", "hello world", Goal.GoalCategory.GREEN_INITIATIVES, LocalDate.now(), LocalDate.now(), Goal.GoalReportFrequency.DAILY);
            goalRepository.saveAll(List.of(goal));
        };

    }
}
