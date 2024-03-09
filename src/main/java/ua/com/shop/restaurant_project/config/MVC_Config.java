package ua.com.shop.restaurant_project.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MVC_Config implements WebMvcConfigurer
{
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry reg)
    {
        reg.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
}

/*
 * Дозволяє використовувати статичні ресурси
 * (наприклад, CSS, JavaScript або зображення)
 * у веб-застосунку. Шлях /static/** вказує
 * на те, що статичні ресурси будуть доступні за URL
 * типу /static/..., і вони знаходяться в директорії
 * classpath:/static/.
*/