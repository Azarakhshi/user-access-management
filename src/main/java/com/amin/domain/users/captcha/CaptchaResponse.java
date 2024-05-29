package com.amin.domain.users.captcha;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CaptchaResponse {

    private String hash;

    private String image;

}
