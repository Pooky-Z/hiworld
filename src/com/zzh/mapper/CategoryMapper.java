package com.zzh.mapper;

import com.zzh.pojo.Category;
import com.zzh.utils.Page;

import java.util.List;

public interface CategoryMapper {
    public void add(Category c);
    public void delete(Category c);
    public void update(Category c);
    public List<Category> list(Page page);
    public List<Category> list();
    public Category get(int id);
    public int total(Page page);
}
