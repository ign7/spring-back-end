package com.example.control.util;

public class MyBean {
    private String datasourceUrl;
    private String datasourceUsername;
    private String datasourcePassword;
    private String hibernateDdlAuto;
    private String showSql;

    // Construtor vazio
    public MyBean() {
    }

    public String getDatasourceUrl() {
        return datasourceUrl;
    }

    public void setDatasourceUrl(String datasourceUrl) {
        this.datasourceUrl = datasourceUrl;
    }

    public String getDatasourceUsername() {
        return datasourceUsername;
    }

    public void setDatasourceUsername(String datasourceUsername) {
        this.datasourceUsername = datasourceUsername;
    }

    public String getDatasourcePassword() {
        return datasourcePassword;
    }

    public void setDatasourcePassword(String datasourcePassword) {
        this.datasourcePassword = datasourcePassword;
    }

    public String getHibernateDdlAuto() {
        return hibernateDdlAuto;
    }

    public void setHibernateDdlAuto(String hibernateDdlAuto) {
        this.hibernateDdlAuto = hibernateDdlAuto;
    }

    public String getShowSql() {
        return showSql;
    }

    public void setShowSql(String showSql) {
        this.showSql = showSql;
    }
}

