package kh.sellermoon.member.vo;

import lombok.Data;

@Data
public class MemberVO {
	
	  private int    member_no       = 0;    
	  private String member_address  = ""; 
	  private String member_method   = ""; 
	  private int    member_level    = 0; 
	  private String member_password = ""; 
	  private String member_name     = ""; 
	  private int    member_phone    = 0; 
	  private String member_birth    = ""; 
	  private int    member_zipcode  = 0; 
	  private String member_email    = ""; 
	  private String member_date    = ""; 

}
