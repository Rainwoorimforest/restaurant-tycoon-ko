package com;

import java.util.Scanner;

public class Employee {
    // 필드
    public String name;
    public int dailyWorkingHours = 0;

    // 생성자
    public Employee(String name) {
        this.name = name;

        System.out.println("🔹 안녕하세요, 사장님! " + name + " 출근하였습니다.");
    }

    // 메서드(기능)
    // 퇴근하기
    public int clockOut(String name) {
        System.out.println("🔹" + name + "퇴근하겠습니다. 저의 오늘 노동시간은 " + dailyWorkingHours + "입니다..");
        return dailyWorkingHours;
    }

    // TODO: 정산받기
//    public double calculateSalary(int dailyWorkingHours) {
//        // chef에서 bonusRate가 있음. 자식클래스의 값을 불러오는 것은 단방향 상속에 어긋남
//        // 그래서 인터페이스 구현해야할 것 같음.
//
//    }

    // 결제하기
    public void processPayment(String orderInfo, int paymentAmount, int totalPrice) {
        Scanner sc = new Scanner(System.in);

        int currentPaid = paymentAmount;
        while (true) {
            if (currentPaid > totalPrice) {
                int charge = currentPaid - totalPrice;
                System.out.println(charge + "원 거스름돈 드립니다. 감사합니다!");
                break;
            } else if (currentPaid == totalPrice) {
                System.out.println("결제 완료되었습니다!");
                break;
            } else {
                System.out.println("금액이 부족합니다. 돈을 더 내셔야 합니다.");
                System.out.print("▶︎ 추가로 지불할 금액을 입력하세요: ");
                int additionalMoney = sc.nextInt(); // 추가 금액 입력받기
                sc.nextLine(); // 버퍼에 /n 찌꺼기 없애기

                currentPaid += additionalMoney;
                System.out.println("현재까지 낸 금액: " + currentPaid);
            }
        }

    }
}
