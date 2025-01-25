package Catalogo.Catalogo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {
    
    @Bean
    public OpenAPI  customOpenApi(){
        return new OpenAPI()
               .info(new Info()
                    .title("API de funciones de Catalogo")
                    .description("Documentación para el servicio de catalogo")
                    .version("1.0")
                    .contact(new Contact()
                        .name("Envio MAS")
                        .url("https://youtube.com"))
                    .license(new License()
                        .name("Apache 2.0")
                        .url("http://www.apache.org/licenses/LICENSE-2.0.html")));
    }
}
