package com.tutorialspoint.struts2.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.util.List;

public class UserAction extends ActionSupport{
private User user=new User();
private List<Book>booklist;
private UserService service;
private String message;
private Book book=new Book();
public String login() throws Exception{
	if(service.login(user)){
		
		return "success";
	}
	return "fail";
}
public UserService getService() {
	return service;
}
public void setService(UserService service) {
	this.service = service;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}

public String buy(){

	if(!service.buy()){
	ServletActionContext.getRequest().setAttribute("message", "该商品已存在购物车中");
	}else{
		ServletActionContext.getRequest().removeAttribute("message");
	}
	return "success";
}

public String logout(){
    service.logout();
    return "index";
}

public String delete(){
	service.delete(book.getId());
	return "shopcar";
}

public String regist(){
	service.regist(user);
	return "registok";
}

public List<Book> getBooklist() {
	booklist=service.getList();
	return booklist;
}
public void setBooklist(List<Book> booklist) {
	this.booklist = booklist;
}
public Book getBook() {
	return book;
}
public void setBook(Book book) {
	this.book = book;
}



}
