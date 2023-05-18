package com.billlog.miribojobapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing // 해당 어노테이션으로 인해 JPA Auditing(감시, 감사) 기능을 활성화 된다. ( 활성 예시 BaseTimeEntity.java @CreatedDate, @LastModifiedDate 동작 기능토록 한다.)
public class MiribojobApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiribojobApiApplication.class, args);
    }

}
