package com.tutorialspoint.struts2.action;

import java.util.List;

public interface UserService {
public boolean login(User user);
public List<Book> getList();
public boolean buy();
public void delete(int id);
}
