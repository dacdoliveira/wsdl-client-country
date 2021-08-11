package com.dacdoliveira.wsdlclientcountry;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.dacdoliveira.wsdlclientcountry.clients.CountryClient;
import com.dacdoliveira.wsdlclientcountry.wsdl.GetCountryResponse;

@SpringBootApplication
public class WsdlClientCountryApplication {

	public static void main(String[] args) {
		SpringApplication.run(WsdlClientCountryApplication.class, args);
	}
	
	@Bean
    CommandLineRunner lookup(CountryClient quoteClient) {
        return args -> {
            String pais = "Brasil";

            GetCountryResponse response = quoteClient.getCountry(pais);
            System.out.println(response.getCountry().getCapital());
            System.out.println(response.getCountry().getCurrency());
            System.out.println(response.getCountry().getPopulation());

            response = quoteClient.getCountry("Espanha");
            System.out.println(response.getCountry().getCapital());
            System.out.println(response.getCountry().getCurrency());
            System.out.println(response.getCountry().getPopulation());
            
            response = quoteClient.getCountry("Inglaterra");
            System.out.println(response.getCountry().getCapital());
            System.out.println(response.getCountry().getCurrency());
            System.out.println(response.getCountry().getPopulation());
        };
    }

}
