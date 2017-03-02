package com.fulinhua.bean;

/**
 * Created by fulinhua on 2017/1/11.
 */
public class tet {
    static boolean resolve(int[] A) {
        int sum=0;
for(int i=0;i<A.length;i++){
    sum+=A[i];
}
if(sum%4!=0){
    System.out.println(sum);
    return false;
}
else {
    int count=sum/4;
    int temp=0;
    int b=0;
    for(int j=0;j<A.length;j++){
        if(temp!=count&&temp<count){
            temp+=A[j];
        }
        if(temp==count){
            b=j;
            temp=0;
            break;
        }else{
            return false;
        }
    }
    int temp2=0;
    int d=0;
    for(int i=A.length-1;i>=0;i--){
        if(temp2!=count&&temp2<count){
            temp2+=A[i];
        }
        if(temp2==count){
            d=i;
            temp2=0;
            break;
        }
        else{
return false;
        }
    }
    int temp3=0;
    int c=0;

    for(int i=b+1;i<d;i++){
        if(temp3!=count&&temp3<count){
            temp3+=A[i];
        }
        if(temp3==count){
            c=i;
            break;
        }
        else{
            return false;
        }
    }

    if(b<c&&c<d){
        return true;
    }


    return false;
}
    }

    public static void main(String[] args){
       int[] A={2, 5, 1, 1, 1, 4,  7,  7};

        Boolean res = resolve(A);

        System.out.println(String.valueOf(res));
    }
}
