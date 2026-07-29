INSERT INTO roles (
    id,
    name,
    description,
    created_at,
    updated_at
)
VALUES (
           UUID_TO_BIN(UUID()),
           'ROLE_USER',
           'Default user role',
           CURRENT_TIMESTAMP(6),
           CURRENT_TIMESTAMP(6)
       );

INSERT INTO roles (
    id,
    name,
    description,
    created_at,
    updated_at
)
VALUES (
           UUID_TO_BIN(UUID()),
           'ROLE_ADMIN',
           'Administrator role',
           CURRENT_TIMESTAMP(6),
           CURRENT_TIMESTAMP(6)
       );