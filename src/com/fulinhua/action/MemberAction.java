package com.fulinhua.action;

import com.fulinhua.ENUM.BindType;
import com.fulinhua.bean.*;
import com.fulinhua.service.HotelService;
import com.fulinhua.service.MemberService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by fulinhua on 2017/1/6.
 */
public class MemberAction extends ActionSupport {
    private MemberService memberService;

    public MemberService getMemberService () {
        return memberService;
    }

    public void setMemberService ( MemberService memberService ) {
        this.memberService = memberService;
    }

    public BankAccount getBankAccount () {
        return bankAccount;
    }

    public double getWithDrawMoney () {
        return WithDrawMoney;
    }

    public void setWithDrawMoney ( double withDrawMoney ) {
        WithDrawMoney = withDrawMoney;
    }

    private double WithDrawMoney;

    public String MemberRegist(){
       boolean flag=memberService.Regist(member);
        if(flag=true){
            member=memberService.getRegistMember();
            return "success";
        }else{
            return "registfail";
        }
    }

    public String DoWithDraw(){
         bankAccount=member.getBankAccount();
        bankAccount.setBalance(bankAccount.getBalance()-WithDrawMoney);
        member.setBalance(member.getBalance()+WithDrawMoney);
        memberService.update(member);
        memberService.updateBankAccount(bankAccount);
        WithDrawMoney=0;
        member=memberService.Login(member);
        return "DoWithDraw";
    }



    public ReservedOrder getOrder () {
        return order;
    }

    public void setOrder ( ReservedOrder order ) {
        this.order = order;
    }

    public ReservedOrder order=new ReservedOrder();

public String submitOrder(){
    order.setHotel(hotel);
    order.setMember(member);
memberService.submitOrder(order);
    //if(type.equals(OrderType.余额不足)){
      //  return "submitFail";
    //}else {
        room.setIsReleased(0);
    room.setIsReserved(1);
        memberService.updateRoom(room);
    hotel=memberService.getHotelRoom(hotel);
        return "showRoom";
    //}
}

   public String WithDraw(){
       return "WithDraw";
   }


    public String BackToHomepage(){
        return "LoginSuccess";
    }

    public String MemberLogin(){
member=memberService.Login(member);
        if(member==null){
            member=new Member();
            return "LoginFail";
        }else{
            BankAccount account=member.getBankAccount();
            if(account==null){
                return "NotBind";
            }else{
                if(member.getIsActive()==0){
                    return "ChargeMoney";
                }else {
                    hotelList = memberService.getAllHotel();
                    return "LoginSuccess";
                }
            }
        }

    }

    public String Active(){
        bankAccount=member.getBankAccount();
        bankAccount.setBalance(bankAccount.getBalance()-WithDrawMoney);
        member.setBalance(member.getBalance()+WithDrawMoney);
        member.setIsActive(1);
        member.setActivedate(new Date());
        memberService.update(member);
        memberService.updateBankAccount(bankAccount);
        WithDrawMoney=0;
        hotelList = memberService.getAllHotel();
        member=memberService.Login(member);
        return "LoginSuccess";
    }

    public List<Hotel> getHotelList () {
        return hotelList;
    }

    public Hotel getHotel () {
        return hotel;
    }

    public String showHotelRoom(){
hotel=memberService.getHotelRoom(hotel);
        return "showRoom";
    }

    public void setHotel ( Hotel hotel ) {
        this.hotel = hotel;
    }

    private Hotel hotel=new Hotel();

    public Room getRoom () {
        return room;
    }

    public String FillOrder(){
room=memberService.getRoom(room);
        HttpServletRequest _request = ServletActionContext.getRequest();
        HttpSession _session = _request.getSession();
        _session.setAttribute("type",room.getType());
        return "FillOrder";
    }

    public void setRoom ( Room room ) {
        this.room = room;
    }

    private Room room=new Room();

    public void setHotelList ( List<Hotel> hotelList ) {
        this.hotelList = hotelList;
    }

    private List<Hotel> hotelList=new ArrayList<Hotel>();

public String BindBank(){
    bankAccount.setBankID(Long.parseLong(bankid));
    bankAccount.setPassword(bankpassword);
BindType result=memberService.Active(member,bankAccount);
    if(result==BindType.银行账户不存在或密码错误){
        BindResult=result.toString();
        return SUCCESS;
    }else{
        BindResult=result.toString();
        return SUCCESS;
    }

}

  public String ShowPersonInfo(){
      return "PersonInfo";
  }

  public String logoff(){
member.setPassword("yourpasswordislogoff");
      memberService.update(member);
      return "login";
  }


    public List<ReservedOrder> getReservedOrders () {
        return reservedOrders;
    }

    public void setReservedOrders ( List<ReservedOrder> reservedOrders ) {
        this.reservedOrders = reservedOrders;
    }

    public List<CheckInOrder> getCheckInOrders () {
        return checkInOrders;
    }

    public void setCheckInOrders ( List<CheckInOrder> checkInOrders ) {
        this.checkInOrders = checkInOrders;
    }

    private List<ReservedOrder> reservedOrders=new ArrayList<>();
private List<CheckInOrder> checkInOrders=new ArrayList<>();

    public String showBusiness(){
reservedOrders=memberService.getReservedOrder(member);
        checkInOrders=memberService.getCheckInOrder(member);
    return "showBusiness";
    }

    public void setBankAccount ( BankAccount bankAccount ) {
        this.bankAccount = bankAccount;
    }

    public Member getMember () {
        return member;
    }

    public void setMember ( Member member ) {
        this.member = member;
    }

    private BankAccount bankAccount=new BankAccount();
    private Member member=new Member();

    public String getBindResult () {
        return BindResult;
    }

    public void setBindResult ( String bindResult ) {
        BindResult = bindResult;
    }

    private String BindResult;

    public String QuitReserve(){
order=memberService.getOrderById(order);
        hotel=memberService.getHotelById(hotel);
        Date now=new Date();
        String[] date=order.getInTime().split("-");
        Date compare=new Date();
        compare.setYear(Integer.parseInt(date[0])-1900);
        compare.setMonth(Integer.parseInt(date[1])-1);
        compare.setDate(Integer.parseInt(date[2]));
        compare.setHours(1);
        room=memberService.getRoom(room);
        room.setIsReleased(1);//房间再次发布
        room.setIsReserved(0);//预定取消
        if(now.after(compare)){//超过预定时间未退房,需要扣钱
        member.setBalance(member.getBalance()-order.getPaymoney());
            hotel.setBalance(hotel.getBalance()+order.getPaymoney());
            memberService.update(member);
            hotelService.updateHotel(hotel);
            memberService.delete(order);
            memberService.updateRoom(room);

        }else{
            memberService.updateRoom(room);
            memberService.delete(order);
        }
        reservedOrders=memberService.getReservedOrder(member);
        checkInOrders=memberService.getCheckInOrder(member);
        return "showBusiness";
    }

    public HotelService getHotelService () {
        return hotelService;
    }

    public void setHotelService ( HotelService hotelService ) {
        this.hotelService = hotelService;
    }

    private HotelService hotelService;

    public String exchange(){//兑换积分
        memberService.exchangePoints(member);
        member=memberService.Login(member);//刷新member数据
        return "DoWithDraw";
    }



    public String getBankid () {
        return bankid;
    }

    public void setBankid ( String bankid ) {
        this.bankid = bankid;
    }

    private String bankid;

    public String getBankpassword () {
        return bankpassword;
    }

    public void setBankpassword ( String bankpassword ) {
        this.bankpassword = bankpassword;
    }

    private String bankpassword;

}
