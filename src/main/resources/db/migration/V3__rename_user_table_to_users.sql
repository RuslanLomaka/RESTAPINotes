-- V3__rename_user_table_to_users.sql
BEGIN;

-- 1) Drop old foreign‑key to "user"
ALTER TABLE note
    DROP CONSTRAINT IF EXISTS fk_user;

-- 2) Rename table and its primary‑key objects
ALTER TABLE "user" RENAME TO users;
ALTER TABLE users RENAME CONSTRAINT user_pkey TO users_pkey;        -- PK
ALTER INDEX  IF EXISTS user_email_key RENAME TO users_email_key;    -- unique(email)

-- if you let Postgres autogenerate the sequence, rename it too
ALTER SEQUENCE IF EXISTS user_id_seq RENAME TO users_id_seq;

-- 3) Re‑create FK with the new target
ALTER TABLE note
    ADD CONSTRAINT fk_users
        FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE;

COMMIT;
