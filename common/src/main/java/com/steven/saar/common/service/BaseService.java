package com.steven.saar.common.service;

import com.github.abel533.entity.Example;
import com.github.pagehelper.PageInfo;
import com.steven.saar.common.entity.BaseEntity;

import java.io.Serializable;
import java.util.List;

/**
 * 项目名称:com.steven.saar.common.service
 * 类名称:BaseService
 * 描述:
 * 创建人:steven
 * 创建时间:2018-05-19 21:48
 */
public interface BaseService<T extends BaseEntity, ID extends Serializable> {

    /**
     * 根据id查询数据
     *
     * @param id
     * @return
     */
    public T queryById(Integer id);

    /**
     * 查询所有数据
     *
     * @return
     */
    public List<T> queryAll();

    /**
     * 根据条件查询一条数据，如果该条件所查询的数据为多条会抛出异常
     *
     * @param record
     * @return
     */
    public T queryOne(T record);

    /**
     * 根据条件查询多条数据
     *
     * @param record
     * @return
     */
    public List<T> queryListByWhere(T record);

    /**
     * 根据条件查询多条数据，并且指定排序条件，例如：“updated DESC”
     *
     * @param record
     * @param orderBy
     * @return
     */
    public List<T> queryListByWhere(T record, Class<T> clazz, String orderBy);

    /**
     * 根据条件分页查询数据
     *
     * @param record
     * @param page
     * @param rows
     * @return
     */
    public PageInfo<T> queryPageListByWhere(T record, Integer page, Integer rows);

    /**
     * 根据条件分页查询数据，并且指定排序条件，例如：“updated DESC”
     *
     * @param record
     * @param page
     * @param rows
     * @param orderBy
     * @return
     */
    public PageInfo<T> queryPageListByWhere(T record, Integer page, Integer rows, Class<T> clazz,
                                            String orderBy);

    /**
     * 新增数据
     *
     * @param t
     * @return
     */
    public Integer save(T record);

    /**
     * 选择不为null的字段作为插入数据的字段来插入数据
     *
     * @param t
     * @return
     */
    public Integer saveSelective(T record);

    /**
     * 根据主键更新数据
     *
     * @param t
     * @return
     */
    public Integer update(T record);

    /**
     * 选择不为null的字段作为更新的字段来更新数据
     *
     * @param t
     * @return
     */
    public Integer updateSelective(T t);

    public Integer updateSelectiveByExample(T t, Example example);

    /**
     * 根据主键id删除数据（物理删除）
     *
     * @param id
     * @return
     */
    public Integer deleteById(Integer id);

    /**
     * 批量删除数据
     *
     * @param ids
     * @param clazz
     * @param property
     * @return
     */
    public Integer deleteByIds(List<Object> ids, Class<T> clazz, String property);

    /**
     * 根据条件删除数据
     *
     * @param record
     * @return
     */
    public Integer deleteByWhere(T record);

    public PageInfo<T> queryPageListByExample(Example example, Integer page, Integer rows) ;

    public int queryCount(T record);
    public int queryCountByExample(Example example);

}
