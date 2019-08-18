package org.redquark.features.java11.http;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Asynchronous communication is useful if we don’t want to wait for the
 * response. We provide callback handler, which gets executed when response is
 * available.
 * 
 * @author Anirudh Sharma
 *
 */
public class Asynchronous {

	public static void main(String[] args) {

		// List of URIs
		final List<URI> uri = Stream.of("https://www.google.com/", "https://www.github.com/", "https://www.yahoo.com/")
				.map(URI::create).collect(Collectors.toList());

		HttpClient httpClient = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(10))
				.followRedirects(HttpClient.Redirect.ALWAYS).build();

		@SuppressWarnings("rawtypes")
		CompletableFuture[] futures = uri.stream().map(u -> verifyUri(httpClient, u)).toArray(CompletableFuture[]::new);

		CompletableFuture.allOf(futures).join();
	}

	private static CompletableFuture<Void> verifyUri(HttpClient httpClient, URI uri) {

		var request = HttpRequest.newBuilder().timeout(Duration.ofSeconds(5)).uri(uri).build();

		return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString()).thenApply(HttpResponse::statusCode)
				.thenApply(statusCode -> statusCode == 200).exceptionally(ex -> false).thenAccept(valid -> {
					if (valid) {
						System.out.println("[SUCESSS] Verified " + uri);
					} else {
						System.out.println("[FAILURE] could not verify " + uri);
					}
				});
	}
}
