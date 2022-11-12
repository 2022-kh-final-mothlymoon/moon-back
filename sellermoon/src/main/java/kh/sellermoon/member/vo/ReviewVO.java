package kh.sellermoon.member.vo;

import lombok.Data;

@Data
public class ReviewVO {
	
	private int    md_review_no              =0;
	private int    member_no                 =0;
	private int    md_no                     =0;
	private String md_review_content         ="";
	private String md_review_written_date    ="";
	private int    md_review_like            =0;
	private int    md_star                   =0;
	private String best_review               ="";

}
