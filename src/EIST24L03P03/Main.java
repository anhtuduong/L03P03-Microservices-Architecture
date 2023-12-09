package EIST24L03P03;
import EIST24L03P03.Client.Client;

import java.text.ParseException;

public class Main {
    private final Client client = new Client();

    public static void main(String[] args) throws ParseException {

        Client client1 = new Client();
        User user = new User("testuser","passw");
        User user1 = new User("testuser","passw");
        Tweet tweet = new Tweet("test",user,1);
        Tweet tweet2 = new Tweet("test2",user,2);
        Tweet tweet3 = new Tweet("test3",user,3);
        Tweet tweet4 = new Tweet("test4",user,4);
        Tweet tweet5 = new Tweet("test5",user,5);
        Tweet tweet6 = new Tweet("test6",user,6);
        Tweet tweet7 = new Tweet("test6",user1,7);
        System.out.println(client1.sendTweet(tweet));
        System.out.println(client1.sendTweet(tweet2));
        System.out.println(client1.sendTweet(tweet3));
        System.out.println(client1.sendTweet(tweet4));
        System.out.println(client1.sendTweet(tweet5));
        System.out.println(client1.sendTweet(tweet6));
        System.out.println(client1.sendTweet(tweet7));
        try {
            // Sleep for 5 seconds (5000 milliseconds)
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // Handle the exception if needed
            e.printStackTrace();
        }
        

    }
    	public void operate() {
        /*Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        User user = new User(username, password);
        String loginResponse = client.performLogin(user);
        
        if (loginResponse.contains("successful")) {
            System.out.println("Login Successful!");


            System.out.print("Enter your tweet: ");
            String text = scanner.nextLine();
            Tweet tweet= new Tweet(text);
            System.out.println(client.sendTweet(tweet));
            System.out.println("?Do you want to delete the tweet? Answer yes or no");

            if(scanner.nextLine().contains("yes")){
                client.deleteTweet(tweet);
            }

        } else {
            System.out.println("Login failed: " + loginResponse);
        }

        scanner.close();*/
    }
}
