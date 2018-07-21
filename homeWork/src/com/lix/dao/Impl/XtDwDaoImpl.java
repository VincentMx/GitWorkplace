package com.lix.dao.Impl;

import cn.lix.dao.AbstractDao;
import com.lix.dao.XtDwDao;
import com.lix.entity.XtDw;
import com.lix.entity.vo.XtDwVO;
import com.lix.util.Page;
import com.lix.util.SysUnitUtil;
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
 * @time : 11:012017/12/21
 * @modify by :
 */
@Component("xtDwDao")
public class XtDwDaoImpl implements XtDwDao {

    @Resource
    private AbstractDao abstractDao;



    @Resource
    private SessionFactory sessionFactory;


    private Session session;
    private Transaction transaction;



    @Override
    public void add(Object o) {

    }

    @Override
    public void delete(Object o) {

    }

    @Override
    public void update(Object o) {

    }

    @Override
    public Object getById(String id, Object o) {
        return null;
    }

    @Override
    public List<Object> findAll(Object object) {
        return null;
    }

    @Override
    public List<Object> findAllByPara(String sql, Object object) {
        return null;
    }

    @Override
    public Page getXtDwWithPage(XtDwVO xtDwVO, Page page) {
        String Hql = "from XtDw  WHERE yxzt = '1' ";
        if(!StringUtils.isEmpty(xtDwVO.getCode())){
            Hql += " and code like '"  + SysUnitUtil.getRightDome(xtDwVO.getCode()) +  "%' ";
        }
        if(!StringUtils.isEmpty(xtDwVO.getName())){
            Hql += " and name like '%"  + xtDwVO.getName() +  "%'  ";
        }
        if(!StringUtils.isEmpty(xtDwVO.getParentkey())){
            Hql += " and parentkey  = '" + xtDwVO.getParentkey()  +  "'  ";
        }
        if(!StringUtils.isEmpty(xtDwVO.getShortname())){
            Hql += " and shortname  like '%"  + xtDwVO.getShortname()  +   "%'  ";
        }
        if(!StringUtils.isEmpty(xtDwVO.getUnitlevel())){
            Hql += " and unitlevel = '" + xtDwVO.getUnitlevel() +  "'  ";
        }

        if(!StringUtils.isEmpty(xtDwVO.getStartTime())){
            Hql += " and yxdate > '"  + xtDwVO.getStartTime()  + "'  ";
        }
        if(!StringUtils.isEmpty(xtDwVO.getEndTime())){
            Hql += " and yxdate < '"  + xtDwVO.getEndTime()  +  "'  ";
        }

        try{
           session = sessionFactory.openSession();
           transaction = session.beginTransaction();
           Query query = session.createQuery(Hql);
           page.setTotalCount(query.list().size());
           query.setFirstResult(page.getStart());
           query.setMaxResults(page.getPageSize());
           page.setData(query.list());
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
    public List<XtDwVO> getAllXtDwByPara(XtDwVO xtDwVO) {
        List<XtDwVO> list = new ArrayList<XtDwVO>();
        String Hql = "from XtDw  WHERE yxzt = '1' ";
        if(!StringUtils.isEmpty(xtDwVO.getCode())){
            Hql += " and code like '"  + SysUnitUtil.getRightDome(xtDwVO.getCode()) +  "%' ";
        }
        if(!StringUtils.isEmpty(xtDwVO.getName())){
            Hql += " and name like '%"  + xtDwVO.getName() +  "%'  ";
        }
        if(!StringUtils.isEmpty(xtDwVO.getParentkey())){
            Hql += " and parentkey  = '" + xtDwVO.getParentkey()  +  "'  ";
        }
        if(!StringUtils.isEmpty(xtDwVO.getShortname())){
            Hql += " and shortname  like '%"  + xtDwVO.getShortname()  +   "%'  ";
        }
        if(!StringUtils.isEmpty(xtDwVO.getUnitlevel())){
            Hql += " and unitlevel = '" + xtDwVO.getUnitlevel() +  "'  ";
        }

        if(!StringUtils.isEmpty(xtDwVO.getStartTime())){
            Hql += " and yxdate > '"  + xtDwVO.getStartTime()  + "'  ";
        }
        if(!StringUtils.isEmpty(xtDwVO.getEndTime())){
            Hql += " and yxdate < '"  + xtDwVO.getEndTime()  +  "'  ";
        }

        try{
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery(Hql);
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

    @Override
    public XtDw getXtDwBySkey(XtDwVO xtDwVO) {
        XtDw xtDw = new XtDw();
        String Hql = "from XtDw  WHERE yxzt = '1' ";
        if(!StringUtils.isEmpty(xtDwVO.getCode())){
            Hql += " and code like '"  + SysUnitUtil.getRightDome(xtDwVO.getCode()) +  "%' ";
        }
        if(!StringUtils.isEmpty(xtDwVO.getSkey())){
            Hql += " and skey = '"    + xtDwVO.getSkey() +  "'  ";
        }
        try{
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery(Hql);
            xtDw = (XtDw) query.getSingleResult();
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {

            session.close();
        }
        return xtDw;
    }

    @Override
    public XtDwVO getXtDwByPara(XtDwVO xtDwVO) {
        XtDwVO xtDwVO1 = new XtDwVO();
        String Hql = "from XtDw  WHERE yxzt = '1' ";
        if(!StringUtils.isEmpty(xtDwVO.getCode())){
            Hql += " and code like '"  + SysUnitUtil.getRightDome(xtDwVO.getCode()) +  "%' ";
        }
        if(!StringUtils.isEmpty(xtDwVO.getSkey())){
            Hql += " and skey = '"    + xtDwVO.getSkey() +  "'  ";
        }
        try{
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery(Hql);
            xtDwVO1 = (XtDwVO)query.getSingleResult();
            transaction.commit();
        }catch (Exception e){

            transaction.rollback();
        }finally {

            session.close();
        }
        return xtDwVO1;
    }

    @Override
    public void saveXtDw(XtDw xtDw) {

        try{
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(xtDw);
            transaction.commit();
            session.flush();
        }catch (Exception e){

            transaction.rollback();
        }finally {

            session.close();
        }

    }

    @Override
    public void updateXtDw(XtDw xtDw) {

        try{
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(xtDw);
            transaction.commit();
            session.flush();
        }catch (Exception e){

            transaction.rollback();
        }finally {

            session.close();
        }
    }

    @Override
    public void deleteXtDw(XtDw xtDw) {

        try{
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(xtDw);
            transaction.commit();
            session.flush();
        }catch (Exception e){

            transaction.rollback();
        }finally {

            session.close();
        }
    }

    @Override
    public List<XtDw> getXtDwList(String sql) {
        List<XtDw> list = new ArrayList<XtDw>();
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
