package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.List;

public class ok {

	public static void main(String[] args) {
		// TODO Auto-generated method stubdsa
		List<Integer> myList = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		boolean a=true;
		while(true) {
			System.out.println("1.элемент нэмэх");
			System.out.println("2.элемент хасах");
			System.out.println("3.бүх элементийг харах");
			System.out.println("4.эрэмбэлэх");
			System.out.println("5.хоосон эсэхийг шалгах ");
			System.out.println("6.бүх элементний нийлбэр");
			System.out.println("7.Дуусгах");
			System.out.println("----------------------------------");
			int b=sc.nextInt();
			switch(b) {
				case 1:
					addElement(myList,sc);
					break;
				case 2:
					removeElement(myList,sc);
					break;
				case 3:
					Element(myList);
					break;
				case 4:
					sortElement(myList);
					break;
				case 5:
					checkEmpty(myList);
					break;
				case 6:
					Sum(myList);
					break;
				case 7:
					System.exit(0); //23744t3ojpewefr
					System.out.println("wdni");
					break;
			}
		}
	}//3:3

public static void addElement(List<Integer> myList,Scanner sc)
{
System.out.println("Нэмэх элемент:");
int element = sc.nextInt();
myList.add(element);
}

public static void removeElement(List<Integer> myList,Scanner sc)
{
System.out.println("Хасах элэмэнт:");
int element = sc.nextInt();
if(myList.contains(element)) {
myList.remove(element);
}else {
System.out.println("Олдсонгүй");
}
}
public static void Element(List<Integer> myList)
{
System.out.println("Жагсаалтан дахь бүх элемент:"+myList);
}
public static void sortElement(List<Integer> myList) {
Collections.sort(myList);
System.out.println("Эрэмбэлэгдсэн жагсаалт:"+myList);
}
public static void checkEmpty(List<Integer> myList) {
if(myList.isEmpty())
{
System.out.println("Жагсаалт хоосон байна.");
}else {System.out.println("Жагсаалтанд:"+myList+"Эдгээр элементүүд байна.");}
}
public static void Sum(List<Integer> myList)
{
int sum=0;
for(int i = 0; i<myList.size();i++) {
sum+=myList.get(i);
}
System.out.println("Нийлбэр:"+sum);
}
}//4:09
