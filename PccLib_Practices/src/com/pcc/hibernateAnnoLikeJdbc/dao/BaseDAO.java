package com.pcc.hibernateAnnoLikeJdbc.dao;

import java.sql.SQLException;
import java.util.List;

public interface BaseDAO <T> 
{
    public int insertRow(T t);
    public boolean deleteRow(T t);
    public boolean updateRow(T t);
    public List<T> getList() throws InstantiationException, IllegalAccessException, SQLException;
}
