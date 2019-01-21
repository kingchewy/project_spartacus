package at.nightfight.repository.config;

        import at.nightfight.model.User;
        import org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration;
        import org.springframework.context.annotation.Configuration;
        import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
        import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
        import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
        import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

@Configuration
public class RepositoryConfig extends RepositoryRestConfigurerAdapter {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(User.class);
    }
}