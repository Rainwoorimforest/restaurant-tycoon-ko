package com.kakaotech.study;

public class pastaCook implements CookMethod {
    @Override
    public void cook(int cookAmount) {

        System.out.println("🍝 파스타 " + cookAmount + "개 제조중..");
        try { Thread.sleep(2000); } catch (InterruptedException e) {}

        System.out.println("🔔 파스타 나왔습니다. 서빙해주세요.");

    }
}
