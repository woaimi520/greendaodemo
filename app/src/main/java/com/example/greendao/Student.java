package com.example.greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.Generated;

@Entity //表
public class Student {
    @Id(autoincrement = true)
    private long stuID;//学院ID
    @Index(unique = true)
    private String stuNO;//学院编号
    private String stuName;//学院名称
    private String stuSex;//学院性别
    private String stuScore;//学院成绩
    @Generated(hash = 1600611962)
    public Student(long stuID, String stuNO, String stuName, String stuSex,
            String stuScore) {
        this.stuID = stuID;
        this.stuNO = stuNO;
        this.stuName = stuName;
        this.stuSex = stuSex;
        this.stuScore = stuScore;
    }
    @Generated(hash = 1556870573)
    public Student() {
    }
    public long getStuID() {
        return this.stuID;
    }
    public void setStuID(long stuID) {
        this.stuID = stuID;
    }
    public String getStuNO() {
        return this.stuNO;
    }
    public void setStuNO(String stuNO) {
        this.stuNO = stuNO;
    }
    public String getStuName() {
        return this.stuName;
    }
    public void setStuName(String stuName) {
        this.stuName = stuName;
    }
    public String getStuSex() {
        return this.stuSex;
    }
    public void setStuSex(String stuSex) {
        this.stuSex = stuSex;
    }
    public String getStuScore() {
        return this.stuScore;
    }
    public void setStuScore(String stuScore) {
        this.stuScore = stuScore;
    }


}
