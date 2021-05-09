/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import Model.UserModel;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author BN
 */
public class UserMapper implements IMapper<UserModel>{

    @Override
    public UserModel mapRowToObject(ResultSet rs) {
        try{
            UserModel user = new UserModel();
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setName(rs.getString("name"));
            return user;
        }catch(SQLException ex){
            return null;
        }
    }
    
}
