package jEspinola.Inventario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class InventarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventarioApplication.class, args);
	}

	/**
	 * Método para configurar el CORS (Cross-Origin Resource Sharing)
	 * Esto es necesario para que Angular pueda hacer peticiones a este servidor
	 * Despues de todo un dia buscando, este tio me acaba de salvar
	 * Al usar el routerLink de Spring y moverme entre componentes, da error de CORS por lo que se necesita configurar
	 * https://www.youtube.com/watch?v=jJTfuiyEqb8
	 */
	@Bean // Se crea un bean para configurar el CORS
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:4200").allowedMethods("GET", "POST", "PUT", "DELETE").allowedHeaders("*");
			}
		};
	}

	/**
	 * Método para configurar el MultipartResolver
	 * Esto es necesario para poder subir archivos al servidor
	 */
	@Bean
	public MultipartResolver multipartResolver() {
		return new StandardServletMultipartResolver();
	}


}
