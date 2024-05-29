package com.amin.service;

import com.amin.domain.captcha.CaptchaResponse;
import com.amin.domain.users.signin.SignInRequest;
import com.amin.domain.users.signin.SignInResponse;
import com.amin.entity.Users;
import com.amin.repository.UsersRepository;
import com.wf.captcha.SpecCaptcha;
import com.wf.captcha.base.Captcha;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Log4j2
public class UsersService {

    private final UsersRepository userRepository;

    private final RedisTemplate redisTemplate;

    public SignInResponse signIn(SignInRequest request) {
        return null;
    }

    public CaptchaResponse captcha() {
        SpecCaptcha specCaptcha = new SpecCaptcha(130, 50, 4);
        specCaptcha.setCharType(SpecCaptcha.TYPE_ONLY_NUMBER);
        try {
            specCaptcha.setFont(Captcha.FONT_7);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        String text = specCaptcha.text();
        String key = UUID.randomUUID().toString().replace("-", "");
        char[] chars = key.toCharArray();
        List<Character> pwChars = new ArrayList<>();
        for (char c : chars) {
            pwChars.add(c);
        }
        Collections.shuffle(pwChars);
        String keys = pwChars.stream()
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();

        redisTemplate.opsForValue().set("UAM" + keys, text, 120, TimeUnit.SECONDS);

        CaptchaResponse response = new CaptchaResponse();
        response = CaptchaResponse.builder().image(specCaptcha.toBase64()).hash(keys).build();
        log.info(CaptchaResponse.builder().image(specCaptcha.toBase64()).hash(keys).build().getImage());

        return response;

    }

}
