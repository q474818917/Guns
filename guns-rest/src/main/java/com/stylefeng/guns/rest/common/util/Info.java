package com.stylefeng.guns.rest.common.util;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.util.List;

public class Info implements Serializable {

    private List<Row> Row;

    public List<Info.Row> getRow() {
        return Row;
    }

    public void setRow(List<Info.Row> row) {
        Row = row;
    }

    public static class Row {
        private String name;
        private String value;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
