package com.example.ProjectManagementSystem.Project;

import jakarta.persistence.GeneratedValue;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Getter
@Setter
public class AllValidation {
    @NotNull(message = "Project Title Name Can't Be Null")
    private String name;
    @NotNull(message = "Description Can't Be Null")
    private String description;
    @NotEmpty
    private String startDate;
    @NotEmpty
    private String endDate;
}
