package com.steven.saar.common.entity.search.filter;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 项目名称:com.steven.saar.common.entity.search.filter
 * 类名称:AndCondition
 * 描述:
 * 创建人:steven
 * 创建时间:2018-05-19 23:50
 */
public class AndCondition implements SearchFilter {

    private List<SearchFilter> andFilters = Lists.newArrayList();

    AndCondition() {
    }

    public AndCondition add(SearchFilter filter) {
        this.andFilters.add(filter);
        return this;
    }

    public List<SearchFilter> getAndFilters() {
        return andFilters;
    }

    @Override
    public String toString() {
        return "AndCondition{" + andFilters + '}';
    }
}
