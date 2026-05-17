package com.kakaotech.study;

public class Floor extends Employee {
    //필드
    public String job = "Server";
    // public int serviceSkillLevel;

    // 생성자
    public Floor (String name, String job) {
        super(name);
        this.job = job;
        // this.serviceSkillLevel = serviceSkillLevel;

        // System.out.println("💁🏼‍♀️: " + job + " " + name + "이고, 저의 서비스 숙련도는 " + serviceSkillLevel + "입니다.");
    }

    //메서드

    //TODO: 주문받기 더 적기
    public void takeOrder(String orderInfo) {
        System.out.println("💁🏼‍♀️ [주문 설명]");
        if (orderInfo.equals("부라타카프레제")) {
            System.out.println("-> 제철 과일 위에 상큼한 부라타 치즈가 올라간 상큼한 메뉴입니다.");
        } else if (orderInfo.equals("리코타프루타샐러드")) {
            System.out.println("-> 신선한 루꼴라와 겨자상추, 리코타 치즈가 어우러진 샐러드입니다.");
        } else {
            System.out.println("-> 저희 매장의 대표 인기 메뉴입니다! 후회 없으실 거예요.");
        }
    }

    public void serve() {
        System.out.println("음식을 테이블에 서빙하였습니다. 맛있게 드세요.");
    }


    public void makeDrink() {

        System.out.println(" ☕️ 커피 만드는 중..");
        try { Thread.sleep(1000); } catch (InterruptedException e) {}

        System.out.println("커피 제조 완료!");
    }

}
