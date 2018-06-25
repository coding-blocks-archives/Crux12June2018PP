package L4_June19.OOPS_Story1;

public class PersonClient {

	public static void main(String[] args) throws Exception {

		Person p = new Person();
		System.out.println(p.name);
		System.out.println(p.age);

		p.name = "Amit";
		p.age = 10;
		System.out.println(p.name);
		System.out.println(p.age);

		p.introduceYourself();
		p.sayHi("Rohit");

		Person p1 = new Person("abc", 90);
		p1.setAge(-100);
		System.out.println(p1.age);
		p1.introduceYourself();
	}

}
