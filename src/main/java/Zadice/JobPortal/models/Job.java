package Zadice.JobPortal.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "jobs")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Title cannot be blank")
    private String title;

    @NotBlank(message = "Company name cannot be blank")
    private String company;

    @NotBlank(message = "Location cannot be empty")
    private String location;

    private String description;

    @Min(value = 0, message = "Salary cannot be negative")
    private double salary;

    @Enumerated(EnumType.STRING)
    private JobType type;

    @Enumerated(EnumType.STRING)
    private categoryType category;

    private boolean active = true;

    public enum JobType {
        FULL_TIME, PART_TIME, CONTRACT, INTERNSHIP, REMOTE
    }

    public enum categoryType {
        ENGINEERING, DESIGN, PRODUCT, MARKETING, SALES, FINANCE, HR
    }
}
