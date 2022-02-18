package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StateFulServiceTest {

    @Test
    void statefulServiceTest(){

        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

        StateFulService stateFulService1 = ac.getBean(StateFulService.class);
        StateFulService stateFulService2 = ac.getBean(StateFulService.class);

        //ThreadA : a사용자 10000원 주문
        int userA = stateFulService1.order("userA", 10000);

        //ThreadB : b사용자 20000주문
        int userB = stateFulService2.order("userA", 20000);

        //thread A:사용자 a가 주문금윽을 조회
//        int price = stateFulService1.getPrice();
        System.out.println("price = " + userB);

//        Assertions.assertThat(stateFulService1.getPrice()).isEqualTo(20000);

    }

    static  class TestConfig {

        @Bean
        public StateFulService stateFulService()    {
            return  new StateFulService();
        }
    }

}