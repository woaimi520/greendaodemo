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
            stuDao.insertOrReplace(new Student(01, "001", "任宇", "男", "100"));
            stuDao.insertOrReplace(new Student(02, "002", "贺er宝", "女", "66"));
            stuDao.insertOrReplace(new Student(03, "003", "贺san宝", "女", "23"));
            stuDao.insertOrReplace(new Student(04, "004", "贺si宝", "男", "65"));
            Toast.makeText(this, "添加数据成功",Toast.LENGTH_SHORT).show();
        }
        if(v.getId()==R.id.chaxun){
            List<Student> stulist= stuDao.queryBuilder().where(StudentDao.Properties.StuSex.eq("男")).list();
            //List<Student> stulist = stuDao.queryBuilder().where(StudentDao.Properties.StuSex.eq("男")).list();
            String searchAssignInfo = "";

            for(int i=0;i<stulist.size();i++){
                Student stu = stulist.get(i);
                searchAssignInfo += "id："+"\n" + stu.getStuID() + "编号：" + stu.getStuNO()+ "姓名：" + stu.getStuName() + "性别：" + stu.getStuSex() + "成绩：" + stu.getStuScore() + "\n";

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
