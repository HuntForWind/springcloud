-- PostgreSQL 创建user_test表
CREATE TABLE IF NOT EXISTS user_test (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(30),
    age INTEGER,
    email VARCHAR(50),
    create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    deleted INTEGER DEFAULT 0
);
