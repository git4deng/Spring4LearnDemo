package com.david.spring4.helloworld.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.david.spring4.helloworld.beans.Car;
import com.david.spring4.helloworld.beans.HelloWorld;
import com.david.spring4.helloworld.beans.Person;

public class MainTest {

	public static void main(String[] args) {
			//原始方法
			//创建对象
			HelloWorld hw=new HelloWorld();
			//属性复制
			hw.setName("David");
			hw.hello();
			
			//spring方式
			//1.创建Spring的IOC容器
			/*在创建容器的时候，spring调用该类的无参构造器创建对象，并调用该对象的set方法初始化属性
			 * 	HelloWorld's constructor!
				HelloWorld's setter method!
				hello:DAVID
			 */
			//ApplicationContext就是IOC容器，ClassPathXmlApplicationContext是其一个实现类，该类从类路径加载配置文件
			ApplicationContext ac = new ClassPathXmlApplicationContext("applicationConfig.xml");
			//2.从IOC容器中获取Bean实例
			HelloWorld bean = ac.getBean("helloWorld", HelloWorld.class);
			//HelloWorld bean = (HelloWorld) ac.getBean("helloWorld");
			bean.hello();
			//set方法初始化属性
			Car car1 = ac.getBean("car1", Car.class);
			System.out.println(car1);
			//构造器指定属性索引的方式初始化属性
			Car car2 = ac.getBean("car2", Car.class);
			System.out.println(car2);
			//构造器指定属性类型的方式初始化属性
			Car car3 = ac.getBean("car3", Car.class);
			System.out.println(car3);
			//使用属性的方式引用
			//通过ref属性引用其它bean
			Person person=ac.getBean("person", Person.class);
			System.out.println(person);
			//通过ref标签引用其它bean
			Person person2=ac.getBean("person2", Person.class);
			System.out.println(person2);
			//通过内部用bean的方式使用其它bean
			Person person3=ac.getBean("person3", Person.class);
			System.out.println(person3);
			
			//使用带参构造器的方式引用
			//构造器引用外部bean的方式引用
			Person person4=ac.getBean("person4", Person.class);
			System.out.println(person4);
			//构造器引用内部bean的方式引用
			Person person5=ac.getBean("person5", Person.class);
			System.out.println(person5);
			//级联属性赋值
			Person person6=ac.getBean("person6", Person.class);
			System.out.println(person6);
			
	}

}
