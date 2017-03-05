package com.fulinhua.action;

import com.fulinhua.dao.impl.MemberDaoImpl;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * Created by fulinhua on 2017/3/5.
 */
public class QualityJob extends QuartzJobBean{
    private int timeout;



    private MemberDaoImpl memberDao=new MemberDaoImpl();
    private static int i = 0;

//调度工厂实例化后，经过timeout时间开始执行调度

    public void setTimeout(int timeout) {

        this.timeout = timeout;

    }



    /**

     * 要调度的具体任务

     */




    @Override
    protected void executeInternal ( JobExecutionContext jobExecutionContext ) throws JobExecutionException {
        System.out.println("开始检查用户会员资格…");
        memberDao.CheckAllMemberQuality();
    }
}
