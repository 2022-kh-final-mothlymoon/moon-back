package kh.sellermoon.member.vo;

import lombok.Data;

@Data
public class CartVO {

	private String cartNo;
	private int memberNo;       
	private int    mdNo;    
	private int    cartQuantity;       
	private String orderType;
	private MdVO mdVO;
	
	
}
