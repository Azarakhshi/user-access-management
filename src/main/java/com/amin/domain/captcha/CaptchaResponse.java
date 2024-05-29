package com.amin.domain.captcha;

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
