package com.pcc.testMaterial;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TestJsonBean
{
    private String pid;

    private String name;

    private Integer age;

    private Boolean isVip;

    private String address;

    @JsonFormat(pattern = "yyyyMMdd", timezone = "Asia/Taipei")
    private Date birthday;

    private List<String> itemList;

    private String[] skillAry;

    private Date applyDate;

    public List<String> getItemList()
    {
        return itemList;
    }

    public void setItemList(List<String> itemList)
    {
        this.itemList = itemList;
    }

    public String[] getSkillAry()
    {
        return skillAry;
    }

    public void setSkillAry(String[] skillAry)
    {
        this.skillAry = skillAry;
    }

    public Date getBirthday()
    {
        return birthday;
    }

    public void setBirthday(Date birthday)
    {
        this.birthday = birthday;
    }

    public String getPid()
    {
        return pid;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public void setPid(String pid)
    {
        this.pid = pid;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Integer getAge()
    {
        return age;
    }

    public void setAge(Integer age)
    {
        this.age = age;
    }

    public Boolean getIsVip()
    {
        return isVip;
    }

    public void setIsVip(Boolean isVip)
    {
        this.isVip = isVip;
    }

    public Date getApplyDate()
    {
        return applyDate;
    }

    public void setApplyDate(Date applyDate)
    {
        this.applyDate = applyDate;
    }
}
