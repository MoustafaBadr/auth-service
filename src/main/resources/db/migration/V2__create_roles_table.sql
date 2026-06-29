-- -----------------------------------------------------
-- Migration: V2__create_roles_table.sql
-- Description: Create roles table
-- Author: Mostafa Badr
-- -------------------------------------------------------

CREATE TABLE roles
(
    id           BINARY(16)   NOT NULL,
    name         VARCHAR(50)  NOT NULL,
    description  VARCHAR(255) NULL,

    created_at   TIMESTAMP(6) NOT NULL,
    updated_at   TIMESTAMP(6) NOT NULL,

    CONSTRAINT pk_roles PRIMARY KEY (id),
    CONSTRAINT uk_roles_name UNIQUE (name)
);