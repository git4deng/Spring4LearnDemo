package com.david.spring4.helloworld.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.david.spring4.helloworld.beans.Car;
import com.david.spring4.helloworld.beans.HelloWorld;
import com.david.spring4.helloworld.beans.Person;

public class MainTest {

	public static void main(String[] args) {
			//ԭʼ����
			//��������
			HelloWorld hw=new HelloWorld();
			//���Ը���
			hw.setName("David");
			hw.hello();
			
			//spring��ʽ
			//1.����Spring��IOC����
			/*�ڴ���������ʱ��spring���ø�����޲ι������������󣬲����øö����set������ʼ������
			 * 	HelloWorld's constructor!
				HelloWorld's setter method!
				hello:DAVID
			 */
			//ApplicationContext����IOC������ClassPathXmlApplicationContext����һ��ʵ���࣬�������·�����������ļ�
			ApplicationContext ac = new ClassPathXmlApplicationContext("applicationConfig.xml");
			//2.��IOC�����л�ȡBeanʵ��
			HelloWorld bean = ac.getBean("helloWorld", HelloWorld.class);
			//HelloWorld bean = (HelloWorld) ac.getBean("helloWorld");
			bean.hello();
			//set������ʼ������
			Car car1 = ac.getBean("car1", Car.class);
			System.out.println(car1);
			//������ָ�����������ķ�ʽ��ʼ������
			Car car2 = ac.getBean("car2", Car.class);
			System.out.println(car2);
			//������ָ���������͵ķ�ʽ��ʼ������
			Car car3 = ac.getBean("car3", Car.class);
			System.out.println(car3);
			//ʹ�����Եķ�ʽ����
			//ͨ��ref������������bean
			Person person=ac.getBean("person", Person.class);
			System.out.println(person);
			//ͨ��ref��ǩ��������bean
			Person person2=ac.getBean("person2", Person.class);
			System.out.println(person2);
			//ͨ���ڲ���bean�ķ�ʽʹ������bean
			Person person3=ac.getBean("person3", Person.class);
			System.out.println(person3);
			
			//ʹ�ô��ι������ķ�ʽ����
			//�����������ⲿbean�ķ�ʽ����
			Person person4=ac.getBean("person4", Person.class);
			System.out.println(person4);
			//�����������ڲ�bean�ķ�ʽ����
			Person person5=ac.getBean("person5", Person.class);
			System.out.println(person5);
			//�������Ը�ֵ
			Person person6=ac.getBean("person6", Person.class);
			System.out.println(person6);
			
	}

}
