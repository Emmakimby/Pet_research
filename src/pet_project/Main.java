package pet_project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		Man_InfoDao Mdao = new Man_InfoDao();
		Pet_InfoDao Pdao = new Pet_InfoDao();
		Pet_TypeDao Tdao = new Pet_TypeDao();
		ResultDao Rdao = new ResultDao();

		Man_InfoVo Mvo = new Man_InfoVo();
		Pet_InfoVo Pvo = new Pet_InfoVo();
		Pet_TypeVo Tvo = new Pet_TypeVo();

		while (true) {
			ArrayList<String> Meunlist = new ArrayList<>();
			Meunlist.add("================================\n\n메뉴를 선택하세요.\n");
			Meunlist.add("1. 설문조사 진행하기");
			Meunlist.add("2. 설문조사 결과지 확인하기");
			Meunlist.add("0. 설문 종료\n");

			for (int i = 0; i < Meunlist.size(); i++) {// 리스트 보여주기
				System.out.println(Meunlist.get(i) + " ");
			}

			System.out.print("입력 : ");
			int S = in.nextInt();
			in.nextLine();

			if (S == 1) {
				// 설문조사 시작
				System.out.println("\n설문조사를 진행하겠습니다.\n");
				Mvo = new Man_InfoVo();
				System.out.println("1. 본인의 나이는 몇 살입니까?\n<숫자로 입력해주세요.>");
				System.out.print("\n나이 : ");
				int age = in.nextInt();
				in.nextLine();
				Mvo.setAge(age);

				System.out.println("\n2. 가구 인원(본인 포함) 수는 어떻게 되시나요?\n<숫자로 입력해주세요.>\n");
				System.out.println("1. 1인 가구 \n2. 2인 가구 \n3. 3인 가구 \n4. 4인 가구 \n5. 5인 가구 이상");
				System.out.print("\n선택 : ");
				int M = in.nextInt();
				in.nextLine();
				System.out.println("");
				Mvo.setHouse(M);

				System.out.println("3. 현재 반려동물을 키우고 계시나요?\n<대문자 Y 또는 N으로 입력하시오.>\n");
				System.out.println("Y. 네 키우고 있습니다.\nN. 아니요, 현재 키우고 있지 않습니다.");
				System.out.print("\n선택 : ");
				System.out.print("");
				String Y = in.nextLine();
				Mvo.setPet(Y);

				// 반려동물을 키우고 있는 상황
				if (Y.equals("Y")) {
					String newType = "";
					int u = 1; // 다른 반려동물도 키우고 있는 상황
					System.out.println("\n4. 현재 키우고 있는 반려동물의 종은 어떻게 되십니까?\n");

					List<Pet_TypeVo> list = Tdao.selsctAll();
					for (Pet_TypeVo i : list) {
						System.out.println(i);
					}
					System.out.println("0. 기타");

					System.out.print("\n선택 : ");

					int n = in.nextInt();
					in.nextLine();

					if (n == 0) {
						System.out.print("\n현재 키우고 있는 반려동물의 종을 입력해주세요.\n\n입력 란 : ");
						newType = in.nextLine();
						Tvo.setType(newType);
						Tdao.insertPet_Type(Tvo);
						Pvo.setTypeNo(Tdao.searchNumber(Tvo));
					} else {
						Pvo.setTypeNo(n);
					}
					System.out.println("\n5. 반려동물의 이름을 입력해주세요.\n");
					System.out.print("이름 : ");
					String name = in.nextLine();
					Pvo.setName(name);

					System.out.println("\n6. 반려동물의 나이를 입력해주세요.\n<숫자로만 입력해주세요.>\n");
					System.out.print("나이 : ");
					int Petage = in.nextInt();
					Pvo.setPetAge(Petage);
					Mdao.insertMan_Info(Mvo);
					Pdao.insertPet_Info(Mdao.searchNumber(Mvo), Pvo);

					// 다른 종의 반려동물을 키우는 상황
					while (u == 1) {
						System.out.println("\n4-1. 현재 키우고 있는 다른 반려동물이 존재 합니까?\n\n<숫자로만 입력해주세요.>\n");
						System.out.print("1. 네 존재합니다.\n2. 아니요. 존재하지 않습니다.\n\n선택 : ");
						u = in.nextInt();
						in.nextLine();

						// 반려동물을 키우지 않을 때 종료
						if (u == 2) {
							System.out.println("\n설문조사가 완료되었습니다.\n참여해주셔서 감사합니다.");
							break;
						} else if (u == 1) {
							System.out.println("\n4. 키우고 있는 반려동물의 종은 어떻게 되십니까?\n\n<숫자로만 입력해주세요.>\n");

							for (Pet_TypeVo i : list) {
								System.out.println(i);
							}
							System.out.println("0. 기타");

							System.out.print("\n선택 : ");
							int x = in.nextInt(); // 두번 째 반려동물의 종은 x로 받음
							in.nextLine();

							if (x == 0) {
								System.out.print("\n현재 키우고 있는 반려동물의 종을 입력해주세요.\n입력 란 : ");
								newType = in.nextLine();
								Tvo.setType(newType);
								Tdao.insertPet_Type(Tvo);
								Pvo.setTypeNo(Tdao.searchNumber(Tvo));
							} else {
								Pvo.setTypeNo(x);
							}
							System.out.println("\n5. 반려동물의 이름을 입력해주세요.\n");
							System.out.print("이름 : ");
							String name1 = in.nextLine();
							Pvo.setName(name1);

							System.out.println("\n6. 반려동물의 나이를 입력해주세요.\n<숫자로만 입력해주세요.>\n");
							System.out.print("나이 : ");
							int Petage1 = in.nextInt();
							Pvo.setPetAge(Petage1);

							// 반려동물 정보
							Pdao.insertPet_Info(Mdao.searchNumber(Mvo), Pvo);
						}
					}
				} else if (Y.equals("N")){// 반려동물을 키우지 않을 때, 종료
					Mdao.insertMan_Info(Mvo);
					System.out.println("\n해당 설문조사의 대상이 아닙니다.\n참여해주셔서 감사합니다.");

				}
			} else if (S == 2) {
				System.out.println("=====================\n응답자 중 반려동물을 키우고 있는 비율\n\n전체 인원: " + Rdao.selsctmAll()
						+ "\n반려인 인원 : " + Rdao.selsctmYAll() + "\n반려인이 아닌 인원 : " + Rdao.selsctmNAll());
				float Z = Rdao.selsctmYAll();
				float X = Rdao.selsctmAll();
				System.out.print("반려인의 비율 : ");
				System.out.format("%.1f%%%n", Z / X * 100);
				System.out.println("=====================\n\n");

				System.out.println("=====================\n가구원수에 따른 반려동물 유무(반려가구의 비율)\n");
				System.out.print("1. 1인 가구 -------- ");
				System.out.format("%.1f%%%n", Rdao.selsctAll1() / X * 100);
				System.out.print("2. 2인 가구 -------- ");
				System.out.format("%.1f%%%n", Rdao.selsctAll2() / X * 100);
				System.out.print("3. 3인 가구 -------- ");
				System.out.format("%.1f%%%n", Rdao.selsctAll3() / X * 100);
				System.out.print("4. 4인 가구 -------- ");
				System.out.format("%.1f%%%n", Rdao.selsctAll4() / X * 100);
				System.out.print("5. 5인 가구이상 ----- ");
				System.out.format("%.1f%%%n", Rdao.selsctAll5() / X * 100);
				System.out.println("=====================\n\n");

				System.out.println("=====================\n키우는 반려동물의 종류\n");
				List<ResultVo> list = Rdao.TypeAll();
				for (ResultVo i : list) {
					System.out.print("\n" + i);
				}
				System.out.println("\n=====================\n\n");

				System.out.println("=====================\n반려동물의 종별 평균 나이\n");
				List<ResultavgVo> listage = Rdao.Typeavg();
				for (ResultavgVo i : listage) {
					System.out.print("\n" + i);
				}
				System.out.println("\n=====================\n\n");

			}
			else if (S == 0) {
				System.out.println("\n설문 프로그램을 종료합니다.");
				break;
			}
		}
	}
}
