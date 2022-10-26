package com.example.demo.service;

import com.example.demo.exception.GoalNotFoundException;
import com.example.demo.model.Goal.Goal;
import com.example.demo.repo.GoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class GoalService {
    private final GoalRepository goalRepository;

    @Autowired
    public GoalService(GoalRepository goalRepository) {
        this.goalRepository = goalRepository;
    }

    public List<Goal> getGoals() {
        return goalRepository.findAll();
    }

    public void createGoal(Goal goal) {
        goalRepository.save(goal);
    }

    public void deleteGoal(Long goalId) {
        if (goalRepository.existsById(goalId)) {
            goalRepository.deleteGoalById(goalId);
        }
    }

    public List<Goal> findAllGoals() {
        return goalRepository.findAll();
    }

    public Goal findGoalById(Long goalId) {
        return goalRepository.findById(goalId).orElseThrow(() -> new GoalNotFoundException("Goal not found"));
    }

    public Goal updateGoal(Goal goal) {
        return this.goalRepository.save(goal);
    }
}
