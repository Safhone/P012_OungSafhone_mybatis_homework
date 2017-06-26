CREATE TABLE users
(
    id SERIAL PRIMARY KEY NOT NULL,
    username VARCHAR(100),
    email VARCHAR(100),
    gender VARCHAR,
    phonenumber VARCHAR(100),
    status BOOLEAN DEFAULT true,
    user_hash VARCHAR(100),
    created_date TIMESTAMP DEFAULT now()
);