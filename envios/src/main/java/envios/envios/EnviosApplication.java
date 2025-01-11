package envios.envios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import jakarta.validation.constraints.NotNull;

@SpringBootApplication
@EnableJpaAuditing
public class EnviosApplication implements WebMvcConfigurer{

	public static void main(String[] args) {
		SpringApplication.run(EnviosApplication.class, args);
	}

	@Override
	public void addCorsMappings(@NotNull CorsRegistry registry){
		registry.addMapping("/**")
		.allowedOrigins("http://localhost:4200")
		.allowedMethods("GET","POST","PUT","DELETE","OPTIONS")
		.allowedHeaders("*")
		.allowCredentials(true);
	}
}
