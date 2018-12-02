package com.pcc.hibernateAnnoLikeJdbc.daoImpl;

import java.sql.SQLException;
import java.util.List;

import com.pcc.hibernateAnnoLikeJdbc.dao.MemberDAO;
import com.pcc.hibernateAnnoLikeJdbc.pojo.Member;
import com.pcc.hibernateAnnoLikeJdbc.util.JdbcUtil;

public class MemberDAOImplJdbc implements MemberDAO
{
	@Override
    public List<Member> getList() throws InstantiationException, IllegalAccessException, SQLException
    {
        String sql = "SELECT * FROM MEMBER;";
        return JdbcUtil.query( sql, Member.class );
    }
	
    @Override
    public int insertRow(Member m)
    {
    	// TODO
        return 0;
    }

    @Override
    public boolean deleteRow(Member m)
    {
        // TODO
        return false;
    }

    @Override
    public boolean updateRow(Member m)
    {
        // TODO
        return false;
    }
}
