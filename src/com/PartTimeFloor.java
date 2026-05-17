package com;

public class PartTimeFloor extends Floor{
    //필드
    public int baseSalary = 10320; // TODO: 정규직이랑 구분지을건지
    public String EmploymentType;
    public int serviceSkillLevel;

    // 생성자
    public PartTimeFloor(String name, String job, String EmploymentType, int serviceSkillLevel) {
        super(name, job);
        this.EmploymentType = EmploymentType;
        this.serviceSkillLevel = serviceSkillLevel;

        System.out.println("💁🏼‍♀️: " + EmploymentType + " " + job + " " + name + "이고, 저의 서비스 숙련도는 " + serviceSkillLevel + "입니다.");
    }

    //메서드
    @Override
    public void processPayment(String orderInfo, int paymentAmount, int totalPrice) {
        super.processPayment(orderInfo, paymentAmount, totalPrice);
        System.out.println("💁🏼‍♀️ 홀직원, " + super.name + "입니다! 지원 서비스 만족도 잘 부탁드립니다..!!!" );
    }


}
