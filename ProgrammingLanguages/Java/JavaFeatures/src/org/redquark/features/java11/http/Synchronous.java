package org.redquark.features.java11.http;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

/**
 * @author Anirudh Sharma
 *
 */
public class Synchronous {

	public static void main(String[] args) {

		// Creating instance of HttpClient
		HttpClient httpClient = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(10)).build();

		try {

			String endpoint = "https://postman-echo.com/get";
			URI uri = URI.create(endpoint + "?foo1=bar1&foo2=bar2");

			HttpRequest request = HttpRequest.newBuilder().uri(uri).build();
			HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

			System.out.println("Status code: " + response.statusCode());
			System.out.println("Headers: " + response.headers().allValues("content-type"));
			System.out.println("Body: " + response.body());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
