package com.steven.util;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author CXQ
 * @version 1.0
 */
@Data
public class PagingUtil implements Serializable {

    /**
     * 每页条目数，当前页，总页数，总条目数
     */
    private Integer size, page, pages, total;

    /**
     * 页面数字排列
     */
    private List<String> pageList;

    /**
     * 构造分页工具类时，若不指定参数，则默认为显示第1页，每页显示5条
     */
    public PagingUtil() {
        this("1", "5");
    }

    /**
     * 构造分页工具类时，可以指定当前页码和每页条目数，为方便控制层调用，参数皆为String类型
     *
     * @param page 当前显示第几页
     * @param size 每页显示多少条
     */
    public PagingUtil(String page, String size) {
        try {
            int realPage = Integer.parseInt(page);
            int realSize = Integer.parseInt(size);
            if (realPage > 0 && realSize > 0) {
                this.page = realPage;
                this.size = realSize;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 构建并返回MySQL分页查询中，limit的第一个参数
     *
     * @return MySQL分页查询中，limit的第一个参数
     */
    public int getLimitParam1() {
        return (this.page - 1) * size;
    }

    /**
     * 构建并返回MySQL分页查询中，limit的第二个参数
     *
     * @return MySQL分页查询中，limit的第二个参数
     */
    public int getLimitParam2() {
        return this.size;
    }

    /**
     * 构建并返回MySQL分页查询中，完整的limit语句
     *
     * @return MySQL分页查询中，完整的limit语句
     */
    public String getLimitSuffix() {
        return " LIMIT " + getLimitParam1() + ", " + getLimitParam2();
    }

    /**
     * 设置总条目数，同时计算出总页数
     *
     * @param total 总条目数
     */
    public void buildTotalAndPages(int total) {
        this.total = total;
        double size = this.size;
        this.pages = (int) Math.ceil(total / size);
    }

    /**
     * 构建页面数字排列
     */
    public void buildPageList() {

        pageList = new ArrayList<>();

        // 当总页数大于2时，前2个数字 ["1"] 和 ["2"] 是固定必有的
        int constLength = 2;

        // 数字排列中不确定的数字最多不超过5个
        int varLength = 5;

        // 数字排列中所有数字一共最多不超过7个
        int maxLength = 7;

        // 总页数至少为1，所以 ["1"] 一定存在
        pageList.add("1");

        // 总页数大于1时，["2"] 一定存在
        if (pages > 1) {
            pageList.add("2");

            // 当前页码小于等于5时：["1"] ["2"] ["3"] ["4"] ["5"]
            if (page <= varLength) {

                // 生成 ["2"] 之后的数字排列，超出总页数部分不生成，且最多5个
                // 5 6
                for (int i = constLength; i < maxLength && i < pages; i++) {
                    pageList.add(i + 1 + "");
                }

                // 总页数大于7时，末尾添加 ["..."]
                if (pages > maxLength) {
                    pageList.add("...");
                }
            } else {
                // 当前页大于5时：["1"] ["2"] [...] ["3"] ["4"] ["5"]
                pageList.add("...");

                // 在当前页左右两侧各生成2个数字排列，超出总页数的部分不创建，加上自己一共5个
                for (int i = -constLength; i <= constLength && page + i <= pages; i++) {
                    pageList.add(page + i + "");
                }

                // 总页数大于7，且当前页右边还有2个以上的元素的时候，生成第二个 [...]
                if (pages > maxLength && page < pages - constLength) {
                    pageList.add("...");
                }
            }
        }
    }
}
