package mijn.grindmanager.controller

import mijn.grindmanager.repository.Question
import mijn.grindmanager.repository.QuestionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class QuestionController(@Autowired private val questionRepository: QuestionRepository) {

    @GetMapping("/questions")
    fun insertQuestion(): List<Question> {
        return questionRepository.getAllQuestions();
    }
}