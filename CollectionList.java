package java_day12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.Consumer;

public class CollectionList {
	public static void main(String[] args) {
		// 리스트(ArrayList) 의 선언
		// 1.
		ArrayList<String> students = new ArrayList<String>();
		String[] strArray = new String[4];
		
		// 2.
		ArrayList<String> students2 = new ArrayList<>();
		
		int[] intArray = new int[5];
		ArrayList<Integer> intList = new ArrayList<Integer>();
		
		// wrapper 클래스는 기본 타입의 데이터를 객체로 취급해야
		// 하는 경우 사용한다.
		// 기본 타입(Primary type) = 숫자, boolean
		int intVal = 12;
		
		// 박싱(boxing)
		// 기본 타입의 데이터(12)를 래퍼클래스의 인스턴스로 변환
		Integer num = new Integer(12); 	
		// 오토 박싱(Auto boxing)
		Integer num2 = 12;
		
		// 언박싱(Unboxing)
		// 래퍼 클래스의 인스턴스에 저장된 값을 기본 타입의 데이터로 꺼냄
		int n = num.intValue();
		// 오토 언박싱(Auto Unboxing)
		int n2 = num;
		
		System.out.println("\n============================\n");
		
		// ArrayList에 값 담기
		students.add("사오정");
		students.add("저팔계");
		students.add("삼장");
		students.add("손오공");
		
		// 제너릭<> 타입에 일치하는 데이터만 추가 가능
//		students.add(1); -> 에러
		
		System.out.println(students);
		
		System.out.println("\n=============================\n");
		
		// .size() 
		System.out.println(students.size());
		// 값을 넣지않으면 size는 0
		System.out.println(students2.size());
		System.out.println(strArray.length);
		
		// .add() 에 (인덱스 자리, 값) 끼워넣기
		students.add(1, "민우");
		System.out.println(students);
		
		// .set() 에 (인덱스 자리, 값) 바꿔넣기
		// 해당 리스트의 인덱스 값을 수정
		students.set(1, "은지");
		System.out.println(students);
		
		// .contains() 리스트 안에 해당 데이터가 존재하는지 검색
		// true/false로 반환
		System.out.println(students.contains("은지"));
		System.out.println(students.contains("민우"));
		
		// .indexOf() 리스트 안에 해당 데이터가
		// 존재한다면 인덱스 리턴, 없다면 -1 리턴
		// -1 리턴 여부로 contains 처럼 사용 가능
		System.out.println(students.indexOf("손오공"));
		System.out.println(students.indexOf("유진"));
		
		// .get() 해당 인덱스에 저장된 데이터를 리턴 
		// 리스트도 인덱스 0부터 시작
		System.out.println(students.get(3));
		
		// .isEmpty() 리스트가 비어있는지 true/false로 리턴 
		// .size() == 0 체크하는 것과 같다.
		System.out.println(students.isEmpty());
		System.out.println(students2.isEmpty());
		System.out.println(students.size() == 0);
		System.out.println(students2.size() == 0);
		
		// .remove() 해당 인덱스의 데이터를 삭제
		students.remove(1);
		System.out.println(students);
		students.remove("삼장");	 // 해당 데이터를 삭제
		System.out.println(students);
		students.remove("파이리");   // 해당 데이터가 없어도 괜찮음.
		System.out.println(students);
	
		// .clear() 해당 리스트를 비움 (size가 0이 됨) 
		students.clear();
		System.out.println(students);
		
		intVal = 10;
		students = new ArrayList<String>(); // 빈 배열로 초기화
		System.out.println(students);
		
		students.add("범석");
		students.add("가은");
		students.add("상우");
		students.add("용석");
		
		System.out.println("\n===========================\n");
		
		// for문으로 리스트 제어
		for ( int i = 0; i < students.size(); i++ ) {
			students.set(i, i + students.get(i));
		}
		System.out.println(students);
		
		System.out.println("\n============== 리스트 복사 ===============\n");
		
		// 잘못된 복사 방법
		ArrayList<String> copyList = students;
		System.out.println(copyList);
		copyList.set(0, "0유진");
		System.out.println(students);
		
		// 복사 방법 1
		ArrayList<String> copyList2 = new ArrayList<String>();
		copyList2.addAll(students);
		System.out.println(copyList2);
		copyList2.set(0, "0철현");
		System.out.println(students);
		System.out.println(copyList2);
		
		// 복사 방법 2
		ArrayList<String> copyList3 = new ArrayList<String>(students);
		System.out.println(copyList3);
		
		// 복사 방법 3
		ArrayList<String> copyList4 = new ArrayList<String>();
		for ( int i = 0; i < students.size(); i++ ) {
			copyList4.add(students.get(i));
		}
		System.out.println(copyList4);
		
		// 향상된 for문, foreach 문
		// 인덱스가 존재하는 ArrayList에서는 유용한 정도는 아님
		for ( String i : students ) {
			System.out.println(i);
		}
		
		// 홀수 번째만 copyList4에 담아야 할때
		copyList4.clear();
		int idx = 0;
		for ( String name : students ) {
			if ( idx % 2 == 1 ) {
				copyList4.add(name);
			}
			idx++;
		}
		System.out.println(copyList4);

		System.out.println("\n==========================\n");
		
		// forEach 문
		students.forEach(new Consumer<String>() {
			@Override
			public void accept(String name) {
				System.out.println(name);
			}
		});
		
		// 람다식
		students.forEach(name -> System.out.println(name));
		students.forEach(name -> {
		System.out.println(name);
		System.out.println(name);
		System.out.println(name);
		});	
		
		System.out.println("\n================ 정렬 =================\n");
		
		// 값을 주면서 리스트 선언
		intList = new ArrayList<Integer>(Arrays.asList(
				30, 15, 20, 13, 11, 40, 22));
		
		// 버블 정렬
		for ( int i = 0; i < intList.size(); i++ ) {
			boolean swapped = false;
			
			for ( int j = 0; j < intList.size() -1 - i; j++ ) {
				if ( intList.get(j) > intList.get(j+1) ) {
					int temp = intList.get(j);
					intList.set(j, intList.get(j+1));
					intList.set(j+1, temp);
					swapped = true;
				}
			}
			
			if(swapped == false) {
				System.out.println("이미 정렬 완료");
				break;
			}
			
			System.out.println(i + " 회 시행");
		}
		System.out.println(intList);
		
		intList = new ArrayList<Integer>(Arrays.asList(
				30, 15, 20, 13, 11, 40, 22));
		
		// 제공되는 메소드로 한번에 해결 가능.
		Collections.sort(intList);
		System.out.println(intList); // 오름차순
		
		Collections.sort(intList, Collections.reverseOrder());
		System.out.println(intList); // 내림차순
		
		System.out.println("\n==============================\n");
		
		ArrayList<String> strList = new ArrayList<String>(
				Arrays.asList("C", "A", "B", "c", "a"));
		
		Collections.sort(strList);
		System.out.println(strList);
		
		Collections.sort(strList, Collections.reverseOrder());
		System.out.println(strList);
		
		// 대소문자 구분 없이 정렬
		Collections.sort(strList, String.CASE_INSENSITIVE_ORDER);
		System.out.println(strList);
		
		Collections.sort(strList, Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER));
		System.out.println(strList);
		
	}
}
