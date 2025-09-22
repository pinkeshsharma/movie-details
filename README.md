# Movie Details

A simple Java project to manage and fetch details about movies.  
Built with **Java** and **Maven**.

---

## Features
- Create and manage movie records  
- Fetch movies by title or release year  
- Retrieve all stored movies  
- Easy to extend with more movie attributes  

---

## Tech Stack
- **Java 17+**  
- **Spring Boot** (if used in service layer)  
- **Maven** for build and dependency management  

---

## Getting Started

### Prerequisites
- JDK 17 or later  
- Maven 3.8+ (or use included Maven wrapper)

### Clone the Repository
```bash
git clone https://github.com/pinkeshsharma/movie-details.git
cd movie-details
```

### Build
```bash
mvn clean install
```

### Run
```bash
mvn spring-boot:run
```

---

## Example Usage

### Create a Movie
```java
MovieRequest req = new MovieRequest();
req.setTitle("Inception");
req.setReleaseYear(2010);

Movie movie = movieService.createMovie(req);
```

### Fetch by Title
```java
List<Movie> movies = movieService.getByTitle("Inception");
```

### Fetch All
```java
List<Movie> movies = movieService.getAllMovies();
```

---

## Testing
Run unit tests with:
```bash
mvn test
```

---

## Project Structure
```
movie-details/
 ├─ src/main/java/com/real/interview/
 │   ├─ controller/   # REST controllers
 │   ├─ service/      # Business logic
 │   ├─ dto/          # Request/response DTOs
 │   └─ db/           # Repository + entities
 ├─ src/test/java/    # Unit and integration tests
 ├─ pom.xml           # Maven config
 └─ README.md
```


---

## 👤 Author
Developed by **Pinkesh Sharma**  
[GitHub Profile](https://github.com/pinkeshsharma)
