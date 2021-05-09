/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Implement;

import DAO.IUser;
import Mapper.UserMapper;
import Model.UserModel;
import java.util.List;

/**
 *
 * @author BN
 */
public class User extends Common<UserModel> implements IUser{

    @Override
    public UserModel loginAccount(String username, String password) {
        String sql = "SELECT * FROM dbo.admin WHERE username = ? and password = ?";
        List<UserModel> result = excute(sql, new UserMapper(), username, password);
        return result.isEmpty()? null : result.get(0);
    }

}
