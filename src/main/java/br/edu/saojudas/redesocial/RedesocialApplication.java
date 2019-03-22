package br.edu.saojudas.redesocial;

import br.edu.saojudas.redesocial.infraestructure.service.TagService;
import br.edu.saojudas.redesocial.infraestructure.service.UploadService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RedesocialApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedesocialApplication.class, args);
    }

    @Bean
    CommandLineRunner init(UploadService service) {
        return (args) -> {
            service.init();
        };
    }
}
