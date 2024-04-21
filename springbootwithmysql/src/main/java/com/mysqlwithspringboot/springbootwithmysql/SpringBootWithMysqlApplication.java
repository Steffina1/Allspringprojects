package com.mysqlwithspringboot.springbootwithmysql;

import com.mysqlwithspringboot.springbootwithmysql.entity.StoreInformationProperties;
import com.mysqlwithspringboot.springbootwithmysql.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootWithMysqlApplication  implements CommandLineRunner {
	@Autowired
StoreRepository storeRepository;
	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithMysqlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		StoreInformationProperties storeInformationPropertiesOne= new StoreInformationProperties("Myntra" , "Hyderabad", "12345");
		StoreInformationProperties storeInformationPropertiesTwo= new StoreInformationProperties("Amazon" , "Chennai", "56776");
		StoreInformationProperties storeInformationPropertiesThree= new StoreInformationProperties("Flipkart" , "Chennai", "4354");
		StoreInformationProperties storeInformationPropertiesFour= new StoreInformationProperties("Meesho" , "Mysore", "353653");
		storeRepository.save(storeInformationPropertiesOne);
		storeRepository.save(storeInformationPropertiesTwo);
		storeRepository.save(storeInformationPropertiesThree);
		storeRepository.save(storeInformationPropertiesFour);

		storeRepository.findById(1).ifPresent(System.out::println);
		storeRepository.findBystoreAddress("Hyderabad").forEach(System.out::println);
		storeRepository.findBystoreName("Myntra").forEach(System.out::println);
		storeRepository.findBystorePhoneNum("56776").forEach(System.out::println);
	 System.out.println(storeRepository.count());
		storeRepository.deleteById(3);
		System.out.println("After deleting" +storeRepository.count());


	}
}
