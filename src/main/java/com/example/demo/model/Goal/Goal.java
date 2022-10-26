package com.example.demo.model.Goal;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table
public class Goal implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    @Getter @Setter
    private Long id;
    @Getter @Setter
    private String name, description;
    @Getter @Setter
    private GoalCategory type;
    @Getter @Setter
    private LocalDate startDate, endDate;
    @Getter @Setter
    private GoalReportFrequency frequency;

    public Goal() {
    }

    public Goal(Long id, String name, String description, GoalCategory type, LocalDate startDate, LocalDate endDate, GoalReportFrequency frequency) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.startDate = startDate;
        this.endDate = endDate;
        this.frequency = frequency;
    }

    public Goal(String name, String description, GoalCategory type, LocalDate startDate, LocalDate endDate, GoalReportFrequency frequency) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.startDate = startDate;
        this.endDate = endDate;
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return "Goal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", type=" + type +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", frequency=" + frequency +
                '}';
    }

    public enum GoalReportFrequency {
        DAILY, WEEKLY, MONTHLY;
    }

    public enum GoalCategory {
        CAREER, DIET_AND_HEALTHY_EATING, EDUCATION_AND_KNOWLEDGE, EXERCISE_AND_FITNESS, FAMILY_AND_RELATIONSHIP,
        GREEN_INITIATIVES, HEALTH_AND_LIFESTYLE, HOME_IMPROVEMENTS_AND_DIY, MONEY_AND_FINANCE, PERSONAL_RELATIONSHIPS,
        QUIT_SMOKING, RELIGION_AND_SPIRITUALITY, SPORTS_HOBBIES_AND_RECREATION, WEIGHT_LOSS
    }
}
