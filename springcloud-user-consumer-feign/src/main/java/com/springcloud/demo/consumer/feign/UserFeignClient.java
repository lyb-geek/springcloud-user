package com.springcloud.demo.consumer.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springcloud.demo.consumer.entity.User;

@FeignClient("springcloud-user-provider")
public interface UserFeignClient {

	@RequestMapping(value = "/userProvider/getUserById/{id}", method = RequestMethod.GET)
	public User getUserById(@PathVariable("id") Long id);// feign不支持getMaping注解，@PathVariable（"id"）必须指定不能直接@PathVariable

	@RequestMapping(value = "/userProvider/postUser", method = RequestMethod.POST)
	public User postUser(@RequestBody User user);

}
