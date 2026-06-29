CREATE TABLE users
(
    id                BINARY(16)   NOT NULL,

    email             VARCHAR(255),
    mobile_number     VARCHAR(20),

    password_hash VARCHAR(255) NOT NULL,

    first_name        VARCHAR(100) NOT NULL,
    last_name         VARCHAR(100) NOT NULL,

    enabled           BOOLEAN      NOT NULL DEFAULT TRUE,
    email_verified    BOOLEAN      NOT NULL DEFAULT FALSE,
    mobile_verified   BOOLEAN      NOT NULL DEFAULT FALSE,

    created_at        TIMESTAMP(6) NOT NULL,
    updated_at        TIMESTAMP(6) NOT NULL,

    CONSTRAINT pk_users PRIMARY KEY (id),

    CONSTRAINT uk_users_email UNIQUE (email),
    CONSTRAINT uk_users_mobile UNIQUE (mobile_number),

    CONSTRAINT chk_users_identifier
        CHECK (
            email IS NOT NULL
            OR mobile_number IS NOT NULL
            )
);