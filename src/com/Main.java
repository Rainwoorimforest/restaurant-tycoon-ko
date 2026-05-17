package com;
// 같은 패키지면 다른 클래스를 import 안해도 된다.
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 메뉴 딕셔너리
        // System.out.println(MenuStore.MENU);
        // 매장 오픈 멘트와 기본 콘솔 프로그램 안내문
        System.out.println("""
                   - 테이블 당 손님 1명 이용시간은 1시간, 총 영업시간은 4시간
                   - 1. 손님이 랜덤으로 메뉴 주문
                   - 2. 사장입장에서 직원들을 부리면 됨.
                   - 3. 영업시간이 끝나면 직원들의 성과(요리 숙련도, 서비숙련도에 맞게 성과 발표)
                   - 4. 각 직원 정산. 게임 끝
                """);

        //변수
        // 하루 총 매출을 누적할 Map (메뉴명, 누적 수량)
        Map<String, Integer> todaySales = new HashMap<>();
        int totalRevenue = 0;
        int dailyLoop = 3; // 이것도 입력받기로 수정할 것
        int current = 0;

        System.out.println("====== 🏪 카페 알바 타이쿤 오픈 준비 ======");
        System.out.print("셰프의 이름을 입력하세요: ");
        String chefName = sc.nextLine();
        Chef chef = new Chef(chefName, "요리사", 5);

        System.out.print("홀 알바생의 이름을 입력하세요: ");
        String partName = sc.nextLine();
        PartTimeFloor partServer = new PartTimeFloor(partName, "Server", "아르바이트", 4);

        // Floor server = new Floor(); // 생성자 인수: String name, String job

        System.out.println("------------------------------------");
        System.out.println("엔터를 눌러 레스토랑 운영을 시작합니다.");


        // 2. 반복문을 이용하여 4시간동안 손님을 1명씩 받으며 운영합니다.
        while (current < dailyLoop) {
            sc.nextLine(); // 찌꺼기 청소..?

            System.out.println("------------------------------------");
            System.out.println("<" + current + "> 일차");
            System.out.println("😆안녕하세요, 더플레이스 입니다. 메뉴를 골라주세요.");
            System.out.println(MenuStore.MENU);
            /*
                public class MenuStore {
    public static final Map<String, Integer> MENU = Map.of(
      "부라타카프레제", 15000,
      "리코타프루타샐러드", 17000,
            "레몬파스타", 20000,
        "알리오올리오파스타", 20000,
        "모르타델라피자", 25000,
            "풍기피자", 27000,
    );
}

            */


            //2-1.  메뉴 입력받기 (메뉴명, 수량). 이때 엔터 하나 당 하나의 메뉴 입력 가능. 두번은 주문 완료. 메뉴는 배열이나 Map이나 적당한 데이터에 담는다.
            System.out.println("메뉴명을 정확히 적어주십시오. 엔터를 두번 치면 주문이 가능합니다.");
            String orderInfo = sc.nextLine();

            if(!MenuStore.MENU.containsKey(orderInfo)){
                System.out.println("❌ 매장에 없는 메뉴입니다. 손님이 그냥 돌아갑니다.");
                current++;
                continue;
            }
            System.out.print("수량을 입력하세요: ");
            int count = sc.nextInt();


            // 2-2. 사용자가 옵션을 통해 객체 메서드 호출이 달라짐.
            System.out.println("\n► 1. 서버한테 주문한 메뉴 설명 듣기");
            System.out.println("► 2. 바로 요리 조리 들어가기");
            System.out.print("선택: ");
            int option = sc.nextInt();

            if (option == 1) {
                partServer.takeOrder(orderInfo); // 매개변수로 주문 데이터 전달
            }

            // 셰프가 조리 들어감 (만들어둔 조리 메서드 호출)
            System.out.println("\n[주방 상황]");
            cookfunc(orderInfo, count);


            // 2-3. 서빙하기
            partServer.serve();

            System.out.println("(음식 식사 중...)");
            try { Thread.sleep(1000); } catch (InterruptedException e) {} // 1초 딜레이
            System.out.println("손님: 음식이 맛있네요.. 쩝쩝...");

            // 2-4. 커피 주문 여부 물어보기
            System.out.println("커피도 드시겠습니다?(y/n): ");
            String answer = sc.next();

            if(answer.equalsIgnoreCase("y")) {
                partServer.makeDrink();
                System.out.println("Server: 커피 드릴게요.");
                System.out.println("(커피 마시는 중...)");
                try { Thread.sleep(1000); } catch (InterruptedException e) {}

                // 커피 수량 누적
                todaySales.put("커피", todaySales.getOrDefault("커피", 0) + 1);
                totalRevenue += MenuStore.MENU.get("커피");
            }

            // 주문한 주메뉴 매출 누적
            todaySales.put(orderInfo, todaySales.getOrDefault(orderInfo, 0) + count);
            totalRevenue += MenuStore.MENU.get(orderInfo) * count;

            // 2-5. 결제하기
            System.out.println("손님: 결제하겠습니다!");

            System.out.println("어떤 직원에서 결제를 시킬건가요?");
            System.out.println("► 1. Chef");
            System.out.println("► 2. 아르바이트 홀직원");
            System.out.print("선택: ");
            int employeeChoice = sc.nextInt();

            // 손님이 지불할 금액 산출 (주메뉴 가격 * 수량)
            int menuPrice = MenuStore.MENU.get(orderInfo) * count;
            if (answer.equalsIgnoreCase("y")) {
                menuPrice += MenuStore.MENU.get("커피");
            }

            System.out.println("💰 결제해야 할 금액은 총 " + menuPrice + "원 입니다.");
            System.out.print("손님이 지불할 금액을 입력하세요: ");
            int paymentAmount = sc.nextInt();

            System.out.println("\n[결제 처리]");
            if (employeeChoice == 1) {
                chef.processPayment(orderInfo, paymentAmount, menuPrice);
            } else {
                partServer.processPayment(orderInfo, paymentAmount, menuPrice);
            }

            // 오늘 하루 매출 실시간 출력
            System.out.println("\n📌 [현재 누적 매출액 현황]");
            for (String menuName : todaySales.keySet()) {
                System.out.println("- " + menuName + ": " + todaySales.get(menuName) + "개");
            }
            System.out.println("총 누적 금액: " + totalRevenue + "원");

            current++;
        }

        // 4. 정산합니다.
        System.out.println("=================================================");
        System.out.println("영업 마감. 직원들을 정산해줍니다.");
        System.out.println("오늘의 최종 총 매출: " + totalRevenue + "원");

        // 노동시간을 고정 수치(예: 4시간)로 세팅 후 퇴근 메서드 호출 예시
        chef.dailyWorkingHours = 4;
        partServer.dailyWorkingHours = 4;

        chef.clockOut(chef.name);
        partServer.clockOut(partServer.name);
        System.out.println("=================================================");
    }


    public static void cookfunc(String orderInfo, int count) {
        CookMethod cookMethod;

        if (orderInfo.contains("샐러드")) {
            cookMethod = new saladCook();
        } else if (orderInfo.contains("피자")) {
            cookMethod = new pizzaCook();
        } else {
            cookMethod = new pastaCook();
        }
//        else if (orderInfo.contains("파스타")) {
//            cookMethod = new pastaCook();
//        }

        // 선택된 요리 방식을 실행
        cookMethod.cook(count);
    }
}
