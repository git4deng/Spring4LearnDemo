package com.david.spring.struts2.actions;

import com.david.spring.struts2.service.PersonService;

/**
 * @描述：
 * @className:PersonAction.java
 * @作者： David
 * @日期 2019-02-24 22:21:41
 */
public class PersonAction {
	private PersonService personService;
	
	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}
	public String  execute() {
		System.out.println("execute。。。");
		personService.save();
		return "success";
	}
}
