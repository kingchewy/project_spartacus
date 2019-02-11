package at.nightfight.security;

import at.nightfight.security.jwt.JwtAuthEntryPoint;
import at.nightfight.security.jwt.JwtAuthTokenFilter;
import at.nightfight.security.services.UserDetailsServiceImpl;
import at.nightfight.service.*;
import at.nightfight.util.mapping.NullPropertyMapper;
import at.nightfight.util.serializer.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        prePostEnabled = true
)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtAuthEntryPoint unauthorizedHandler;

    @Bean
    public JwtAuthTokenFilter authenticationJwtTokenFilter() {
        return new JwtAuthTokenFilter();
    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

/*    @Bean
    public OwnedItemServiceImpl ownedItemsService(){
        return new OwnedItemServiceImpl();
    }*/

    @Bean
    public ShopServiceImpl shopService(){
        return new ShopServiceImpl();
    }

    @Bean
    public ShopItemServiceImpl shopItemService(){
        return  new ShopItemServiceImpl();
    }

    @Bean
    public ShopItemWeaponServiceImpl shopItemWeaponService(){
        return  new ShopItemWeaponServiceImpl();
    }

    @Bean
    public ShopItemArmorServiceImpl shopItemArmorService(){
        return new ShopItemArmorServiceImpl();
    }

    @Bean
    public ShopItemSpecialServiceImpl shopItemSpecialService(){
        return new ShopItemSpecialServiceImpl();
    }

    @Bean
    public EquippedGearServiceImpl equippedGearService(){
        return new EquippedGearServiceImpl();
    }

    @Bean
    public CharacterListSerializer characterListSerializer(){
        return new CharacterListSerializer();
    }

    @Bean
    public ShopShopItemsSerializer shopItemsSerializer(){
        return new ShopShopItemsSerializer();
    }

    @Bean
    public ShopItemShopsSerializer shopItemShopsSerializer(){
        return new ShopItemShopsSerializer();
    }

    @Bean
    public NullPropertyMapper beanUtil(){
        return new NullPropertyMapper();
    }

    @Bean
    public ShopItemSerializer shopItemSerializer(){
        return new ShopItemSerializer();
    }

    @Bean
    public CharacterSerializer characterSerializer(){return new CharacterSerializer();}

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable().
                authorizeRequests()
                .antMatchers("/authentication/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("authorization", "content-type", "x-auth-token"));
        configuration.setExposedHeaders(Arrays.asList("x-auth-token"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}