package com.zzh.controller;

import com.alibaba.fastjson.JSONObject;
import com.sun.org.apache.xpath.internal.operations.Mod;
import com.zzh.mapper.CategoryMapper;
import com.zzh.pojo.Category;
import com.zzh.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class CategoryController {
    @Autowired
    CategoryMapper  categoryMapper;


    @RequestMapping("index")
    @Transactional(propagation = Propagation.REQUIRED,rollbackForClassName = "Exception")
    public ModelAndView listCategory(Page page){
        ModelAndView mav=new ModelAndView();
        int total=categoryMapper.total(page);
        page.cal(total);
        List<Category> cs=categoryMapper.list(page);
        mav.addObject("cs",cs);
        mav.addObject("page",page);
        System.out.println(page.getStart()+" "+page.getLast());
        mav.setViewName("index");
        return mav;
    }

    @RequestMapping("addCategory")
    public ModelAndView addCategory(Category category){

        categoryMapper.add(category);
        ModelAndView mav=new ModelAndView("redirect:/index");
        return mav;
    }

    @RequestMapping("deleteCategory")
    public ModelAndView deleteCategory(Category category){
        ModelAndView mav=new ModelAndView();
        categoryMapper.delete(category);
        mav.setViewName("redirect:/index");
        return mav;
    }

    @RequestMapping("editCategory")
    public ModelAndView editCategory(Category category){
        ModelAndView mav=new ModelAndView();
        Category c=categoryMapper.get(category.getId());
        mav.addObject("c",c);
        mav.setViewName("edit");
        return mav;
    }

    @RequestMapping("updateCategory")
    public ModelAndView updateCategory(Category c){
        ModelAndView mav=new ModelAndView();
        categoryMapper.update(c);
        mav.setViewName("redirect:/index");
        return mav;
    }

    @ResponseBody
    @RequestMapping("submitCategory")
    public String submitCategory(@RequestBody Category category){
        System.out.println("SSM接收到浏览器提交的json，并转换为Category对象:"+category);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("getOneCategory")
    public String getOneCategory(){
        Category c=new Category();
        c.setName("category100");
        c.setId(100);
        JSONObject json=new JSONObject();
        json.put("category",JSONObject.toJSON(c));
        return json.toJSONString();
    }

    @ResponseBody
    @RequestMapping("getManyCategory")
    public String getManyCategory(){
        List<Category> cs=new ArrayList<>();
        for(int i=0;i<10;i++){
            Category c=new Category();
            c.setId(i);
            c.setName("c"+i);
            cs.add(c);
        }
        return JSONObject.toJSON(cs).toString();
    }


}
