package com.example.greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.Generated;
/**
 * 此类定义了 表的名字 以及每行的数据
 * 一对一： UserBean 中定义  private Long otherUserInfoId;  @ToOne(joinProperty = "otherUserInfoId")  private OtherUserInfoBean otherUserInfoBean;
 *         Long otherUserInfoId = (long) (Math.random() * 1000)
 *         user.setOtherUserInfoId(otherUserInfoId); //控制变量otherUserInfoId的值
 *         otherUserInfoBean.setId(otherUserInfoId);//控制自己的id就行
 *
 * 一对多    一中 定义 @ToMany(referencedJoinProperty = "leaderId")      private List<MemberBean> memberBeanList;
 *           多中定义  private Long leaderId;
 *           多中绑定 memberBean.setLeaderId
 * 多对多    studengt定义   @ToMany
 *  *                    @JoinEntity(entity = TeacherJoinStudentBean.class,
 *  *                    sourceProperty = "sId",//对应定义类的id
 *  *                    targetProperty = "tId")//对应另外类的id
 *            menber定义   @ToMany
 *  *                    @JoinEntity(entity = TeacherJoinStudentBean.class,
 *  *                    sourceProperty = "tId",//对应定义类的id
 *  *                    targetProperty = "sId")//对应另外类的id
 *
 *                     中间类定义   TeacherJoinStudentBean teacherJoinStudentBean3 = new TeacherJoinStudentBean(null,2l,1l);
 */
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
