/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.UserModel;
import java.util.List;

/**
 *
 * @author BN
 */
public interface IUser extends ICommon<UserModel>{
    
    public UserModel loginAccount(String username, String password);
}
