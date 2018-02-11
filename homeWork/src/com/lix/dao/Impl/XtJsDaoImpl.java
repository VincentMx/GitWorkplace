package com.lix.dao.Impl;

import com.lix.dao.XtjsDao;
import com.lix.entity.Xt_js;
import com.lix.entity.vo.XtJsVO;
import com.lix.util.Page;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : lix
 * @desc : 角色的daoimpl
 * @time : 22:292017/11/26
 * @modify by :
 */
@Component("xtJsDao")
public class XtJsDaoImpl implements XtjsDao {



    private Session session;
    private Transaction transaction;
    @Resource
    private SessionFactory sessionFactory;


    @Override
    public void saveJs(Xt_js xt_js) {
      session = sessionFactory.openSession();
      transaction = session.beginTransaction();
      session.save(xt_js);
      transaction.commit();
    }

    @Override
    public Page findAllJs(XtJsVO xtJsVO,Page page) {
        List<Xt_js> list = new ArrayList<Xt_js>();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        String Hql = "from Xt_js where flag = '1' ";
        String CountHql = " select count(*) from Xt_js  ";
        if (!StringUtils.isEmpty(xtJsVO.getName())){
            Hql += " and name like '%"+xtJsVO.getName()+"%' ";
        }
        if (!StringUtils.isEmpty(xtJsVO.getDesc())){
            Hql += " and desc like '%"+xtJsVO.getDesc()+"%' ";
        }
        if (!StringUtils.isEmpty(xtJsVO.getSkey())){
            Hql += " and skey = '"+xtJsVO.getSkey()+"'  ";
        }
        try {
            Query query = session.createQuery(Hql);
            Query query1 = session.createQuery(CountHql);
            query.setFirstResult(page.getStart());
            query.setMaxResults(page.getPageSize());
            list = query.list();
            page.setList(list);
            page.setTotalCount((Long)query1.uniqueResult());
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
        }
        return page;
    }

    @Override
    public void updateJs(Xt_js xt_js) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        session.update(xt_js);
        transaction.commit();
    }

    @Override
    public Xt_js findByPara(Xt_js xt_js) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        String Hql = "from lx.entity.Xt_js where flag = '1' ";
        if (!StringUtils.isEmpty(xt_js.getName())){
            Hql += " and name like '%"+xt_js.getName()+"%' ";
        }
        if (!StringUtils.isEmpty(xt_js.getDesc())){
            Hql += " and desc like '%"+xt_js.getDesc()+"%' ";
        }
        if (!StringUtils.isEmpty(xt_js.getSkey())){
            Hql += " and skey = '"+xt_js.getSkey()+"'  ";
        }
        Query query = session.createQuery(Hql);
        Xt_js xt_js1 = (Xt_js) query.getSingleResult();
        return xt_js;
    }
}
