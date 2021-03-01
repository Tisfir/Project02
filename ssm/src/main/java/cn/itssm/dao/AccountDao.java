package cn.itssm.dao;

import cn.itssm.domain.Account;

import java.util.List;

/**
 * @author L.N
 * @create 2021-01-07-20:02
 * 账户dao接口
 */
public interface AccountDao {
    //查询所有账户信息
    public List<Account> findAll();
    //保存账户信息
    public void saveAccount(Account account);
}

