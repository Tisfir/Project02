package cn.itssm.service.impl;

import cn.itssm.domain.Account;
import cn.itssm.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author L.N
 * @create 2021-01-07-20:09
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    public List<Account> findAll() {
        System.out.println("业务层，查询所有账户信息……");
        return null;
    }

    public void saveAccount(Account account) {
        System.out.println("业务层，保存账户……");

    }
}
