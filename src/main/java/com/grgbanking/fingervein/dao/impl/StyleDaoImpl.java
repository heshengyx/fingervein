package com.grgbanking.fingervein.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grgbanking.fingervein.dao.IStyleDao;
import com.grgbanking.fingervein.entity.Style;
import com.grgbanking.fingervein.mapper.IStyleMapper;
import com.grgbanking.fingervein.param.StyleQueryParam;


@Repository
public class StyleDaoImpl implements IStyleDao {

    @Autowired
    private IStyleMapper StyleMapper;
    
    @Override
    public int save(Style style) {
        return StyleMapper.save(style);
    }

    @Override
    public int saveBatch(List<Style> styles) {
        return StyleMapper.saveBatch(styles);
    }
    
    @Override
    public int update(Style style) {
        return StyleMapper.update(style);
    }

    @Override
    public int deleteById(String id) {
        return StyleMapper.deleteById(id);
    }

    @Override
    public int delete(Style style) {
        return StyleMapper.delete(style);
    }
    
    @Override
    public int deleteByIds(List<String> ids) {
        return StyleMapper.deleteByIds(ids);
    }

    @Override
    public Style getById(String id) {
        return StyleMapper.getById(id);
    }

    @Override
    public Style getData(Style style) {
        return StyleMapper.getData(style);
    }

    @Override
    public int count(StyleQueryParam param) {
        return StyleMapper.count(param);
    }

    @Override
    public List<Style> query(StyleQueryParam param, int start,
            int end) {
        return StyleMapper.query(param, start, end);
    }

    @Override
    public List<Style> queryAll(StyleQueryParam param) {
        return StyleMapper.queryAll(param);
    }
}
