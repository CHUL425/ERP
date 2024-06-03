// package com.erp.bulletinboard.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestHeader;
// import org.springframework.web.bind.annotation.RestController;

// import com.erp.bulletinboard.model.UserDTO;
// import com.erp.bulletinboard.security.JwtProvider;

// import jakarta.servlet.http.HttpServletResponse;


// @RestController
// public class LoginController {

//     @Autowired
//     private JwtProvider jwtProvider;
//     /**
//      * JWT 을 생성하는 Login 요청
//      * [GET] - /login
//      * body : 
//             {
//                 "username" : "joeun",
//                 "password" : "123456"
//             }
//      * @param user
//      * @return
//      */
//     // 사용자로부터 전달받은 인증 정보
//     @PostMapping("/auth/login")
//     public ResponseEntity<?> login(@RequestBody UserDTO user, HttpServletResponse response) {
//         String userId   = user.getUserId();
//         String password = user.getPassword();
//         String role     = "ROLE_USER";

//         // System.out.println("userId  :[" + userId   + "]");
//         // System.out.println("password:[" + password + "]");
//         // System.out.println("role    :[" + role     + "]");

//         // JWT 토큰 생성
//         String jwt = jwtProvider.generateToken(userId, role);
//         // System.out.println("jwt:[" + jwt + "]");
        
//         // HttpOnly Cookle  생성 및 클라이언트 전달
//         // Cookie cookie = new Cookie("JWT", JwtConstants.TOKEN_PREFIX + jwt);
//         // cookie.setHttpOnly(true);
//         // cookie.setPath("/");
//         // response.addCookie(cookie);
        
//         // 생성된 토큰을 클라이언트에게 반환
//         return new ResponseEntity<String>(jwt, HttpStatus.OK);
//     }


//     /**
//      * JWT 를 해석하는 요청
//      * 
//      * @param header
//      * @return
//      */
//     @GetMapping("/user/info/me")
//     public ResponseEntity<String> userInfo(@RequestHeader(name="Authorization") String header) {

//         // log.info("===== header =====");
//         // log.info("Authorization : " + header);

//         // ParsedTokenDTO parsedTokenDTO = jwtProvider.getUserIdFromJWT(header);
 
//         // return new ResponseEntity<String>(parsedTokenDTO.getParsedToken(), HttpStatus.OK);
        
//         return null;
//     }
// }