-- Create user table
CREATE TABLE IF NOT EXISTS "user"
(
    id                 BIGSERIAL PRIMARY KEY,
    username           VARCHAR(255) NOT NULL,
    password           VARCHAR(255) NOT NULL,
    role               VARCHAR(50)  NOT NULL,
    enabled            BOOLEAN DEFAULT FALSE,
    email              VARCHAR(255) NOT NULL UNIQUE,
    verification_token VARCHAR(255),
    token_created_at   TIMESTAMP,
    token_expires_at   TIMESTAMP
);

-- Alter note table
ALTER TABLE note
    ADD COLUMN IF NOT EXISTS shared  BOOLEAN DEFAULT FALSE,
    ADD COLUMN IF NOT EXISTS user_id BIGINT;

-- Add foreign key constraint
ALTER TABLE note
    ADD CONSTRAINT fk_user
        FOREIGN KEY (user_id) REFERENCES "user" (id) ON DELETE CASCADE;