package exercise;

import exercise.daytime.Day;
import exercise.daytime.Night;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import exercise.daytime.Daytime;

// BEGIN
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.annotation.RequestScope;

import java.time.LocalDateTime;
// END

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // BEGIN
    @RequestScope
    @Bean
    public Daytime getDateTme() { // Имя метода не важно
        var hour = LocalDateTime.now().getHour();

        return (hour >= 6 && hour < 22) ? new Day() : new Night();
    }
    // END
}
