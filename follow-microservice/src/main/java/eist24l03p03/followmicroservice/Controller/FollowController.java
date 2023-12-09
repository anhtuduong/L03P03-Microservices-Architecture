package eist24l03p03.followmicroservice.Controller;

import eist24l03p03.followmicroservice.FollowRequest;
import eist24l03p03.followmicroservice.User;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/follow")
public class FollowController {

    @PostMapping("/follow")
    public String follow(@RequestBody FollowRequest followRequest) {
        User followedUser = followRequest.getFollowed();
        User followerUser = followRequest.getFollower();
            // TODO: implement this method
        return null;
    }

    @DeleteMapping("/unfollow")
    public String unfollow(@RequestBody FollowRequest followRequest) {
        User followedUser = followRequest.getFollowed();
        User followerUser = followRequest.getFollower();
            // TODO: implement this method
        return null;
    }
}