package net.anassploit.inventoryservice;

import net.anassploit.inventoryservice.entities.Product;
import net.anassploit.inventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository) {
        return args -> {
          productRepository.save(
                  Product.builder()
                          .id(UUID.randomUUID().toString())
                          .name("Computer")
                          .price(4000)
                          .quantity(32)
                          .build()
          );
            productRepository.save(
                    Product.builder()
                            .id(UUID.randomUUID().toString())
                            .name("Printer")
                            .price(1200)
                            .quantity(21)
                            .build()
            );
            productRepository.save(
                    Product.builder()
                            .id(UUID.randomUUID().toString())
                            .name("Smart Phone")
                            .price(3000)
                            .quantity(8)
                            .build()
            );

            productRepository.findAll().forEach(p -> {
                System.out.println(p.toString());
            });
        };
    }
}
