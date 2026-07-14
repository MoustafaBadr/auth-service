package com.mostafabadr.authservice.common;

import com.mostafabadr.authservice.common.config.JpaAuditingConfig;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.junit.jupiter.Testcontainers;

@DataJpaTest
@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
@Import(JpaAuditingConfig.class)
public abstract class RepositoryIntegrationTest extends MySQLContainerHolder {

}
