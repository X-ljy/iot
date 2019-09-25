package com.ljy.iot.entity;

/**
 * @author : 夕
 * @date : 2019/9/4
 */
public class TestEntity {

//    create table stest (my_ts timestamp ,my_name binary(20) , my_age float) tags ( my_sex binary(20));
    private String my_ts;
    private String my_name;
    private float my_age;


    public String getMy_ts() {
        return my_ts;
    }

    public void setMy_ts(String my_ts) {
        this.my_ts = my_ts;
    }

    public String getMy_name() {
        return my_name;
    }

    public void setMy_name(String my_name) {
        this.my_name = my_name;
    }

    public float getMy_age() {
        return my_age;
    }

    public void setMy_age(float my_age) {
        this.my_age = my_age;
    }
}
