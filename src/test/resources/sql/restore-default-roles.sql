INSERT IGNORE INTO roles (id, name, description, created_at, updated_at)
VALUES (UUID_TO_BIN(UUID()), 'ROLE_USER', 'Default user role', NOW(6), NOW(6));
INSERT IGNORE INTO roles (id, name, description, created_at, updated_at)
VALUES (UUID_TO_BIN(UUID()), 'ROLE_ADMIN', 'Administrator role', NOW(6), NOW(6));
