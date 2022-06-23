package Instagram.jpa;

public class SecurityConstants {

	public static final String SECRET = "SECRET_KEY";
	public static final long EXPIRATION_TIME = 900_000; // 15 min, racina se dan * sat * minut * seund * milisekund
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_STRING = "Authorization";
	public static final String SIGN_UP_URL = "/api/services/controller/user";
}
