package com.example.sem07hwSpringSecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     *
     * @param http the {@Link HttpSecurity} to modify.
     * @throws Exception исключение безопасности.
     */
    @Override
    // Настройки для защищенного http-запроса
    protected void configure(HttpSecurity http) throws Exception {
        // установка авторизации запроса
        http.authorizeRequests()
                // для запроса на private-data только роль админа
                .antMatchers("/private-data")
                .hasRole("ADMIN")
                // для запроса на public-data нужна аутентификация пользователя
                .antMatchers("/public-data")
                .authenticated()
                // разделитель фильтров
                .and()
                // задается страница аутентификации пользователя
                .formLogin()
                .loginPage("/login")
                // разрешается доступ всем к этой странице
                .permitAll()
                // перенаправление на обработку аутентификации
                .loginProcessingUrl("/process_login")
                // перенаправление после успешной аутентификации на публичную страницу
                .defaultSuccessUrl("/public-data")
                // обработка ошибки аутентификации
                .failureUrl("/login?error")
                .and()
                .logout()
                // перенаправление после выхода из аутентификации на домашнюю страницу
                .logoutSuccessUrl("/")
                .and()
                // дополнительно слушатель исключений
                // который обрабатывает исключения в отказе доступа
                // и перенаправляет пользователя на страницу access-denied
                .exceptionHandling()
                .accessDeniedPage("/access-denied");
    }

    /**
     * Бин UserDetailService с добавленными пользователями
     * @return объект UserDetailService.
     */
    @Bean
    public UserDetailsService userDetailsService(){
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        //создание дефольного пользователя
        //.withDefaultPasswordEncoder - вшито переопределение пароля энкодера.
        // алгоритм бикрипт является дефолтным - это алгоритм хэширование
        // (не шифрования, в шифровании есть обязательно ключ).
        manager.createUser(User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USER")
                .build());
        manager.createUser(User.withDefaultPasswordEncoder()
                .username("admin")
                .password("password")
                .roles("ADMIN")
                .build());
        return manager;
    }
}
