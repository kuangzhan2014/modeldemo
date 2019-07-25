package com.maitianer.common.model;

/**
 * @Author yuzhe
 * @Date 2018/9/29 10:05
 **/
public class FileBean {

    // 文件完整路径
    private String src;
    // 文件相对路径
    private String relativePath;
    // 文件名称（原名）
    private String title;

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRelativePath() {
        return relativePath;
    }

    public void setRelativePath(String relativePath) {
        this.relativePath = relativePath;
    }
}
