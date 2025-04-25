package com.huntforwind.software.users.infra;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName SpringDocConfig
 * @Description
 * @Author
 * @Date 2024/8/28 15:55
 * @Version 1.0
 */
@Configuration
public class SpringDocConfig {

    @Bean
    public OpenAPI createOpenApi() {
        return new OpenAPI()
                .info(createInfo());
    }

    private Info createInfo() {
        return new Info()
                .contact(createContact())
                .title("yyh test")
                .description("yyh description")
                .version("1.0.0");
    }

    private Contact createContact() {
        Contact contact = new Contact();
        contact.name("yyh");
        contact.url("http://www.huntforwind.com");
        contact.email("734251078@qq.com");
        return contact;
    }
}
