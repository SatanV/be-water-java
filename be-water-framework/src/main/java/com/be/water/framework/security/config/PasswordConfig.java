package com.be.water.framework.security.config;

import com.be.water.framework.security.crypto.Sm3PasswordEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 加密配置
 *
 * @author 阿沐 babamu@126.com
 * <a href="https://be-water.net">MAKU</a>
 */
@Configuration
public class PasswordConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        // 使用国密SM3加密
        return new Sm3PasswordEncoder();

        // return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}