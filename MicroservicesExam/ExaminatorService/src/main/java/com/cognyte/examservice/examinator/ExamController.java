package com.cognyte.examservice.examinator;

import com.cognyte.examservice.models.Exam;
import com.cognyte.examservice.models.Question;
import com.cognyte.examservice.models.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static java.util.Arrays.asList;

@RestController
@RequestMapping("/api/")
public class ExamController {

    @Autowired
    private RestTemplate restTemplate;

    private final Map<String,String> sectionName2Url = new HashMap<>();

    public ExamController(){
        sectionName2Url.put("math","http://localhost:8081/");
        sectionName2Url.put("history","http://localhost:8082/");
        sectionName2Url.put("geo","http://localhost:8083/");
    }

    /**
     * Method will generate and return new Exam.
     * following Exam JSON format { "Math":6, "Eng":3 }
     * */
    @PostMapping("/exam")
    public Exam calculateExam(@RequestBody Map<String,Integer> examSpec) {

        //RestTemplate restTemplate = new RestTemplate();
        Exam exam = new Exam();
        exam.setTitle("Cognyte Exam");

        for (String sectionName : examSpec.keySet()) {
            Integer amount = examSpec.get(sectionName);
            String url = sectionName2Url.get(sectionName) + "api/questions/random?amount=" + amount;

            // Get entry point for specific generator service
            Optional<Question[]> questions = Optional.ofNullable(
                restTemplate.getForObject(url,Question[].class)
            );
            questions.ifPresent(value -> exam.addSection(new Section(sectionName, asList(value))));
        }
        return exam;
    }
}
