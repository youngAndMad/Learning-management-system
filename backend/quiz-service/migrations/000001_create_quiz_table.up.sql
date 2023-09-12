CREATE TABLE IF NOT EXISTS quiz (id SERIAL PRIMARY KEY,
                                                   course_id VARCHAR(255),
                                                             review_is_allowed BOOLEAN, start_time TIMESTAMP,
                                                                                                   end_time TIMESTAMP,
                                                                                                            duration_minute INT);

