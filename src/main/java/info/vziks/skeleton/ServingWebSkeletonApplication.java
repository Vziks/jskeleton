package info.vziks.skeleton;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Class ServingWebSkeletonApplication
 * Project web-spring
 *
 * @author Anton Prokhorov <vziks@live.ru>
 */
@SpringBootApplication
@EnableCaching
public class ServingWebSkeletonApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServingWebSkeletonApplication.class, args);
    }
}
