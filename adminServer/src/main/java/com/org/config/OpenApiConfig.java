package com.org.config;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.springdoc.core.SpringDocConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
@Import({SpringDocConfiguration.class})
public class OpenApiConfig {

        @Bean
        public OpenAPI customOpenAPI() throws FileNotFoundException, IOException, XmlPullParserException {

        Model model = new MavenXpp3Reader().read(new FileReader(System.getProperty("user.dir") + "/pom.xml"));

        return new OpenAPI()
                .info(new Info()
                        .title("My App")
                        .description("My App is a fantastic application that does great things!")
                        .termsOfService("http://my-app.com/terms")
                        .contact(new Contact()
                                .name("John Doe")
                                .email("johndoe@my-app.com")
                                .url("http://my-app.com"))
                        .version(model.getVersion()));
        }
        
    
}
