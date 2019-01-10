package nightfight.util.authentication;

import java.io.IOException;
import java.security.Key;
import java.util.logging.Logger;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import io.jsonwebtoken.Jwts;
import nightfight.util.KeyGenerator;

@Secured
@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthenticationFilter implements ContainerRequestFilter{
	
	private static final Logger LOGGER = Logger.getLogger(AuthenticationFilter.class.getName());
	
	private static final String REALM = "example";
	private static final String AUTHENTICATION_SCHEME = "Bearer";
	
	
	@Inject
	private KeyGenerator keyGenerator;

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {

		// GET the Authorization header from the request
		String authorizationHeader =  requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
		
		// Validate the Authorization header
		if (!isTokenBasedAuthentication(authorizationHeader)) {
			abortWithUnauthorized(requestContext);
			return;
		}
		
		
		// Extract the token from the Authorization header
		String token = authorizationHeader.substring(AUTHENTICATION_SCHEME.length()).trim();
		
		
		try {
			// Validate the token
			validateToken(token);
		} catch (Exception e) {
			abortWithUnauthorized(requestContext);
		}
	}

	
    private boolean isTokenBasedAuthentication(String authorizationHeader) {

        // Check if the Authorization header is valid
        // It must not be null and must be prefixed with "Bearer" plus a whitespace
        // The authentication scheme comparison must be case-insensitive
        return authorizationHeader != null && authorizationHeader.toLowerCase()
                    .startsWith(AUTHENTICATION_SCHEME.toLowerCase() + " ");
    }
    
    private void abortWithUnauthorized(ContainerRequestContext requestContext) {

        // Abort the filter chain with a 401 status code response
        // The WWW-Authenticate header is sent along with the response
    	
    	LOGGER.severe("##### invalid token");
    	
        requestContext.abortWith(
                Response.status(Response.Status.UNAUTHORIZED)
                        .header(HttpHeaders.WWW_AUTHENTICATE, 
                                AUTHENTICATION_SCHEME + " realm=\"" + REALM + "\"")
                        .build());
    }
    
    private void validateToken(String token) throws Exception {
        // Check if the token was issued by the server and if it's not expired
        // Throw an Exception if the token is invalid
    	
    	Key key = keyGenerator.generateKey();
    	Jwts.parser().setSigningKey(key).parseClaimsJws(token);
    	LOGGER.info("###### valid token: " + token);
    }
}
