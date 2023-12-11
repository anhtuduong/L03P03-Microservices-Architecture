package eist24l03p03.pagemicroservice.Controller;

import eist24l03p03.pagemicroservice.User;
import eist24l03p03.pagemicroservice.Tweet;


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
    public List<Tweet> getTimeLine(@PathVariable("id") int userID) {

        List<Tweet>  timeLine = new ArrayList<>();
        return timeLine;
    }

    // pages of the followed users, i.g. feed
    public List<Tweet> getHomePage(@PathVariable("id") int userID) {

        List<Tweet> homePage= new ArrayList<>();
        return homePage;
    }



}