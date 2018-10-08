package com.lix.dao.Impl;

import com.boyang.core.util.StringUtils;
import com.lix.dao.XtYhDspDao;
import com.lix.entity.XtYhDsp;
import com.lix.util.Page;
import com.lix.util.SysUnitUtil;
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
 * @time : 16:072018/2/24
 * @modify by :
 */

@Component("xtYhDspDao")
public class XtYhDspDaoImpl  implements XtYhDspDao{


    private Session session;
    private Transaction transaction;

    @Resource
    private SessionFactory sessionFactory;




    @Override
    public void addXtYhDspInfo(XtYhDsp xtYhDsp) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        try{
            session.save(xtYhDsp);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
        }
    }

    @Override
    public List<XtYhDsp> findAllXtYhDsp() {
        List<XtYhDsp> list  = new ArrayList<XtYhDsp>();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        String Hal = "from XtYhDsp ";
        try{
            Query query =  session.createQuery(Hal);
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
    public XtYhDsp getXtYhDspInfoByParam(XtYhDsp xtYhDsp) {
        XtYhDsp xtYhDsps = new XtYhDsp();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        String Hal = "from XtYhDsp WHERE 1 = 1 ";
        if(!StringUtils.isEmpty(xtYhDsp.getId())){
            Hal += " and id = '"+  xtYhDsp.getId()  +"'  ";
        }
        if(!StringUtils.isEmpty(xtYhDsp.getSkey())){
            Hal += " and skey = '" +  xtYhDsp.getSkey()  +"'  ";
        }

        try{
            Query query =  session.createQuery(Hal);
            xtYhDsps = (XtYhDsp) query.getSingleResult();
            transaction.commit();
            session.flush();
        }catch (Exception e){
            transaction.rollback();
        }finally {
            session.close();
        }
        return xtYhDsps;
    }


    @Override
    public String getXtYhDspById(String Id) {
        XtYhDsp xtYhDsp = new XtYhDsp();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        String Hal = "from XtYhDsp WHERE 1 = 1 ";
        if(!StringUtils.isEmpty(Id)){
            Hal += " and id = "+Id+"  ";
        }

        try{
            Query query =  session.createQuery(Hal);
            xtYhDsp = (XtYhDsp) query.getSingleResult();
            transaction.commit();
            session.flush();
        }catch (Exception e){
            transaction.rollback();
        }finally {
            session.close();
        }

        if(xtYhDsp != null){
            return "Y";
        }else{
            return null;

        }

    }

    @Override
    public void deleteXtYhDspInfoById(XtYhDsp xtYhDsp) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        try{
            session.delete(xtYhDsp);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
        }
    }

    @Override
    public Page getXtYhDspByParam(XtYhDsp xtYhDsp, Page page,String unit) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        String Hal = "from XtYhDsp where 1 = 1  ";
        if(!StringUtils.isEmpty(unit)){
            Hal += " and unit like '" + SysUnitUtil.getRightDome(unit) + "%'   ";
        }
        if(!StringUtils.isEmpty(xtYhDsp.getAddress())){
            Hal += " and address = '" + xtYhDsp.getAddress() + "'  ";
        }
        if(!StringUtils.isEmpty(xtYhDsp.getName())){
            Hal += " and name like '%" + xtYhDsp.getName() + "%'  ";
        }



        Hal += " order by regtime desc  ";
        try{
            Query query =  session.createQuery(Hal);
            page.setTotalCount(query.list().size());
            query.setMaxResults(page.getPageSize());
            query.setFirstResult(page.getStart());
            page.setData(query.list());
            transaction.commit();
//            session.flush();
        }catch (Exception e){
            transaction.rollback();
        }finally {
            session.close();
        }
        return page;
     }

    @Override
    public void updateXtYhDspInfo(XtYhDsp xtYhDsp) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        try{
            session.update(xtYhDsp);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
        }finally {
            session.close();
        }
    }
}
