package com.steven.saar.common.service.impl;

import com.github.abel533.entity.Example;
import com.github.abel533.mapper.Mapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.steven.saar.common.entity.BaseEntity;
import com.steven.saar.common.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 项目名称:com.steven.saar.common.service.impl
 * 类名称:BaseServiceImpl
 * 描述:
 * 创建人:steven
 * 创建时间:2018-05-19 22:13
 */
public class BaseServiceImpl<T extends BaseEntity, ID extends Serializable> implements BaseService<T,ID> {

    @Autowired(required = false)
    protected Mapper<T> mapper;

    /**T
     * 根据id查询数据
     *
     * @param id
     * @return
     */
    @Override
    public T queryById(Integer id) {
        return this.mapper.selectByPrimaryKey(id);
    }

    /**
     * 查询所有数据
     *
     * @return
     */
    @Override
    public List<T> queryAll() {
        return this.mapper.select(null);
    }

    /**
     * 根据条件查询一条数据，如果该条件所查询的数据为多条会抛出异常
     *
     * @param record
     * @return
     */
    @Override
    public T queryOne(T record) {
        return this.mapper.selectOne(record);
    }

    /**
     * 根据条件查询多条数据
     *
     * @param record
     * @return
     */
    @Override
    public List<T> queryListByWhere(T record) {
        return this.mapper.select(record);
    }

    /**
     * 根据条件分页查询数据
     *
     * @param record
     * @param page
     * @param rows
     * @return
     */
    @Override
    public PageInfo<T> queryPageListByWhere(T record, Integer page, Integer rows) {
        // 设置分页参数
        PageHelper.startPage(page, rows);
        List<T> list = this.mapper.select(record);
        return new PageInfo<T>(list);
    }

    @Override
    public List<T> queryListByWhere(T record, Class<T> clazz, String orderBy) {
        Example example = new Example(clazz);
        example.setOrderByClause(orderBy);
        return this.mapper.selectByExample(example);
    }

    @Override
    public PageInfo<T> queryPageListByWhere(T record, Integer page, Integer rows, Class<T> clazz,
                                            String orderBy) {
        // 设置分页参数
        PageHelper.startPage(page, rows);
        Example example = new Example(clazz);
        example.setOrderByClause(orderBy);
        List<T> list = this.mapper.selectByExample(example);
        return new PageInfo<T>(list);
    }

    /**
     * 新增数据
     *
     * @param t
     * @return
     */
    @Override
    public Integer save(T t) {
        t.setCreateTime(new Date());
        t.setModifyTime(t.getCreateTime());
        return this.mapper.insert(t);
    }

    /**
     * 选择不为null的字段作为插入数据的字段来插入数据
     *
     * @param t
     * @return
     */
    @Override
    public Integer saveSelective(T t) {
        t.setCreateTime(new Date());
        t.setModifyTime(t.getCreateTime());
        return this.mapper.insertSelective(t);
    }

    /**
     * 更新数据
     *
     * @param t
     * @return
     */
    @Override
    public Integer update(T t) {
        t.setModifyTime(new Date());
        return this.mapper.updateByPrimaryKey(t);
    }

    /**
     * 选择不为null的字段作为更新的字段来更新数据
     *
     * @param t
     * @return
     */
    @Override
    public Integer updateSelective(T t) {
        t.setModifyTime(new Date());
        t.setCreateTime(null); // 强制设置创建时间为null，永远不会被更新
        return this.mapper.updateByPrimaryKeySelective(t);
    }

    /**
     * 根据主键id删除数据（物理删除）
     *
     * @param id
     * @return
     */
    @Override
    public Integer deleteById(Integer id) {
        return this.mapper.deleteByPrimaryKey(id);
    }

    /**
     * 批量删除数据
     *
     * @param ids
     * @param clazz
     * @param property
     * @return
     */
    @Override
    public Integer deleteByIds(List<Object> ids, Class<T> clazz, String property) {
        Example example = new Example(clazz);
        // 设置条件
        example.createCriteria().andIn(property, ids);
        return this.mapper.deleteByExample(example);
    }

    /**
     * 根据条件删除数据
     *
     * @param record
     * @return
     */
    @Override
    public Integer deleteByWhere(T record) {
        return this.mapper.delete(record);
    }

    @Override
    public PageInfo<T> queryPageListByExample(Example example, Integer page, Integer rows) {
        // 设置分页参数
        PageHelper.startPage(page, rows);
        List<T> list = this.mapper.selectByExample(example);
        return new PageInfo<T>(list);
    }

    @Override
    public Integer updateSelectiveByExample(T record, Example example){
        record.setModifyTime(new Date());
        return this.mapper.updateByExampleSelective(record, example);
    }

    @Override
    public int queryCount(T record) {
        return mapper.selectCount(record);
    }

    @Override
    public int queryCountByExample(Example example) {
        return mapper.selectCountByExample(example);
    }
}
