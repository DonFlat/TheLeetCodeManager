package mijn.grindmanager.repository

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository
import java.sql.ResultSet
import java.util.*

@Repository
class QuestionRepository(private val jdbcTemplate: JdbcTemplate) {

    fun createQuestion(title: String, solvedDate: Date, link: String, note: String) {
        val sql = "INSERT INTO questions (title, solved_date, link, note) VALUES (?, ?, ?, ?)"
        jdbcTemplate.update(sql, title, solvedDate, link, note)
    }

    fun getAllQuestions(): List<Question> {
        return jdbcTemplate.query("SELECT * FROM questions") { rs: ResultSet, _: Int ->
            Question(
                id = rs.getLong("id"),
                title = rs.getString("title"),
                solvedDate = rs.getDate("solved_date"),
                link = rs.getString("link"),
                note = rs.getString("note")
            )
        }
    }

    // Additional methods for update, delete, etc.
}

data class Question(
    val id: Long,
    val title: String,
    val solvedDate: Date,
    val link: String,
    val note: String
)