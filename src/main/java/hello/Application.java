
package hello;

import hello.wsdl.GetCountryResponse;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner lookup(CountryClient countryClient) {
		return args -> {
			String name = "Spain";

			if (args.length > 0) {
				name = args[0];
			}
			
			GetCountryResponse response = countryClient.getCountry(name);
			System.out.println(response.getCountry().getCapital());
		};
	}

}
