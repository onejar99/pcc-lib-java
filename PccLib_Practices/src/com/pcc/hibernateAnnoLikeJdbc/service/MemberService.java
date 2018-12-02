package com.pcc.hibernateAnnoLikeJdbc.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.pcc.hibernateAnnoLikeJdbc.dao.MemberDAO;
import com.pcc.hibernateAnnoLikeJdbc.daoImpl.MemberDAOImplJdbc;
import com.pcc.hibernateAnnoLikeJdbc.pojo.Member;
import com.pcc.utils.reflection.ReflectionUtil;

public class MemberService
{
	private static Log logger = LogFactory.getLog(MemberService.class);
	
    private MemberDAO memberDAO;

    public MemberService()
    {
        memberDAO = new MemberDAOImplJdbc();
    }

    public void pirntMemberList()
    {
        List<Member> list;
		try {
			list = memberDAO.getList();
			for (Member m : list)
	        {
	            logger.info(ReflectionUtil.getBeanFieldInfo( m ));
	        }
		} catch (Exception e) {
			logger.error("Exception for printing member list", e);
		}
    }
}
