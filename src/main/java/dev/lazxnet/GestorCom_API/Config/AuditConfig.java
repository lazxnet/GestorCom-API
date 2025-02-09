package dev.lazxnet.GestorCom_API.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class AuditConfig {

    @Bean
    public AuditorAware<String> auditorProvider() {
        // En un entorno real, esto debería devolver el usuario autenticado (ej: con Spring Security)
        return () -> Optional.of("system"); // Usuario por defecto
    }
}
