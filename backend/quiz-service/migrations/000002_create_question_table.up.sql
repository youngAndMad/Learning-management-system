CREATE TABLE IF NOT EXISTS question (id SERIAL PRIMARY KEY,
                                                       max_attempts INT, current_attempt INT, value TEXT, quiz_id VARCHAR(255),
                                     FOREIGN KEY (quiz_id) REFERENCES quiz(id));

