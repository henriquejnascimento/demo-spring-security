CREATE TABLE role (
    role_id BIGSERIAL PRIMARY KEY,
    name VARCHAR(60) NOT NULL
);

CREATE TABLE users (
    user_id UUID PRIMARY KEY,
    username VARCHAR(80) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE user_role (
    user_id UUID REFERENCES users (user_id) ON DELETE CASCADE,
    role_id BIGINT REFERENCES role(role_id) ON DELETE CASCADE,
    PRIMARY KEY (user_id, role_id)
);
