/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import Mapper.IMapper;

/**
 *
 * @author BN
 */
public interface ICommon<T> {
    <T> List<T> excute(String sql, IMapper<T> mapper, Object... parameters);
    Integer insert(String sql, Object... parameters);
    Boolean update(String sql, Object... parameters);
}
