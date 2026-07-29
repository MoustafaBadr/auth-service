plugins {
	java
	id("org.springframework.boot") version "3.5.15"
	id("io.spring.dependency-management") version "1.1.7"
	id("com.diffplug.spotless") version "6.25.0"
}

group = "com.mostafabadr"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

spotless {
	java {
		googleJavaFormat()
		removeUnusedImports()
		trimTrailingWhitespace()
		endWithNewline()
	}
}
dependencies {
	// Spring Boot Starters
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springframework.boot:spring-boot-starter-web")

	// flyway
	implementation("org.flywaydb:flyway-core")
	implementation("org.flywaydb:flyway-mysql")

	// Compile-only
	compileOnly("org.projectlombok:lombok")

	// Runtime
	runtimeOnly("com.mysql:mysql-connector-j")

	// Annotation processors
	annotationProcessor("org.projectlombok:lombok")

	// Test
	// BOM
	testImplementation(platform("org.testcontainers:testcontainers-bom:1.20.1"))
	testImplementation("org.springframework.boot:spring-boot-testcontainers")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.security:spring-security-test")
	testImplementation("org.testcontainers:junit-jupiter")
	testImplementation("org.testcontainers:mysql")
	testCompileOnly("org.projectlombok:lombok")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
	testAnnotationProcessor("org.projectlombok:lombok")

}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.register<Test>("unitTest") {
	description = "Runs unit tests."
	group = "verification"

	useJUnitPlatform {
		excludeTags("repository", "integration")
	}
}

tasks.register<Test>("repositoryTest") {
	description = "Runs repository integration tests."
	group = "verification"

	useJUnitPlatform {
		includeTags("repository")
	}
}

tasks.register<Test>("integrationTest") {
	description = "Runs application integration tests."
	group = "verification"

	useJUnitPlatform {
		includeTags("integration")
	}
}