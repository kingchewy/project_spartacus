package nightfight.resource;

import java.security.Key;
import java.util.Date;


import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import nightfight.util.KeyGenerator;
import nightfight.util.authentication.Credentials;

@Path("/authentication")
public class AuthenticationResource {
	
	@Context
    private UriInfo uriInfo;
	
	@Inject
	private KeyGenerator keyGenerator;
	
	@POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response authenticateUser(Credentials credentials) {

		String username = credentials.getUsername();
		String password = credentials.getPassword();
		
        try {

            // Authenticate the user using the credentials provided
            authenticate(username, password);

            // Issue a token for the user
            String token = issueToken(username);

            // Return the token on the response
            return Response.ok(token).build();

        } catch (Exception e) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }      
    }

    private void authenticate(String username, String password) throws Exception {
    	System.out.println("####### trying authenticate user password");
        // Authenticate against a database, LDAP, file or whatever
        // Throw an Exception if the credentials are invalid
    	if(username.equals("martin") == false || password.equals("chewy") == false) {

    		System.out.println("####### username not martin or password not chewy: " + username + " / " + password);
    		throw new NotAuthorizedException("user or passwor invalid");
    	}
    }

    private String issueToken(String username) {
    	Key key = keyGenerator.generateKey();
        String jwtToken = Jwts.builder()
                .setSubject(username)
                .setIssuer(uriInfo.getAbsolutePath().toString())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + (1000*60*60*24))) // = 1 Day
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();
        return jwtToken;
    }


}
