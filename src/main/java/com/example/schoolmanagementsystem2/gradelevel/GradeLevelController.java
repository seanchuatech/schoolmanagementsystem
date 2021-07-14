package com.example.schoolmanagementsystem2.gradelevel;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GradeLevelController {

    private final GradeLevelRepository gradeLevelRepository;

    public GradeLevelController(GradeLevelRepository gradeLevelRepository) {
        this.gradeLevelRepository = gradeLevelRepository;
    }

    @GetMapping("/grade-level")
    List<GradeLevel> getAll() {
        return gradeLevelRepository.findAll();
    }

    @PostMapping("/grade-level/create")
    GradeLevel createNewGrade(@RequestBody GradeLevel createNewGrade) {
        return gradeLevelRepository.save(createNewGrade);
    }

    @GetMapping("/grade-level/{id}")
    GradeLevel getGrade(@PathVariable Long id) {
        return gradeLevelRepository.findById(id).orElseThrow(() -> new GradeLevelNotFoundException(id));
    }

    @PutMapping("/grade-level/{id}")
    GradeLevel updateGrade(@RequestBody GradeLevel updateGrade, @PathVariable Long id) {
        return gradeLevelRepository.findById(id)
                .map(gradeLevel -> {
                    gradeLevel.setGradeLevel(updateGrade.getGradeLevel());
                    gradeLevel.setDescription(updateGrade.getDescription());
                    return gradeLevelRepository.save(gradeLevel);
                })
                .orElseGet(() -> {
                    updateGrade.setId(id);
                    return gradeLevelRepository.save(updateGrade);
                });
    }

    @DeleteMapping("/grade-level/{id}")
    void deleteEmployee(@PathVariable Long id) {
        gradeLevelRepository.deleteById(id);
    }
}
