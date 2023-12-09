package EIST24L03PB03.Client;

import EIST24L03PB03.FollowRequest;
import EIST24L03PB03.Tweet;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import EIST24L03PB03.User;

import java.util.List;


public class Client {
    private RestTemplate restTemplate;
    HttpHeaders headers = new HttpHeaders();
    private static final String loginMicroserviceURL = "http://localhost:8080/login";
    private static final String tweetMicroserviceURL = "http://localhost:8081/tweet";
    private static final String followMicroserviceURL = "http://localhost:8082/follow";
    private static final String messageBrokerURL = "http://localhost:8083/mb";
    private static final String pageMicroserviceURL = "http://localhost:8085/page";


    public Client() {
        this.restTemplate = new RestTemplate();
    }

    public String performLogin(User user){

        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<User> requestEntity = new HttpEntity<>(user, headers);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(loginMicroserviceURL+"/performLogin", requestEntity, String.class);

        return responseEntity.getBody();
    }
    public String sendTweet(Tweet tweet){
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Tweet> requestEntity = new HttpEntity<>(tweet, headers);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(messageBrokerURL+"/tweet/send", requestEntity, String.class);

        return responseEntity.getBody();
    }

    public String deleteTweet(Tweet tweet){

        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Tweet> requestEntity = new HttpEntity<>(tweet, headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(tweetMicroserviceURL+"/delete", HttpMethod.DELETE, requestEntity, String.class);

        return responseEntity.getBody();

    }

    public String follow(User follower, User followed){
        FollowRequest followRequest=new FollowRequest(follower,followed);

        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<FollowRequest> requestEntity = new HttpEntity<>(followRequest, headers);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(followMicroserviceURL+"/follow", requestEntity, String.class);

        return responseEntity.getBody();
    }
    public String unfollow(User follower, User followed){
        FollowRequest followRequest=new FollowRequest(follower,followed);
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<FollowRequest> requestEntity = new HttpEntity<>(followRequest, headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(followMicroserviceURL+"/unfollow", HttpMethod.DELETE, requestEntity, String.class);

        return responseEntity.getBody();
    }

    public void showHomePage(User user){
        // TODO: implement this method
    }
    public void showTimeLine(User user){
        //TODO: implement this method
    }
}
