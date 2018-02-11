package com.lix.entity.vo;

import java.util.List;

/**
 * @author : lix
 * @desc :
 * @time : 10:102017/12/21
 * @modify by :
 */
public class ExtTreeVO {

    private String id;
    private String text;
    private String cls;
    private boolean leaf;
    private List<ExtTreeVO> children;
    private String cslevel;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCls() {
        return cls;
    }

    public void setCls(String cls) {
        this.cls = cls;
    }

    public boolean isLeaf() {
        return leaf;
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }

    public List<ExtTreeVO> getChildren() {
        return children;
    }

    public void setChildren(List<ExtTreeVO> children) {
        this.children = children;
    }

    public String getCslevel() {
        return cslevel;
    }

    public void setCslevel(String cslevel) {
        this.cslevel = cslevel;
    }
}
