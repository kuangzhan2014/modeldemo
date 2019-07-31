package com.maitianer.layuiadmin.modules.sys.service.Impl;

import com.maitianer.layuiadmin.modules.sys.service.EncryptService;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * @Author: zhou
 * @Date: 2019/07/19 17:18
 */
@Service
public class EncryptServiceImpl implements EncryptService {
    @Override
    public String encryptedPassword(String password) {
        Assert.hasText(password, "加密的密码不能为空！");
        return new Sha256Hash(password).toHex();
    }
}
