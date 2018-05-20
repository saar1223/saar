package com.steven.saar.common.entity.search.filter;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 项目名称:com.steven.saar.common.entity.search.filter
 * 类名称:OrCondition
 * 描述:
 * 创建人:steven
 * 创建时间:2018-05-19 23:50
 */
public class OrCondition implements SearchFilter {

    private List<SearchFilter> orFilters = Lists.newArrayList();

    OrCondition() {
    }

    public OrCondition add(SearchFilter filter) {
        this.orFilters.add(filter);
        return this;
    }

    public List<SearchFilter> getOrFilters() {
        return orFilters;
    }

    @Override
    public String toString() {
        return "OrCondition{" + orFilters + '}';
    }
}
