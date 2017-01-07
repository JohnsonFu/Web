package com.fulinhua.dao;

import com.fulinhua.bean.Member;

/**
 * Created by fulinhua on 2017/1/6.
 */
public interface MemberDao {
    public Member find ( String  pid);
    public void insert(Member member);
    public void update(Member member);
    public Member findByIdAndPassword(Member member);
}
