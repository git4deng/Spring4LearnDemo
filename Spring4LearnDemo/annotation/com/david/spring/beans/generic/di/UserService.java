package com.david.spring.beans.generic.di;

import org.springframework.stereotype.Service;

/**
 * @描述：继承泛型的User的业务层，在其父类泛型已经管理好了依赖关系
 * @className:UserService.java
 * @作者： David
 * @日期 2019-02-17 14:27:40
 */
@Service
public class UserService extends BaseService<User>{

}
