## java-spring-boot, production-ready. Maven

- easy to learn
- Configuration
- security
- logging
- Connecting to db
- Metrics
- Production ready
- microservices
- dependency injection
- Great Community
- and more


### spring initializer
[start.spring](https://start.spring.io/), Maven, Java

![spring initializer](images/spring-initializer.png)


### Using VSCode Shortcuts
Use the shortcut Ctrl + . (Windows/Linux) or Cmd + . (Mac) to bring up the Quick Fix menu.


### Spring Boot
Spring Boot is an extension of the Spring Framework that simplifies the process of creating stand-alone, production-ready Spring applications.

Key Features:
- Auto-configuration: Automatically configures your Spring application based on the dependencies you have added.
- Embedded Servers: Comes with embedded servers like Tomcat, Jetty, or Undertow, eliminating the need to deploy WAR files.
- Starter Dependencies: Pre-configured dependency descriptors to simplify build configuration, e.g., spring-boot-starter-web.
- Production-ready: Includes features like metrics, health checks, and externalized configuration, making it easier to move to production.

Basic Project Structure:
- src/main/java: Contains your main application code.
- src/main/resources: Contains configuration files like application.properties.
- ```pom.xml``` or ```build.gradle```: Project’s build configuration and dependencies.

Core Concepts and Annotations:
- @SpringBootApplication: A convenience annotation that includes @Configuration, @EnableAutoConfiguration, and @ComponentScan.
- @RestController: Combines @Controller and @ResponseBody, used for creating RESTful web services.
- @RequestMapping: Maps HTTP requests to handler methods of MVC and REST controllers.
- @Autowired: Automatically injects dependencies, similar to dependency injection in other frameworks like Node.js.


When is the target Folder Generated?
- The target folder is created when you run build commands such as mvn package, mvn install (for Maven), or gradle build (for Gradle). Each time you build the project, the existing target folder may be cleaned and recreated with fresh contents.

### RESTful API
Creating a RESTful API (API Layer), and Business Layer (Service Layer)

1. Define a Controller:
File path ```src/main/java/com/example/demo/DemoApplication.java```

```java
@SpringBootApplication
@RestController
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping
	public String hello() {
		return "Hello World";
	}
}

```

2. Run the Application:
In your main class with the @SpringBootApplication annotation, right-click and select “Run” or execute mvn spring-boot:run in the terminal.
Visit http://localhost:8080 to see your first Spring Boot endpoint in action.

#### Dependency Injection:
The StudentService is injected into the StudentController through the constructor. Spring automatically provides the StudentService when the controller is created.

Define a Controller and Service. Routing visit ```src/main/java/com/example/demo/student```.

### Using Database (PostgreSQL)
Use This docker-compose.yml File, Run the Docker Compose Command:

```
docker-compose up -d
```

Common psql Commands for Database Interaction
- \l: List all databases.
- \c database_name: Connect to a specific database.
- \dt: List all tables in the current database.
- \du: List all the roles (users) in current database along with their attributes.
- \d table_name: Describe the structure of a specific table.
- SELECT * FROM table_name;: Query data from a table.
- \q: Quit the psql shell.

Database config ```src/main/resources/application.properties```

XML Dependency, ```pom.xml```

```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```

Create table into database, ```src/main/java/com/example/demo/student/Student.java```

```java
@Entity
@Table
public class Student {
  @Id
  @SequenceGenerator(
    name = "student_sequence",
    sequenceName = "student_sequence",
    allocationSize = 1
  )
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
  ...
  ...
}
```
#### Data Access Layer (Repository)
Database Configuration, ```src/main/java/com/example/demo/student/StudentConfig.java```

StudentRepository, ```src/main/java/com/example/demo/student/StudentRepository.java```
```java
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
  // You can define custom query methods here if needed
}
```

Update StudentService, ```src/main/java/com/example/demo/student/StudentService.java```
```java
@Service
public class StudentService {

  private final StudentRepository studentRepository;

  @Autowired
  public StudentService(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  public List<Student> getStudents() {
    return studentRepository.findAll();
  }
}
```

#### Spring Data JPA

### Security

### Testing

### Performance - Using Redis

### Deployment

### Monitoring

### Spring Cloud Config


