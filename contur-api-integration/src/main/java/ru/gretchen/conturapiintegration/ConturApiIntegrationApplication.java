package ru.gretchen.conturapiintegration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import ru.gretchen.conturapiintegration.logging.InterceptorConfig;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@Import({InterceptorConfig.class})
public class ConturApiIntegrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConturApiIntegrationApplication.class, args);
    }

}
