package com.example.greendao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.github.yuweiguocn.library.greendao.MigrationHelper;
import com.ppjun.greendaotest.db.CourseDao;
import com.ppjun.greendaotest.db.DaoMaster;
import com.ppjun.greendaotest.db.IdCardDao;
import com.ppjun.greendaotest.db.StudentDao;
import com.ppjun.greendaotest.db.TeacherDao;
import com.ppjun.greendaotest.db.TeacherJoinStudentBeanDao;

import org.greenrobot.greendao.database.Database;

public class MySQLiteOpenHelper extends DaoMaster.OpenHelper {
    public MySQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }
    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        MigrationHelper.migrate(db, new MigrationHelper.ReCreateAllTableListener() {

            @Override
            public void onCreateAllTables(Database db, boolean ifNotExists) {
                DaoMaster.createAllTables(db, ifNotExists);
            }

            @Override
            public void onDropAllTables(Database db, boolean ifExists) {
                DaoMaster.dropAllTables(db, ifExists);
            }
        }, StudentDao.class, TeacherDao.class, CourseDao.class, IdCardDao.class, TeacherJoinStudentBeanDao.class);

    }
}
