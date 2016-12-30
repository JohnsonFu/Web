package com.tutorialspoint.struts2.action;

import com.opensymphony.xwork2.ActionContext;
import com.tutorialspoint.struts2.dao.BaseDao;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
private BaseDao dao;
	public boolean login(User user) {
		// TODO Auto-generated method stub
		if(dao.IsExist(user)){
			ActionContext.getContext().getSession().put("user", user);
			ActionContext.getContext().getSession().put("shopcar",new ArrayList<Book>());
			Map counter=ActionContext.getContext().getApplication();
			Integer tmp=(Integer)counter.get("onlinecount");
			ArrayList<String> users=(ArrayList<String>)counter.get("users");
			if(users==null){
				users=new ArrayList<String>();
				users.add(user.getUsername()+ServletActionContext.getRequest().getSession().getId());
				counter.put("users", users);
			}else{
				String username=user.getUsername();
				for(String s:users){
					if(s.equals(username)){
						ServletActionContext.getRequest().setAttribute("haslogin", "该账号已经登陆!");
						return false;
					}
				}
				ServletActionContext.getRequest().removeAttribute("haslogin");
				ServletActionContext.getRequest().getSession().removeAttribute("msg");
				users.add(user.getUsername()+ServletActionContext.getRequest().getSession().getId());
				counter.put("users", users);
			}
			if(tmp==null){
				int count=1;
		counter.put("onlinecount", 1);
			}else{
				counter.put("onlinecount", tmp+1);
			}
			return true;
		}else{
		return false;
		}
	}
	public BaseDao getDao() {
		return dao;
	}
	public void setDao(BaseDao dao) {
		this.dao = dao;
	}
	@Override
	public List<Book> getList() {
		// TODO Auto-generated method stub
		List<Book> lists=new ArrayList<Book>();
		try {
			 lists=dao.getBooks();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lists;
	}
	
	public double getAllMoney(ArrayList<Book> list){
		double result=0;
		for(Book book:list){
			result+=book.getPrice();
		}
		return result;
	}
	
	@Override
	public boolean buy() {
		// TODO Auto-generated method stub
		ArrayList<Book> shoplist=(ArrayList)ActionContext.getContext().getSession().get("shopcar");
		String id=ServletActionContext.getRequest().getParameter("book.id");
		String name=ServletActionContext.getRequest().getParameter("book.name");
		String author=ServletActionContext.getRequest().getParameter("book.author");
		Double price=Double.parseDouble(ServletActionContext.getRequest().getParameter("book.price"));
		
		boolean hasput=false;
		for(int i=0;i<shoplist.size();i++){
			String bookname=shoplist.get(i).getName();
			if(bookname.equals(name)){
				hasput=true;
				break;
			}
		}
		if(!hasput){
			Book temp=new Book();
			temp.setName(name);
			temp.setAuthor(author);
			temp.setPrice(price);
			temp.setId(Integer.parseInt(id));
		shoplist.add(temp);
		}
		ActionContext.getContext().getSession().put("totalmoney", this.getAllMoney(shoplist));
		ActionContext.getContext().getSession().put("shopcar", shoplist);
		return !hasput;
	}
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		ArrayList<Book> shoplist=(ArrayList)ActionContext.getContext().getSession().get("shopcar");
		for(int i=0;i<shoplist.size();i++){
			Integer bookid=shoplist.get(i).getId();
			if(bookid.equals(id)){
				shoplist.remove(i);
				break;
			}
		}
		ActionContext.getContext().getSession().put("shopcar", shoplist);
		ActionContext.getContext().getSession().put("totalmoney", this.getAllMoney(shoplist));
	}

	@Override
	public void regist ( User user ) {
		try {
			dao.add(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void logout () {
		HttpSession se=ServletActionContext.getRequest().getSession();
		Map counter=ActionContext.getContext().getApplication();
		User user=(User)se.getAttribute("user");
		String key=user.getUsername()+se.getId();
		ArrayList<String> users=(ArrayList<String>)counter.get("users");
		counter.put("onlinecount", (Integer)counter.get("onlinecount")-1);
	//	users.remove(key);

		for(int i=0;i<users.size();i++){
			String s=users.get(i);
			if(s.equals(key)){
				users.remove(i);
				break;
			}
		}

		counter.put("users", users);
		se.invalidate();
	}

}
