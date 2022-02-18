package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class RateDiscountPolicyTest {

    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

        @Test
        @DisplayName("VIP는 10%할인이 들어가야한다.")
        void vip_o(){
            //given
            Member memberVIP = new Member(1L, "memberVIP", Grade.VIP);
            //when
            int discount = rateDiscountPolicy.discount(memberVIP, 10000);
            //then
            Assertions.assertThat(discount).isEqualTo(1000);
        }

        @Test
        @DisplayName("만약 VIP가 아니라면?")
        void vip_x(){
            Member memberBasic = new Member(2L, "memberBasic", Grade.BASIC);
            int discount = rateDiscountPolicy.discount(memberBasic, 10000);
            Assertions.assertThat(discount).isEqualTo(0);
        }
    }
