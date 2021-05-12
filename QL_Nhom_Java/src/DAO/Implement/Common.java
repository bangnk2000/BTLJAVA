/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Implement;

import DAO.ICommon;
import Mapper.IMapper;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BN
 * @param <T>
 */
public class Common<T> implements ICommon<T>{

        public Connection getConnection(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionUrl = "jdbc:sqlserver://localhost:1433;database=qlnhomJava;";
            String username = "sa";
            String password = "123456";
            return DriverManager.getConnection(connectionUrl, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            return null;
        }
    }
        
    @Override
    public <T> List<T> excute(String sql, IMapper<T> mapper, Object... parameters) {
        List<T> results = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            connection = getConnection();
            ps = connection.prepareStatement(sql);
            setParameters(ps,parameters);
            ps.executeUpdate();
            rs = ps.executeQuery();
            while(rs.next()){
                results.add(mapper.mapRowToObject(rs));
            }
            return results;
        }catch(SQLException e){
            return null;
        }finally{
            try{
                if(rs != null){
                    rs.close();
                }
                if(ps != null){
                    ps.close();
                }
                 if(connection != null){
                    connection.close();
                }
            }catch(SQLException ex){
                return null;
            }
        }
    }

    @Override
    public Integer insert(String sql, Object... parameters) {
       Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Integer id = null;
        try{
            connection = getConnection();
            connection.setAutoCommit(false);
            ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            setParameters(ps,parameters);
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            if(rs.next()){
                id = rs.getInt(1);
            }
            connection.commit();
            return id;
        }catch (SQLException e){
            try{
                connection.rollback();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
            return null;
        }
        finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                return null;
            }
        }
    }

    @Override
    public Boolean update(String sql, Object... parameters) {
        Connection connection = null;
        PreparedStatement ps = null;
        try{
            connection = getConnection();
            connection.setAutoCommit(false);
            ps = connection.prepareStatement(sql);
            setParameters(ps,parameters);
            ps.executeUpdate();
            connection.commit();
            return true;
        }catch (SQLException e){
            try{
                connection.rollback();
            }catch (SQLException ex){
                e.printStackTrace();
            }
            return false;
        }finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                return false;
            }
        }
    }

    private void setParameters(PreparedStatement ps, Object... parameters) {
     try{
            for(int i = 0; i< parameters.length; i++){
                Object parameter = parameters[i];
                int j = i + 1;
                if(parameter instanceof Long){
                    ps.setLong(j,(Long)parameter);
                }
                if(parameter instanceof String){
                    ps.setString(j, (String)parameter);
                }
                if(parameter instanceof Timestamp){
                    ps.setTimestamp(j, (Timestamp) parameter);
                }
                if(parameter instanceof Integer){
                    ps.setInt(j, (Integer) parameter);
                }
                if(parameter == null){
                    ps.setNull(j, Types.NULL);
                }
                if(parameter instanceof Boolean){
                    ps.setBoolean(j, (Boolean) parameter);
                }
                if(parameter instanceof Date){
                    ps.setDate(j,(Date) parameter);
                }
                if(parameter instanceof Double){
                    ps.setDouble(j,(Double) parameter);
                }
            }
        }catch (SQLException ex){
        }
    }
}
