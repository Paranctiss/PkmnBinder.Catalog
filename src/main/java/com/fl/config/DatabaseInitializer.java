package com.fl.config;

@Configuration
public class DatabaseInitializer {
    @Bean
    public CommandLineRunner initDatabase(FindExtensionRepository findExtensionRepository) {
        return args -> {
            findExtensionRepository.save(new Extension("FireExtension", "Extension pour les capacités liées au feu."));
            System.out.println("Extensions initiales ajoutées à MongoDB.");
        };
    }
}
