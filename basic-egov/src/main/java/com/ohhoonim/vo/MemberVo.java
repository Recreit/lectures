package com.ohhoonim.vo;

public class MemberVo {
	private String mbr_id        ;
	private String mbr_code       ;
	private String pwd            ;
	private String contact        ;
	private String sav_pnt        ;
	private String buy_pnt        ;
	private String chn_id         ;
	
	public String getMbr_id() {
		return mbr_id ;
	}
	public void setMbr_id(String mbr_id) {
		this.mbr_id = mbr_id;
	}
	
	public String getMbr_code() {
		return mbr_code;
	}
	public void setMbr_code(String mbr_code) {
		this.mbr_code = mbr_code;
	}
	
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	public String getSav_pnt() {
		return sav_pnt;
	}
	public void setSav_pnt(String sav_pnt) {
		this.sav_pnt = sav_pnt;
	}
	
	public String getBuy_pnt() {
		return buy_pnt;
	}
	public void setBuy_pnt(String buy_pnt) {
		this.buy_pnt = buy_pnt;
	}
	
	public String getChn_id() {
		return chn_id;
	}
	public void setChn_id(String chn_id) {
		this.chn_id = chn_id;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb = sb.append("mbr_id : ").append(this.mbr_id).append("|");
		sb = sb.append("mbr_code : ").append(this.mbr_code).append("|");
		sb = sb.append("pwd : ").append(this.pwd).append("|");
		sb = sb.append("contact : ").append(this.contact).append("|");
		sb = sb.append("sav_pnt : ").append(this.sav_pnt).append("|");
		sb = sb.append("buy_pnt : ").append(this.buy_pnt).append("|");
		sb = sb.append("chn_id : ").append(this.chn_id).append("|");
		return sb.toString();
	}
	
}  