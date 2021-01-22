package http.connect.pool.authentication;


import org.apache.http.auth.UsernamePasswordCredentials;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2021/1/22
 * @description
 * @copyright COPYRIGHT © 2014 - 2021 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class AuthenticationTest {
    public static void main(String[] args) {
        UsernamePasswordCredentials creds = new UsernamePasswordCredentials("user", "pwd");
        System.out.println(creds.getUserPrincipal().getName());
        System.out.println(creds.getPassword());
    }
}
