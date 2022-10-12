package com.deextralucid.parcel.paystack.verifypaystack;

import java.util.Collections;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

@Service
public class VerificationServiceImpl implements VerificationService {

    private final RestTemplate restTemplate;

    public VerificationServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public String getPayment() {
        String url = "https://api.paystack.co/transaction/verify";
        return this.restTemplate.getForObject(url, String.class);
    }

    @Override
    public VerificationResponseDTO getPaymentStatus(@PathVariable("paymentRef") String paymentRef) {
        String url = "https://api.paystack.co/transaction/verify/" + paymentRef;
        return this.restTemplate.getForObject(url, VerificationResponseDTO.class, paymentRef);
    }

    @Override
    public VerificationResponseDTO getPaymentWithResponseHandling(@PathVariable("paymentRef") String paymentRef) {
        String url = "https://api.paystack.co/transaction/verify/" + paymentRef;
        ResponseEntity<VerificationResponseDTO> response = this.restTemplate.getForEntity(url,
                VerificationResponseDTO.class, paymentRef);
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            return null;
        }
    }

    @Override
    public VerificationResponseDTO getPaymentWithCustomHeaders(@PathVariable("paymentRef") String paymentRef) {
        String url = "https://api.paystack.co/transaction/verify/" + paymentRef;
        String key = "sk_test_a07a45baef63500fbf6ab432fffee907e2300e98";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("Authorization", "Bearer " + key);
        HttpEntity<VerificationResponseDTO> request = new HttpEntity<VerificationResponseDTO>(headers);

        ResponseEntity<VerificationResponseDTO> response = this.restTemplate.exchange(url, HttpMethod.GET, request,
                VerificationResponseDTO.class, paymentRef);

        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            return null;
        }

    }

    // public Data createData() {
    // String url = "https://api.paystack.co/transaction/verify/${paymentRef}";

    // // create headers
    // HttpHeaders headers = new HttpHeaders();
    // // set `content-type` header
    // headers.setContentType(MediaType.APPLICATION_JSON);
    // // set `accept` header
    // headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

    // // create a map for post parameters
    // Map<String, Object> map = new HashMap<>();
    // map.put("userId", 1);
    // map.put("title", "Introduction to Spring Boot");
    // map.put("body", "Spring Boot makes it easy to create stand-alone,
    // production-grade Spring based Applications.");

    // // build the request
    // HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);

    // // send POST request
    // ResponseEntity<Data> response = this.restTemplate.postForEntity(url, entity,
    // Data.class);

    // // check response status code
    // if (response.getStatusCode() == HttpStatus.CREATED) {
    // return response.getBody();
    // } else {
    // return null;
    // }
    // }

    // public Data createDataWithObject() {
    // String url = "https://api.paystack.co/transaction/verify/${paymentRef}";

    // // create headers
    // HttpHeaders headers = new HttpHeaders();
    // // set `content-type` header
    // headers.setContentType(MediaType.APPLICATION_JSON);
    // // set `accept` header
    // headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

    // // create a post object
    // // Data data = new Data(1, "Introduction to Spring Boot",
    // // "Spring Boot makes it easy to create stand-alone, production-grade Spring
    // based Applications.");

    // Data data = null;

    // // build the request
    // HttpEntity<Data> entity = new HttpEntity<>(data, headers);

    // // send POST request
    // return restTemplate.postForObject(url, entity, Data.class);
    // }

    // public void updatePost() {
    // String url = "https://jsonplaceholder.typicode.com/posts/{id}";

    // // create headers
    // HttpHeaders headers = new HttpHeaders();
    // // set `content-type` header
    // headers.setContentType(MediaType.APPLICATION_JSON);
    // // set `accept` header
    // headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

    // // create a post object
    // Post post = new Post(4, "New Title", "New Body");

    // // build the request
    // HttpEntity<Post> entity = new HttpEntity<>(post, headers);

    // // send PUT request to update post with `id` 10
    // this.restTemplate.put(url, entity, 10);
    // }

    // public Post updatePostWithResponse() {
    // String url = "https://jsonplaceholder.typicode.com/posts/{id}";

    // // create headers
    // HttpHeaders headers = new HttpHeaders();
    // // set `content-type` header
    // headers.setContentType(MediaType.APPLICATION_JSON);
    // // set `accept` header
    // headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

    // // create a post object
    // Post post = new Post(4, "New Title", "New Body");

    // // build the request
    // HttpEntity<Post> entity = new HttpEntity<>(post, headers);

    // // send PUT request to update post with `id` 10
    // ResponseEntity<Post> response = this.restTemplate.exchange(url,
    // HttpMethod.PUT, entity, Post.class, 10);

    // // check response status code
    // if (response.getStatusCode() == HttpStatus.OK) {
    // return response.getBody();
    // } else {
    // return null;
    // }
    // }

    // public void deletePost() {
    // String url = "https://jsonplaceholder.typicode.com/posts/{id}";

    // // send DELETE request to delete post with `id` 10
    // this.restTemplate.delete(url, 10);
    // }

    // public HttpHeaders retrieveHeaders() {
    // String url = "https://jsonplaceholder.typicode.com/posts";

    // // send HEAD request
    // return this.restTemplate.headForHeaders(url);
    // }

    // public Set<HttpMethod> allowedOperations() {
    // String url = "https://jsonplaceholder.typicode.com/posts";

    // // send HEAD request
    // return this.restTemplate.optionsForAllow(url);
    // }

    // public String unknownRequest() {
    // try {
    // String url = "https://jsonplaceholder.typicode.com/404";
    // return this.restTemplate.getForObject(url, String.class);
    // } catch (HttpStatusCodeException ex) {
    // // raw http status code e.g `404`
    // System.out.println(ex.getRawStatusCode());
    // // http status code e.g. `404 NOT_FOUND`
    // System.out.println(ex.getStatusCode().toString());
    // // get response body
    // System.out.println(ex.getResponseBodyAsString());
    // // get http headers
    // HttpHeaders headers= ex.getResponseHeaders();
    // System.out.println(headers.get("Content-Type"));
    // System.out.println(headers.get("Server"));
    // }

    // return null;
    // }

    // public RestService(RestTemplateBuilder restTemplateBuilder) {
    // // set connection and read timeouts
    // this.restTemplate = restTemplateBuilder
    // .setConnectTimeout(Duration.ofSeconds(500))
    // .setReadTimeout(Duration.ofSeconds(500))
    // .build();
    // }
}
