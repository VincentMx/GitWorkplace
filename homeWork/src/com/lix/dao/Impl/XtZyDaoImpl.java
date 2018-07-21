package com.lix.dao.Impl;

import com.lix.dao.XtZyDao;
import com.lix.entity.XtDw;
import com.lix.entity.XtZy;
import com.lix.entity.vo.XtZyVO;
import com.lix.util.Page;
import org.apache.commons.lang.StringUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : lix
 * @desc :
 * @time : 13:552017/11/27
 * @modify by :
 */
@Component("xtZyDao")
public class XtZyDaoImpl implements XtZyDao {

    private Session session;
    private Transaction transaction;
    @Resource
    private SessionFactory sessionFactory;

    @Override
    public void saveXtZy(XtZy xt_zy) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        try{
            session.save(xt_zy);
            transaction.commit();
            //session.flush();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
        }

    }

    @Override
    public List<XtZy> findAllXtZy(XtZy xt_zy) {
        List<XtZy> list = new ArrayList<XtZy>();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        String Hql = "  from XtZy ";
        try{
            Query query = session.createQuery(Hql);
            list = query.list();
            session.flush();
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }

        return list;
    }

    @Override
    public void updateXtZy(XtZy xt_zy) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        session.update(xt_zy);
        transaction.commit();
    }

    @Override
    public XtZy findById(XtZy xt_zy) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        String Hql = "   from XtZy where skey = '"+xt_zy.getSkey()+"'";
        Query query = session.createQuery(Hql);
        XtZy xt_zy1 = (XtZy) query.getSingleResult();
        transaction.commit();
        return xt_zy1;
    }

    @Override
    public List<XtZy> findByUserKey(String userKey) {
        List<XtZy> list = new ArrayList<XtZy>();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        try{
            String Hql = "from XtZy a";
            Hql += " left join Xt_zy_yh b on a.skey = b.resoucekey  ";
            Hql += " left join XtYhJs c on b.role_key = c.rolekey ";
            Hql += " where c.userkey =  "+userKey+"";
            Hql += " order by a.seq  ";
            Query query = session.createQuery(Hql);
            list = query.list();
            transaction.commit();
            session.flush();
        }catch (Exception e){
            transaction.rollback();
        }finally {
            session.close();
        }
        return list;
    }

    @Override
    public void deleteXtZyInfo(XtZy xtZy) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        try{
            session.delete(xtZy);
            transaction.commit();
            session.flush();
        }catch (Exception e){
            transaction.rollback();
        }finally {
            session.close();
        }
    }

    @Override
    public Page findXtZyByParam(Page page, XtZyVO xtZyVO) {
        List<XtZy> list = new ArrayList<XtZy>();
        List<XtZy> countList = new ArrayList<XtZy>();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        String Hql = "  from XtZy where 1 = 1  ";
        if(!StringUtils.isEmpty(xtZyVO.getParentkey())){
            Hql += " and parentkey = "+ xtZyVO.getParentkey() +" ";
        }
        if(!StringUtils.isEmpty(xtZyVO.getName())){
            Hql += " and name like '%"+ xtZyVO.getName()+"%'  ";
        }if(!StringUtils.isEmpty(xtZyVO.getFile1())){
            Hql += " and file1 like '%"+ xtZyVO.getFile1() +"%' ";
        }if(!StringUtils.isEmpty(xtZyVO.getIcon())){
            Hql += " and icon like '%"+ xtZyVO.getIcon() +"%' ";
        }if(!StringUtils.isEmpty(xtZyVO.getUrl())){
            Hql += " and url like '%"+ xtZyVO.getUrl() +"%' ";
        }


        try{
            Query query = session.createQuery(Hql);
            countList = query.list();
            query.setFirstResult(page.getStart());
            query.setMaxResults(page.getPageSize());
            list = query.list();
            page.setList(list);
            page.setTotalCount(countList.size());
//            session.flush();
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }

        return page;
    }

    @Override
    public List<XtZy> getXtZyList(String sql) {
        List<XtZy> list = new ArrayList<XtZy>();
        try{
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery(sql);
            list = query.list();
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {

            session.close();
        }
        return list;

    }
}
