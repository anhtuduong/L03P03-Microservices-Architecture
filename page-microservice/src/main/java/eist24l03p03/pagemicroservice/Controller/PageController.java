package eist24l03p03.pagemicroservice.Controller;

import eist24l03p03.pagemicroservice.User;
import eist24l03p03.pagemicroservice.Tweet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

import java.util.ArrayList;
import java.util.List;



@RestController
@RequestMapping("/page")
public class PageController {

    private RestTemplate restTemplate = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();
    private static final String getActivityURL = "http://localhost:8084/activity/getActivity/";
    private static final String getFollowedListURL = "http://localhost:8084/activity/getFollowedList/";

    // page of one user
    @GetMapping("/getTimeLine/{id}")
    public List<Tweet> getTimeLine(@PathVariable("id") int userID) {
        headers.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<List<Tweet>> res = restTemplate.exchange(getActivityURL+userID, HttpMethod.GET, null, new ParameterizedTypeReference<List<Tweet>>() {});
        return res.getBody();
    }

    // pages of the followed users, i.g. feed
    @GetMapping("/getHomePage/{id}")
    public List<Tweet> getHomePage(@PathVariable("id") int userID) {
        headers.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<List<User>> followedUsers = restTemplate.exchange(getFollowedListURL+userID, HttpMethod.GET,null, new ParameterizedTypeReference<List<User>>() {});
        List<User> followed = followedUsers.getBody();
        List<Tweet> homePage= new ArrayList<>();
        assert followed != null;
        followed.forEach(x->{
            List<Tweet> usersTimeLine = getTimeLine(x.getUserID());
            homePage.addAll(usersTimeLine);
        });
        return homePage;
    }

}
