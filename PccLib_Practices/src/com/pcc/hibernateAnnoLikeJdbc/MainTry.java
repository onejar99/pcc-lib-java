package com.pcc.hibernateAnnoLikeJdbc;

import com.pcc.hibernateAnnoLikeJdbc.service.MemberService;

public class MainTry {
	public static void main(String[] args)
    {
        MemberService memberService = new MemberService();
        memberService.pirntMemberList();
    }
}
