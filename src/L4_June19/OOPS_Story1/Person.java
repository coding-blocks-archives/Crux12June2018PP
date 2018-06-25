package L4_June19.OOPS_Story1;

public class Person {

	String name = "xyz";
	int age = 45;

	public Person() {

	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public void setAge(int age) throws Exception {

		if (age < 0) {
			throw new Exception("Invalid age.");
		}

		this.age = age;
	}

	public void introduceYourself() {
		System.out.println(this.name + " is " + this.age + " years old.");
	}

	public void sayHi(String name) {
		System.out.println(this.name + " says hi to " + name);

	}

}
