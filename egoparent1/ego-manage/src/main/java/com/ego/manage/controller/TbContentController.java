package com.ego.manage.controller;

import com.ego.commons.pojo.EasyUIDataGrid;
import com.ego.commons.pojo.EgoResult;
import com.ego.manage.service.TbContentService;
import com.ego.pojo.TbContent;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class TbContentController {
    @Resource
    private TbContentService tbContentServiceImpl;

    /**
     * 显示内容信息
     */
    @RequestMapping("content/query/list")
    @ResponseBody
    public EasyUIDataGrid showContent(long categoryId, int page, int rows){
        return tbContentServiceImpl.showContent(categoryId, page, rows);
    }
    /**
     * 新增内容
     */
    @RequestMapping("content/save")
    @ResponseBody
    public EgoResult save(TbContent content){
        EgoResult er = new EgoResult();
        int index = tbContentServiceImpl.save(content);
        if(index>0){
            er.setStatus(200);
        }
        return er;
    }
}
