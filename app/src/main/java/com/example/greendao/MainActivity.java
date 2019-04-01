package com.example.greendao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.ppjun.greendaotest.db.DaoMaster;
import com.ppjun.greendaotest.db.DaoSession;
import com.ppjun.greendaotest.db.StudentDao;

import org.greenrobot.greendao.query.DeleteQuery;
import org.greenrobot.greendao.query.Query;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button buttonAdd;
    Button buttonGenxin;
    Button buttonChaxun;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonAdd = findViewById(R.id.add);
        buttonAdd.setOnClickListener(this);
        buttonChaxun = findViewById(R.id.chaxun);
        buttonChaxun.setOnClickListener(this);
        buttonChaxun = findViewById(R.id.gengxin);
        buttonChaxun.setOnClickListener(this);
        getStuDao();
    }

    DaoMaster daoMaster;
    DaoSession daoSession;
    StudentDao stuDao;
    private void getStuDao(){
        //创建数据
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "hlq.db", null);
        daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        daoSession = daoMaster.newSession();
        stuDao = daoSession.getStudentDao();
    }
//dao看作表管理 session 看作一个数据库的管理 master 看作多个数据库的管理
    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.add){
            IdCard idCard1 = new IdCard();
            idCard1.setId(1l);
            idCard1.setCardId(500221198808210412l);
            daoSession.insertOrReplace(idCard1);

            Course course1 = new Course();
            course1.setId(1L);
            course1.setName("语文");
            course1.setCourseId(1l);
            daoSession.getCourseDao().insert(course1);
            Course course2 = new Course();
            course2.setId(2L);
            course2.setName("数学");
            course2.setCourseId(3l);
            daoSession.getCourseDao().insert(course2);


            Student student1 = new Student();
            student1.setStuID(1l);
            student1.setStuName("任宇");
            student1.setStuNO("01");
            student1.setStuSex("男");
            student1.setStuScore("80");
            student1.setCardId(1l);//一对一关系建立
            daoSession.insertOrReplace(student1);


            Toast.makeText(this, "添加数据成功",Toast.LENGTH_SHORT).show();
        }
        if(v.getId()==R.id.chaxun){
            List<Student> stulist= stuDao.queryBuilder().where(StudentDao.Properties.StuSex.eq("男")).list();
            //List<Student> stulist = stuDao.queryBuilder().where(StudentDao.Properties.StuSex.eq("男")).list();
            String searchAssignInfo = "";

            for(int i=0;i<stulist.size();i++){
                Student stu = stulist.get(i);
                searchAssignInfo += "id："+"\n" + stu.getStuID() + "编号：" + stu.getStuNO()+ "姓名：" + stu.getStuName() + "性别：" + stu.getStuSex() + "成绩：" + stu.getStuScore() + "\n";
                searchAssignInfo += stu.getMyCard().getCardId() + "\n";
              for(int j =0;j<stu.getCourseList().size();j++){
                searchAssignInfo += stu.getCourseList().get(j).getName()+ "\n";
                }


            }
            Toast.makeText(this, "查询成功: "+searchAssignInfo,Toast.LENGTH_SHORT).show();
        }
        if(v.getId()==R.id.gengxin){
            Student student = stuDao.queryBuilder().where(StudentDao.Properties.StuName.eq("任宇")).build().unique();
            stuDao.update(student);
            Toast.makeText(this, "更新数据成功",Toast.LENGTH_SHORT).show();
        }

    }
}
