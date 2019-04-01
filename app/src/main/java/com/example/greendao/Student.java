package com.example.greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.JoinEntity;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.DaoException;
import com.ppjun.greendaotest.db.DaoSession;
import com.ppjun.greendaotest.db.IdCardDao;
import com.ppjun.greendaotest.db.StudentDao;

import java.util.List;
import com.ppjun.greendaotest.db.CourseDao;
import com.ppjun.greendaotest.db.TeacherDao;

/**
 * 此类定义了 表的名字 以及每行的数据
 * 以下为表中一行和别的表中一行或多行的关系
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

    private String stuNO;//学院编号
    private String stuName;//学院名称
    private String stuSex;//学院性别
    private String stuScore;//学院成绩

    private Long cardId;
    @ToOne(joinProperty = "cardId") //对上面变量的秒速 它的值对应下面的 主键id
    private IdCard myCard;//这个属性怎么体现在表里的那


    @ToMany(referencedJoinProperty = "courseId")
    private List<Course> courseList;
    @ToMany
    @JoinEntity(entity = TeacherJoinStudentBean.class,
                             sourceProperty = "sId",//对应定义类的id
                            targetProperty = "tId")//对应另外类的id
    private List<Teacher> teacherBeanList;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 1943931642)
    private transient StudentDao myDao;
    @Generated(hash = 938448590)
    public Student(long stuID, String stuNO, String stuName, String stuSex, String stuScore, Long cardId) {
        this.stuID = stuID;
        this.stuNO = stuNO;
        this.stuName = stuName;
        this.stuSex = stuSex;
        this.stuScore = stuScore;
        this.cardId = cardId;
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
    public Long getCardId() {
        return this.cardId;
    }
    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }
    @Generated(hash = 1413666094)
    private transient Long myCard__resolvedKey;
    /** To-one relationship, resolved on first access. */
    @Generated(hash = 380151869)
    public IdCard getMyCard() {
        Long __key = this.cardId;
        if (myCard__resolvedKey == null || !myCard__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            IdCardDao targetDao = daoSession.getIdCardDao();
            IdCard myCardNew = targetDao.load(__key);
            synchronized (this) {
                myCard = myCardNew;
                myCard__resolvedKey = __key;
            }
        }
        return myCard;
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1058970061)
    public void setMyCard(IdCard myCard) {
        synchronized (this) {
            this.myCard = myCard;
            cardId = myCard == null ? null : myCard.getId();
            myCard__resolvedKey = cardId;
        }
    }
    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1280401145)
    public List<Course> getCourseList() {
        if (courseList == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            CourseDao targetDao = daoSession.getCourseDao();
            List<Course> courseListNew = targetDao._queryStudent_CourseList(stuID);
            synchronized (this) {
                if (courseList == null) {
                    courseList = courseListNew;
                }
            }
        }
        return courseList;
    }
    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 829241409)
    public synchronized void resetCourseList() {
        courseList = null;
    }
    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1491194462)
    public List<Teacher> getTeacherBeanList() {
        if (teacherBeanList == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            TeacherDao targetDao = daoSession.getTeacherDao();
            List<Teacher> teacherBeanListNew = targetDao._queryStudent_TeacherBeanList(stuID);
            synchronized (this) {
                if (teacherBeanList == null) {
                    teacherBeanList = teacherBeanListNew;
                }
            }
        }
        return teacherBeanList;
    }
    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 832141143)
    public synchronized void resetTeacherBeanList() {
        teacherBeanList = null;
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1701634981)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getStudentDao() : null;
    }


    @Override
    public String toString() {
        return "Student{" +
                "stuNO='" + stuNO + '\'' +
                ", stuName='" + stuName + '\'' +
                ", stuSex='" + stuSex + '\'' +
                ", stuScore='" + stuScore + '\'' +
                ", cardId=" + cardId +
                ", myCard=" + myCard +
                '}';
    }
}
