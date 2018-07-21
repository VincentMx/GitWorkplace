package com.lix.service.impl;

import com.lix.dao.YhParkDao;
import com.lix.entity.ClXx;
import com.lix.entity.ParkCl;
import com.lix.entity.ParkSf;
import com.lix.entity.ParkXx;
import com.lix.entity.vo.CwxxVO;
import com.lix.service.YhParkService;
import com.lix.util.BeanUtils;
import com.lix.util.Page;
import com.lix.util.UuidUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author : lix
 * @desc :
 * @time : 20:302018/5/3
 * @modify by :
 */
@Component("yhParkService")
public class yhParkServiceImpl implements YhParkService {


    @Resource
    private YhParkDao yhParkDao;


    @Resource
    private JdbcTemplate jdbcTemplate;



    @Override
    public void save(ClXx clXx) {
          if(clXx.getClCph() != null && !"".equals(clXx.getClCph())){
              clXx.setSkey(UuidUtils.get32UUID());
              yhParkDao.save(clXx);
          }
    }

    @Override
    public void save(ParkXx parkXx) {

        if(parkXx != null){
            parkXx.setSkey(UuidUtils.get32UUID());
            yhParkDao.save(parkXx);
        }

    }

    @Override
    public void save(ParkCl parkCl) {

        if(parkCl != null){
            parkCl.setSkey(UuidUtils.get32UUID());
            yhParkDao.save(parkCl);
        }

    }

    @Override
    public void save(ParkSf parkSf) {
        if(parkSf != null){
            parkSf.setSkey(UuidUtils.get32UUID());
            yhParkDao.save(parkSf);
        }
    }

    @Override
    public void save(ClXx clXx, ParkCl parkCl, ParkSf parkSf) {

    }

    @Override
    public List<ClXx> findAllCl(ClXx clXx) {
        return yhParkDao.findAllCl(clXx);
    }

    @Override
    public Page findAllClxx(Page page, ClXx clXx) {
        return yhParkDao.findAllClxx(page,clXx);
    }

    @Override
    public List<ParkXx> findAllPark(ParkXx parkXx) {
        return yhParkDao.findAllPark(parkXx);
    }

    @Override
    public Page findAllParkxx(Page page, CwxxVO cwxxVO) {

        return yhParkDao.findAllParkxx(page,cwxxVO);
    }

    @Override
    public List<ParkSf> findAllParkSf(ParkSf parkSf) {
        return yhParkDao.findAllParkSf(parkSf);
    }

    @Override
    public Page findAllParkSf(Page page, ParkSf parkSf) {
        return yhParkDao.findAllParkSf(page , parkSf);
    }

    @Override
    public List<ParkCl> findAllParkCl(ParkCl parkCl) {
        return yhParkDao.findAllParkCl(parkCl);
    }

    @Override
    public Page findAllParkCl(Page page, ParkCl parkCl) {
        return yhParkDao.findAllParkCl(page , parkCl);
    }

    @Override
    public List<Map<String, Object>> findAllInfo(ClXx clXx, ParkXx parkXx, ParkSf parkSf, ParkCl parkCl) {
        return null;
    }

    @Override
    public void update(ClXx clXx) {
        if(clXx.getSkey() != null && !"".equals(clXx.getSkey())){
            ClXx clXx1 = yhParkDao.findClxxById(clXx.getSkey());
            BeanUtils.copyPropertityIgnoreNull(clXx,clXx1);
            yhParkDao.update(clXx1);
        }
    }

    @Override
    public void update(ParkXx parkXx) {
        if(parkXx.getSkey() != null && !"".equals(parkXx.getSkey())){
            ParkXx parkXx1 = yhParkDao.findParkById(parkXx.getSkey());
            BeanUtils.copyPropertityIgnoreNull(parkXx,parkXx1);
            yhParkDao.update(parkXx1);
        }
    }

    @Override
    public void update(ParkCl parkCl) {
        if(parkCl.getSkey() != null && !"".equals(parkCl.getSkey())){
            ParkCl parkCl1 = yhParkDao.findParkClById(parkCl.getSkey());
            BeanUtils.copyPropertityIgnoreNull(parkCl,parkCl1);
            yhParkDao.update(parkCl1);
        }
    }

    @Override
    public void update(ParkSf parkSf) {
        if(parkSf.getSkey() != null && !"".equals(parkSf.getSkey())){
            ParkSf parkSf1 = yhParkDao.findParkSfById(parkSf.getSkey());
            BeanUtils.copyPropertityIgnoreNull(parkSf,parkSf1);
            yhParkDao.update(parkSf1);
        }
    }

    @Override
    public void update(ClXx clXx, ParkSf parkSf, ParkCl parkCl) {

    }

    @Override
    public void delete(ClXx clXx) {
        if(clXx.getSkey() != null && !"".equals(clXx.getSkey())){
            ClXx clXx1 = yhParkDao.findClxxById(clXx.getSkey());
            BeanUtils.copyPropertityIgnoreNull(clXx,clXx1);
            yhParkDao.delete(clXx1);
        }
    }

    @Override
    public void delete(ParkXx parkXx) {
        if(parkXx.getSkey() != null && !"".equals(parkXx.getSkey())){
            ParkXx parkXx1 = yhParkDao.findParkById(parkXx.getSkey());
            BeanUtils.copyPropertityIgnoreNull(parkXx,parkXx1);
            yhParkDao.delete(parkXx1);
        }
    }

    @Override
    public void delete(ParkCl parkCl) {
        if(parkCl.getSkey() != null && !"".equals(parkCl.getSkey())){
            ParkCl parkCl1 = yhParkDao.findParkClById(parkCl.getSkey());
            BeanUtils.copyPropertityIgnoreNull(parkCl,parkCl1);
            yhParkDao.delete(parkCl1);
        }
    }

    @Override
    public void delete(ParkSf parkSf) {
        if(parkSf.getSkey() != null && !"".equals(parkSf.getSkey())){
            ParkSf parkSf1 = yhParkDao.findParkSfById(parkSf.getSkey());
            BeanUtils.copyPropertityIgnoreNull(parkSf,parkSf1);
            yhParkDao.delete(parkSf1);
        }
    }

    @Override
    public void delete(ClXx clXx, ParkSf parkSf, ParkCl parkCl) {

    }

    @Override
    public CwxxVO findCwByParam(CwxxVO cwxxVO) {
        CwxxVO cwxxVO1 = new CwxxVO();
        if(cwxxVO != null) {
          ParkXx parkXx = yhParkDao.findParkById(cwxxVO.getSkey());
          BeanUtils.copyPropertityIgnoreNull(parkXx , cwxxVO1);
        }
        return cwxxVO1;
    }

    @Override
    public ParkCl findpARKcLByParam(ParkCl parkCl) {
        ParkCl parkCl1 = new ParkCl();
        if(parkCl != null){
            parkCl1 = yhParkDao.findParkClById(parkCl.getSkey());
        }
        return parkCl1;
    }

    @Override
    public ParkSf findParkSfByParam(ParkSf parkSf) {
        ParkSf parkSf1 = new ParkSf();
        if(parkSf != null){
            parkSf1 = yhParkDao.findParkSfById(parkSf.getSkey());
        }
        return parkSf1;
    }

    @Override
    public ClXx findClxxByParam(ClXx clXx) {
        ClXx  clXx1 = new ClXx();
        if(clXx != null){
            clXx1 = yhParkDao.findClxxById(clXx.getSkey());
        }
        return clXx1;
    }
}
