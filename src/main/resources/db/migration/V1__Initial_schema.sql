CREATE TABLE the_questions.questions (
    id INT PRIMARY KEY,
    title VARCHAR(255),
    solved_date DATE,
    link VARCHAR(255),
    note TEXT
);

CREATE TABLE the_questions.tags (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE the_questions.question_tags (
    question_id INT,
    tag_id INT,
    PRIMARY KEY (question_id, tag_id),
    FOREIGN KEY (question_id) REFERENCES questions (id) ON DELETE CASCADE,
    FOREIGN KEY (tag_id) REFERENCES tags (id) ON DELETE CASCADE
);
