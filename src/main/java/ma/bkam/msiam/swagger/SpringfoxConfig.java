package ma.bkam.msiam.swagger;




import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SpringfoxConfig {
    //
//    @Value("${base.url}")
//    String host;
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
//                .host(Utilities.removeDuplicatedHttps(host))
                .select()
                .apis(RequestHandlerSelectors.basePackage("ma.bkam.msiam"))
                .paths(PathSelectors.any())
                .build();

    }
}
