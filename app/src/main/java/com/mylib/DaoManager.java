package com.mylib;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.query.Query;

import java.util.List;

import greendao.generator.DaoSession;

/**
 * Created by Vince on 2017/1/6.
 * E_mail :  xhys01@163.com
 * Description :
 */

public class DaoManager {


    private DaoSession daoSession;
    private Query query;
    private AbstractDao Dao;

    public DaoManager(DaoSession daoSession) {
        this.daoSession = daoSession;
    }
    public DaoManager(DaoSession daoSession, Class<? extends Object> entityClass) {
        this.daoSession = daoSession;
        Dao = daoSession.getDao(entityClass);
    }

    public long insert( Object object){
        return  Dao.insert(object);
    }
    public long insert(Class<? extends Object> entityClass, Object object){
        AbstractDao TemDao = daoSession.getDao(entityClass);
        return  TemDao.insert(object);
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

    public void setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
    }

    public List getList(Class<? extends Object> entityClass) {
        return daoSession.getDao(entityClass).queryBuilder().build().list();
    }
    public List getList() {
        return Dao.queryBuilder().build().list();
    }
    public AbstractDao getDao(Class<? extends Object> entityClass){
        return daoSession.getDao(entityClass);
    }
    public AbstractDao getDao(){
        return Dao;
    }

    public void setDao( Class<? extends Object> entityClass){
        this.Dao = daoSession.getDao(entityClass);
    }
    public void setDao( AbstractDao Dao){
       this.Dao = Dao;
    }
}
