CREATE TABLE IF NOT EXISTS note (
                                    id BIGSERIAL PRIMARY KEY,
                                    title VARCHAR(255),
                                    content TEXT,
                                    created_at TIMESTAMP
);