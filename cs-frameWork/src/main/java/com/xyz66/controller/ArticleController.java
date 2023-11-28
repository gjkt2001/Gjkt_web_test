package com.xyz66.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xyz66.domain.ResponseResult;
import com.xyz66.domain.entity.Article;
import com.xyz66.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * 文章表(Article)表控制层
 *
 * @author xyz66 Email:2910223554@qq.com
 * @since 2023-11-28 15:09:13
 */
@RestController
@RequestMapping("/article")
public class ArticleController{
    /**
     * 服务对象
     */
    @Autowired
    private ArticleService articleService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param article 查询实体
     * @return 所有数据
     */
    @GetMapping
    public ResponseResult selectAll(Page<Article> page, Article article) {
        return ResponseResult.okResult(this.articleService.page(page, new QueryWrapper<>(article)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseResult selectOne(@PathVariable Serializable id) {
        return ResponseResult.okResult(this.articleService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param article 实体对象
     * @return 新增结果
     */
    @PostMapping
    public ResponseResult insert(@RequestBody Article article) {
        return ResponseResult.okResult(this.articleService.save(article));
    }

    /**
     * 修改数据
     *
     * @param article 实体对象
     * @return 修改结果
     */
    @PutMapping
    public ResponseResult update(@RequestBody Article article) {
        return ResponseResult.okResult(this.articleService.updateById(article));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public ResponseResult delete(@RequestParam("idList") List<Long> idList) {
        return ResponseResult.okResult(this.articleService.removeByIds(idList));
    }
}
