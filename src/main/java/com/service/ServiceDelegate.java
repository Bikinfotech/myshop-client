package com.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.model.Category;
import com.model.Login;
import com.model.Product;

@Service
public class ServiceDelegate {
	
	@Autowired
	private RestTemplate template;
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}	
	
	public String register(Login login) {
		System.out.println(login);
		String response  = null;
		try {
			response = template.postForObject(new URI("http://myshop-service/register"), login, String.class);
		} catch (RestClientException | URISyntaxException e) {
			e.printStackTrace();
		}		
		return response;
	}
	
	public String verify(Login login) {
		System.out.println(login);
		String response  = null;
		try {
			response = template.postForObject(new URI("http://myshop-service/verify"), login, String.class);
		} catch (RestClientException | URISyntaxException e) {
			e.printStackTrace();
		}		
		return response;
	}
	
public ArrayList<Product> listAllProduct(){
		
		ArrayList<Product> productList = new ArrayList<Product>();
		productList.add(new Product("Nike", Category.SHOES, 75.00, 5.5));
		productList.add(new Product("Adidas", Category.SHOES, 65.00, 10));
		productList.add(new Product("Puma", Category.SHOES, 55.00, 15));
		productList.add(new Product("Reebok", Category.SHOES, 70.00, 8.5));
		productList.add(new Product("Samsung", Category.ELECTRONICS, 600.00, 9.5));
		productList.add(new Product("LG", Category.ELECTRONICS, 750.00, 7.5));
		productList.add(new Product("Sony", Category.ELECTRONICS, 950.00, 4.5));
		productList.add(new Product("Vizio", Category.ELECTRONICS, 550.00, 12.5));
		
		return productList;
		
	}


}
