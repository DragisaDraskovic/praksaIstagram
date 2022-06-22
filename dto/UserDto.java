package Instagram.dto;

import java.util.Date;

import lombok.Data;

@Data
public class UserDto {
	private String firstName;
	private String secondName;
	//private Date date;
	private String email;
	
	//da li trebaju i ostale promenjljive koje nisu u izvornom delu klase
}
