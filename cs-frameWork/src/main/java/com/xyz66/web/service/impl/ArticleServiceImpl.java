package com.xyz66.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xyz66.web.domain.entity.Article;
import com.xyz66.web.mapper.ArticleMapper;
import com.xyz66.web.service.ArticleService;
import com.xyz66.web.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 文章表(Article)表服务实现类
 *
 * @author xyz66 Email:2910223554@qq.com
 * @since 2023-11-28 14:42:12
 */
@Service("articleService")
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {
    
    @Autowired
    private CommentService commentService;// 循环依赖测试
    public void test(){
        System.out.println("循环依赖测试");
        commentService.lambdaQuery().list().forEach(System.out::println);
    }
}

