package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    //데이터베이스에서 가져올떄 이녀석을 사용해야되서 인터페이스를 구현해야됨!
    @Autowired
    CustomUserDetailsService customUserDetailsService;



    //   /webjars/** 경로에 대한 요청은 인증/인가 처리하지 않도록 무시합니다.
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(
                "/webjars/**");
    }

    //   /, /main에 대한 요청은 누구나 할 수 있지만,
    //   그 외의 요청은 모두 인증 후 접근 가능합니다.
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(customUserDetailsService);
    }
   @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/","/main","/memembers/loginerror","/members/joinform","/members/join","/members/welcome").permitAll()
                .antMatchers("/securepage","/members/**").hasRole("USER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/members/loginform")
                .usernameParameter("userId")
                .passwordParameter("password")
                .loginProcessingUrl("/authenticate")

                .failureForwardUrl("/members/loginerror?login_error=1")
                .defaultSuccessUrl("/",true)
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/");
    }
    // 패스워드 인코더를 빈으로 등록합니다. 암호를 인코딩하거나,
    // 인코딩된 암호와 사용자가 입력한 암호가 같은 지 확인할 때 사용합니다.
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}
