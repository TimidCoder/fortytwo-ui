package com.arvatosystems.t9t.tfi.model.bean;

public class ReportFile {

    private String name;
    private String description;
    private String filePath;

    public ReportFile(String name, String description, String filePath) {
        setName(name);
        setDescription(description);
        setFilePath(filePath);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
