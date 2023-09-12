CREATE TABLE IF NOT EXISTS answer (id SERIAL PRIMARY KEY,
                                                     value TEXT, is_correct BOOLEAN, question_id VARCHAR(255),
                                   FOREIGN KEY (question_id) REFERENCES question(id));

