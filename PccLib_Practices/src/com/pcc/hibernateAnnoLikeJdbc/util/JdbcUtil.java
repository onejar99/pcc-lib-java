package com.pcc.hibernateAnnoLikeJdbc.util;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pcc.hibernateAnnoLikeJdbc.annotation.PccColumn;
import com.pcc.utils.reflection.ReflectionUtil;

public class JdbcUtil
{
    // DB default settings
    private static final String DB_USERNAME = "root";
    private static final String DB_USER_PWD = "pc9876";
    private static final String DB_NAME = "test12345";
    
    private JdbcUtil() {}

    /**
     * 取得預設DB連線
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException
    {
        return getConnection( DB_NAME, DB_USERNAME, DB_USER_PWD );
    }

    /**
     * 建立DB連線
     * @param dbName
     * @param dbUserName
     * @param dbUserPwd
     * @return
     * @throws SQLException
     */
    private static Connection getConnection(String dbName, String dbUserName, String dbUserPwd) throws SQLException
    {
        Connection conn = null;
        
        // Register MySQL Driver
        DriverManager.registerDriver( new com.mysql.jdbc.Driver() );

        // get Connection object
        String url = "jdbc:mysql://localhost:3306/" + dbName + "?characterEncoding=utf-8";
        conn = DriverManager.getConnection( url, dbUserName, dbUserPwd );
    
        return conn;
    }

    /**
     * 執行 query SQL
     * @param sql
     * @param pojoClazz
     * @return
     * @throws SQLException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public static <T> List<T> query(String sql, Class<T> pojoClazz) throws SQLException, InstantiationException, IllegalAccessException
    {
        Connection conn = null;
        PreparedStatement preStmt = null;
        ResultSet rs = null;
        List<T> rlt = null;

        try{
	        // Connect to DB
	        conn = getConnection();
	
	        // Execute query
	        preStmt = conn.prepareStatement( sql );
	        rs = preStmt.executeQuery();
	
	        // Deal ResultSet
	        rlt = convertResultSetToPojoList( rs, pojoClazz );
        } finally {
        	if (preStmt != null) preStmt.close();
        	if (rs != null) rs.close();
        	if (conn != null) conn.close();
        }
        return rlt;
    }

    /**
     * 根據 pojo 的 PccColumn annotation，將 query 結果裝填至 pojo
     * @param rs
     * @param pojoClazz
     * @return
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws SQLException
     */
    private static <T> List<T> convertResultSetToPojoList(ResultSet rs, Class<T> pojoClazz)
            throws InstantiationException, IllegalAccessException, SQLException
    {
        List<T> rlt = new ArrayList<>();
        while (rs.next())
        {
            T obj = pojoClazz.newInstance();
            Field[] fields = pojoClazz.getDeclaredFields();

            for (Field f : fields)
            {
                PccColumn anno = f.getDeclaredAnnotation( PccColumn.class );
                if (anno != null)
                {
                    String fieldName = f.getName();
                    String colName = anno.name();
                    Object colValue = null;

                    switch (anno.datatype())
                    {
                        case INTEGER:
                            colValue = rs.getInt( colName );
                            break;
                        case STRING:
                            colValue = rs.getString( colName );
                            break;
                        case BOOLEAN:
                            colValue = rs.getBoolean( colName ); // true if not 0, even -1
                            break;
                        case DOUBLE:
                            colValue = rs.getDouble( colName );
                            break;
                        case DATE:
                            colValue = rs.getDate( colName );
                            break;
                        case TIMESTAMP:
                            colValue = rs.getTimestamp( colName );
                            break;
                        case BLOB:
                            colValue = rs.getBlob( colName );
                            break;
                        default:
                            break;
                    }
                    ReflectionUtil.invokeSetter( obj, fieldName, colValue );
                }
            }
            rlt.add( obj );
        }
        return rlt;
    }
}
