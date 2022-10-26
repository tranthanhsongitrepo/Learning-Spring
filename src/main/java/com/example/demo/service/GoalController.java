package com.example.demo.service;

import com.example.demo.model.Goal.Goal;
import com.example.demo.service.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/goal")
public class GoalController {
    private final GoalService goalService;

    @Autowired
    public GoalController(GoalService goalService) {
        this.goalService = goalService;
    }

    @GetMapping("/all")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<List<Goal>> getGoals() {
        return new ResponseEntity<>(this.goalService.getGoals(), HttpStatus.OK);
    }

    @PostMapping("/addGoal")
    @PreAuthorize("hasAuthority('goal:write')")
    public void createGoal(@RequestBody Goal goal) {
        goalService.createGoal(goal);
    }

    @DeleteMapping("/delete/{goalId}")
    @PreAuthorize("hasAuthority('goal:write')")
    public void deleteGoal(@PathVariable("goalId") Long goalId) {
        goalService.deleteGoal(goalId);
    }

    // Put is only used for idempotent stuffs (updating, creating when client knows the ID beforehand)
    // Post is only used for non-idempotent stuffs (creating)
    // Patch is a partial update

    @GetMapping("/find/{id}")
    @PreAuthorize("hasAuthority('goal:write')")
    public Goal getGoal(@PathVariable("id") Long goalId) {
        return goalService.findGoalById(goalId);
    }

    @PutMapping("/update")
    @PreAuthorize("hasAuthority('goal:write')")
    public Goal updateGoal(@RequestBody Goal goal) {
        return goalService.updateGoal(goal);
    }
}
