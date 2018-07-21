package com.lix.dao.Impl;

import com.lix.dao.YhParkDao;
import com.lix.entity.*;
import com.lix.entity.vo.CwxxVO;
import com.lix.util.Page;
import org.apache.commons.lang.StringUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author : lix
 * @desc :停车场数据库操作类
 * @time : 23:362018/5/2
 * @modify by :
 */
@Component("yhParkDao")
public class YhParkDaoImpl implements YhParkDao {

    private Session session;
    private Transaction transaction;
    @Resource
    private SessionFactory sessionFactory;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(ClXx clXx) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        try{
            session.save(clXx);
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
    public void save(ParkXx parkXx) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        try{
            session.save(parkXx);
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
    public void save(ParkCl parkCl) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        try{
            session.save(parkCl);
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
    public void save(ParkSf parkSf) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        try{
            session.save(parkSf);
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
    public void save(ClXx clXx, ParkCl parkCl, ParkSf parkSf) {

    }

    @Override
    public List<ClXx> findAllCl(ClXx clXx) {
        List<ClXx> list = new ArrayList<ClXx>();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        String Hql = "  from ClXx ";
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
    public Page findAllClxx(Page page, ClXx clXx) {
        List<ClXx> list = new ArrayList<ClXx>();
        List<ClXx> countList = new ArrayList<ClXx>();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        String Hql = "  from ClXx where 1 = 1  ";



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
    public List<ParkXx> findAllPark(ParkXx parkXx) {
        List<ParkXx> list = new ArrayList<ParkXx>();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        String Hql = "  from ParkXx ";
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
    public Page findAllParkxx(Page page, CwxxVO cwxxVO) {
        List<ParkXx> list = new ArrayList<ParkXx>();
        List<ParkXx> countList = new ArrayList<ParkXx>();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        String Hql = "  from ParkXx where 1 = 1  ";
        if(!StringUtils.isEmpty(cwxxVO.getPaMc())){
            Hql += " and paMc like '%" + cwxxVO.getPaMc()  + "%' ";
        }

        if(!StringUtils.isEmpty(cwxxVO.getBz())){
            Hql += " and bz like '%" + cwxxVO.getBz() +  "%'  ";
        }

        if(!StringUtils.isEmpty(cwxxVO.getPaFlag())){
            Hql += " and paFlag like  '%" + cwxxVO.getPaFlag() + "%'  ";
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
    public List<ParkSf> findAllParkSf(ParkSf parkSf) {
        List<ParkSf> list = new ArrayList<ParkSf>();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        String Hql = "  from ParkSf ";
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
    public Page findAllParkSf(Page page, ParkSf parkSf) {
        List<ParkSf> list = new ArrayList<ParkSf>();
        List<ParkSf> countList = new ArrayList<ParkSf>();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        String Hql = "  from ParkSf where 1 = 1  ";



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
    public List<ParkCl> findAllParkCl(ParkCl parkCl) {
        List<ParkCl> list = new ArrayList<ParkCl>();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        String Hql = "  from ParkCl ";
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
    public Page findAllParkCl(Page page, ParkCl parkCl) {
        List<ParkCl> list = new ArrayList<ParkCl>();
        List<ParkCl> countList = new ArrayList<ParkCl>();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        String Hql = "  from ParkCl where 1 = 1  ";



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
    public List<Map<String, Object>> findAllInfo(ClXx clXx, ParkXx parkXx, ParkSf parkSf, ParkCl parkCl) {
        return null;
    }

    @Override
    public void update(ClXx clXx) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        try{
            session.update(clXx);
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
    public void update(ParkXx parkXx) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        try{
            session.update(parkXx);
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
    public void update(ParkCl parkCl) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        try{
            session.update(parkCl);
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
    public void update(ParkSf parkSf) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        try{
            session.update(parkSf);
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
    public void update(ClXx clXx, ParkSf parkSf, ParkCl parkCl) {

    }

    @Override
    public void delete(ClXx clXx) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        try{
            session.delete(clXx);
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
    public void delete(ParkXx parkXx) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        try{
            session.delete(parkXx);
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
    public void delete(ParkCl parkCl) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        try{
            session.delete(parkCl);
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
    public void delete(ParkSf parkSf) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        try{
            session.delete(parkSf);
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
    public void delete(ClXx clXx, ParkSf parkSf, ParkCl parkCl) {

    }

    @Override
    public ClXx findClxxById(String skey) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        String Hql = "   from ClXx where skey = '"+ skey +"'";
        Query query = session.createQuery(Hql);
        ClXx clXx = (ClXx) query.getSingleResult();
        transaction.commit();
        session.close();
        return clXx;
    }

    @Override
    public ParkXx findParkById(String skey) {

        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        String Hql = "   from ParkXx  where skey = '"+ skey +"'";
        Query query = session.createQuery(Hql);
        ParkXx parkXx = (ParkXx) query.getSingleResult();
        transaction.commit();
        return parkXx;
    }

    @Override
    public ParkSf findParkSfById(String skey) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        String Hql = "   from ParkSf  where skey = '"+ skey +"'";
        Query query = session.createQuery(Hql);
        ParkSf parkSf = (ParkSf) query.getSingleResult();
        transaction.commit();
        return parkSf;
    }

    @Override
    public ParkCl findParkClById(String skey) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        String Hql = "   from ParkCl  where skey = '"+ skey +"'";
        Query query = session.createQuery(Hql);
        ParkCl parkCl = (ParkCl) query.getSingleResult();
        transaction.commit();
        return parkCl;
    }
}
