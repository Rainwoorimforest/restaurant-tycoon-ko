package com;

public class Chef extends Employee {
    //필드
    protected int baseSalary = 25000;
    public int bonusRate = 0;
    public String job;
    public int cookingSkillLevel;
    // public String EmploymentType;

    // 생성자
    public Chef (String name, String job, int cookingSkillLevel) {
        super(name); // 부모 클래스 생성자 호출
        this.cookingSkillLevel = cookingSkillLevel;
        this.job = job;

        System.out.println("👩🏻‍🍳: " + job + " " + name + "이고, 저의 요리 숙련도는 " + cookingSkillLevel + "입니다.");
    }

    // 메서드

    // 다음 정산하기는 인터페이스-구현체로 만들어야 할 것 같음
//    public double calculateBonusSalary(double bonusRate) {
//        return baseSalary * (1 + bonusRate);
//    }
//
//    public double calculateBonusSalary(int bonusRate) {
//        return baseSalary * (1 + (bonusRate / 100.0)); // 그냥 100으로 나눴을 때랑 다르다.
//    }

    public void processCook (CookMethod method, int cookAmount) {
        // Main에서 String orderInfo에 맞게 method를 호출하는 로직 구현해야 함.
        method.cook(cookAmount);

    }

}
