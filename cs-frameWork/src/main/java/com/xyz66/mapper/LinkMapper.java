package com.xyz66.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xyz66.domain.entity.Article;
import org.apache.ibatis.annotations.Param;
import com.xyz66.domain.entity.Link;
import org.apache.ibatis.annotations.Mapper;

/**
 * 友链(Link)表数据库访问层
 *
 * @author xyz66 Email:2910223554@qq.com
 * @since 2023-11-28 15:53:55
 */
@Mapper
public interface LinkMapper extends BaseMapper<Link> {


    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Article> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Article> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Article> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Article> entities);

}

