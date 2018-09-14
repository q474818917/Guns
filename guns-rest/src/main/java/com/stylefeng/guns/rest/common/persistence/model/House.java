package com.stylefeng.guns.rest.common.persistence.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

@TableName(value = "t_house")
public class House extends Model<House> {

    private String costomer;
    private String cardno;
    private String buildarea;
    private String price;
    private String savedate;
    private String contractno;
    private String houseaddr;
    private String use;
    private String state;
    private String basj;
    private String qfdysj;
    private String dy_sj;
    private String ba_sj;
    private String csdjsj;
    private String scmj;
    private String begindate;
    private String enddate;
    private String firstvalue;
    private String dj_money;
    private String secondvalue;
    private String lastvalue;
    private String firstdate;
    private String dj_date;
    private String seconddate;
    private String lastdate;
    private Date createTime;
    private Date updateTime;

    public String getCostomer() {
        return costomer;
    }

    public void setCostomer(String costomer) {
        this.costomer = costomer;
    }

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno;
    }

    public String getBuildarea() {
        return buildarea;
    }

    public void setBuildarea(String buildarea) {
        this.buildarea = buildarea;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSavedate() {
        return savedate;
    }

    public void setSavedate(String savedate) {
        this.savedate = savedate;
    }

    public String getContractno() {
        return contractno;
    }

    public void setContractno(String contractno) {
        this.contractno = contractno;
    }

    public String getHouseaddr() {
        return houseaddr;
    }

    public void setHouseaddr(String houseaddr) {
        this.houseaddr = houseaddr;
    }

    public String getUse() {
        return use;
    }

    public void setUse(String use) {
        this.use = use;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getBasj() {
        return basj;
    }

    public void setBasj(String basj) {
        this.basj = basj;
    }

    public String getQfdysj() {
        return qfdysj;
    }

    public void setQfdysj(String qfdysj) {
        this.qfdysj = qfdysj;
    }

    public String getDy_sj() {
        return dy_sj;
    }

    public void setDy_sj(String dy_sj) {
        this.dy_sj = dy_sj;
    }

    public String getBa_sj() {
        return ba_sj;
    }

    public void setBa_sj(String ba_sj) {
        this.ba_sj = ba_sj;
    }

    public String getCsdjsj() {
        return csdjsj;
    }

    public void setCsdjsj(String csdjsj) {
        this.csdjsj = csdjsj;
    }

    public String getScmj() {
        return scmj;
    }

    public void setScmj(String scmj) {
        this.scmj = scmj;
    }

    public String getBegindate() {
        return begindate;
    }

    public void setBegindate(String begindate) {
        this.begindate = begindate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public String getFirstvalue() {
        return firstvalue;
    }

    public void setFirstvalue(String firstvalue) {
        this.firstvalue = firstvalue;
    }

    public String getDj_money() {
        return dj_money;
    }

    public void setDj_money(String dj_money) {
        this.dj_money = dj_money;
    }

    public String getSecondvalue() {
        return secondvalue;
    }

    public void setSecondvalue(String secondvalue) {
        this.secondvalue = secondvalue;
    }

    public String getLastvalue() {
        return lastvalue;
    }

    public void setLastvalue(String lastvalue) {
        this.lastvalue = lastvalue;
    }

    public String getFirstdate() {
        return firstdate;
    }

    public void setFirstdate(String firstdate) {
        this.firstdate = firstdate;
    }

    public String getDj_date() {
        return dj_date;
    }

    public void setDj_date(String dj_date) {
        this.dj_date = dj_date;
    }

    public String getSeconddate() {
        return seconddate;
    }

    public void setSeconddate(String seconddate) {
        this.seconddate = seconddate;
    }

    public String getLastdate() {
        return lastdate;
    }

    public void setLastdate(String lastdate) {
        this.lastdate = lastdate;
    }

    @Override
    protected Serializable pkVal() {
        return this.contractno;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "House{" +
                "costomer='" + costomer + '\'' +
                ", cardno='" + cardno + '\'' +
                ", buildarea='" + buildarea + '\'' +
                ", price='" + price + '\'' +
                ", savedate='" + savedate + '\'' +
                ", contractno='" + contractno + '\'' +
                ", houseaddr='" + houseaddr + '\'' +
                ", use='" + use + '\'' +
                ", state='" + state + '\'' +
                ", basj='" + basj + '\'' +
                ", qfdysj='" + qfdysj + '\'' +
                ", dy_sj='" + dy_sj + '\'' +
                ", ba_sj='" + ba_sj + '\'' +
                ", csdjsj='" + csdjsj + '\'' +
                ", scmj='" + scmj + '\'' +
                ", begindate='" + begindate + '\'' +
                ", enddate='" + enddate + '\'' +
                ", firstvalue='" + firstvalue + '\'' +
                ", dj_money='" + dj_money + '\'' +
                ", secondvalue='" + secondvalue + '\'' +
                ", lastvalue='" + lastvalue + '\'' +
                ", firstdate='" + firstdate + '\'' +
                ", dj_date='" + dj_date + '\'' +
                ", seconddate='" + seconddate + '\'' +
                ", lastdate='" + lastdate + '\'' +
                '}';
    }
}
