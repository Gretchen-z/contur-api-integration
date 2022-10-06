package ru.gretchen.conturapiintegration;

import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import ru.gretchen.conturapiintegration.logging.InterceptorConfig;
import ru.gretchen.conturapiintegration.logging.LoggerInterceptor;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@Import({InterceptorConfig.class})
public class ConturApiIntegrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConturApiIntegrationApplication.class, args);
    }
}
