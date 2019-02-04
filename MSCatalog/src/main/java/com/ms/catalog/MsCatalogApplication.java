package com.ms.catalog;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.ms.catalog.model.Item;
import com.ms.catalog.repository.ItemRepository;

@SpringBootApplication
@EnableDiscoveryClient
public class MsCatalogApplication {

	private final ItemRepository itemRepository;

	@Autowired
	public MsCatalogApplication(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	@PostConstruct
	public void generateTestData() {
		itemRepository.save(new Item("iPod", 42.0));
		itemRepository.save(new Item("iPod touch", 21.0));
		itemRepository.save(new Item("iPod nano", 1.0));
		itemRepository.save(new Item("Apple TV", 100.0));
	}
	
	public static void main(String[] args) {
		SpringApplication.run(MsCatalogApplication.class, args);
	}

}

