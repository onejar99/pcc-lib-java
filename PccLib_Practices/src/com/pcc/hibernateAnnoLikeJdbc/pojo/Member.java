package com.pcc.hibernateAnnoLikeJdbc.pojo;

import java.util.Date;

import com.pcc.hibernateAnnoLikeJdbc.annotation.PccColumn;
import com.pcc.hibernateAnnoLikeJdbc.enums.DatatypeEnum;

public class Member {
	@PccColumn(name = "member_id", datatype = DatatypeEnum.INTEGER)
    private Integer memberId;

	@PccColumn(name = "name", datatype = DatatypeEnum.STRING)
    private String name;

	@PccColumn(name = "age", datatype = DatatypeEnum.INTEGER)
    private Integer age;

	@PccColumn(name = "is_vip", datatype = DatatypeEnum.BOOLEAN)
    private Boolean isVip;

	@PccColumn(name = "create_time", datatype = DatatypeEnum.TIMESTAMP)
    private Date createTime;

	@PccColumn(name = "birthday", datatype = DatatypeEnum.DATE)
    private Date birthday;

	@PccColumn(name = "address", datatype = DatatypeEnum.STRING)
    private String address;

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Boolean getIsVip() {
		return isVip;
	}

	public void setIsVip(Boolean isVip) {
		this.isVip = isVip;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
