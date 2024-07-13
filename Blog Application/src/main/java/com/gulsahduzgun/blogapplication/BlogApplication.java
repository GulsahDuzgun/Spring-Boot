package com.gulsahduzgun.blogapplication;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

// Mongo aktif etmek ici
// @EnableMongoRepositories

// Aspect aktif etmek icin
// @EnableAspectJAutoProxy(proxyTargetClass = true)

// Asenkron açmak icin
// @EnableAsync

// SCAN
// @EntityScan(basePackages = "com.gulsahduzgun.data.entity") //Entity bulamadığı zaman
// @EnableJpaRepositories(basePackages = "com.gulsahduzgun.data.repository") //Repository bulamadığı zaman

// Spring Cache aktif etmek gerekiyor.
// @EnableCaching

// Auditing Aktif etmek
// @EnableJpaAuditing(auditorAwareRef = "auditorAwareBeanMethod")

// Spring Security: Şimdilik dahil etme ancak Spring security için gerekli kütüphaneleri dahil
@SpringBootApplication(exclude = {
        //SecurityAutoConfiguration.class,
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
        org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class
}
)
// @SpringBootApplication
//public class FullStackDeveloper12Application {

// Apache Tomcat için: extends SpringBootServletInitializer


//@SpringBootApplication
public class BlogApplication {

    @PostConstruct
    public void init() {
        TimeZone.setDefault(TimeZone.getTimeZone("IST"));
    }

    public static void main(String[] args) {

        // devtools active isActive
        // System.setProperty("spring.devtools.restart.enabled","true");



        // JOptional pane aktif etmek
        System.setProperty("java.awt.headless", "false");

        // Main
        SpringApplication.run(BlogApplication.class, args);
    } // end PSVM

} // end class