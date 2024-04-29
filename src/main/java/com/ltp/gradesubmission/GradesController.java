package com.ltp.gradesubmission;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GradesController {
    List<Grade> studentGrades = new ArrayList<>();

 
    @GetMapping("/grades")
    public String getGrades(Model model){
        model.addAttribute("grades", studentGrades);
        return "grades"; // Directs the grades.html
    }
    @GetMapping("/")
    // @RequestParam notates that the parameter can only come from a GET request
    // required = false allows us to go to home page without having an id sent with the request
    public String gradeForm(Model model, @RequestParam(required = false) String id){
        Grade grade;
        if(getGradeIndex(id) == Constants.NOT_FOUND){
            grade = new Grade();
        }
        else{
            grade = studentGrades.get(getGradeIndex(id));
        }
        model.addAttribute("grade", grade);
        return "form";
    }

    @PostMapping("/handleSubmit")
    public String handleSubmit(Grade grade){
        int index = getGradeIndex(grade.getId());
        if(index == Constants.NOT_FOUND){
            studentGrades.add(grade);  // Adds the grade that was submitted in the POST request
        }
        else{
            studentGrades.set(index, grade); // Updates grade
        }
        return "redirect:/grades"; // Redirects to a GET request at /grades
    }

    public Integer getGradeIndex(String id){
        for(int i = 0; i < studentGrades.size(); i++){
            if(studentGrades.get(i).getId().equals(id)){
                return i;
            }
        }
        return Constants.NOT_FOUND;
    }
}
