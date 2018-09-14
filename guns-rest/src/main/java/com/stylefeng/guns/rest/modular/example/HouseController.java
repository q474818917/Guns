package com.stylefeng.guns.rest.modular.example;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.stylefeng.guns.rest.common.SimpleObject;
import com.stylefeng.guns.rest.common.persistence.dao.HouseMapper;
import com.stylefeng.guns.rest.common.persistence.dao.UserMapper;
import com.stylefeng.guns.rest.common.persistence.model.House;
import com.stylefeng.guns.rest.common.persistence.model.User;
import com.stylefeng.guns.rest.common.util.HouseRequest;
import com.stylefeng.guns.rest.common.util.HttpClientUtil;
import com.stylefeng.guns.rest.common.util.Info;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.protocol.HttpContext;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.net.ssl.SSLException;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Date;


@Controller
@RequestMapping("/house")
public class HouseController {

    @Autowired
    private HouseMapper houseMapper;

    @RequestMapping("")
    public ResponseEntity crawl(@RequestBody HouseRequest houseRequest) {
        BasicClientCookie pagesCookie = new BasicClientCookie("tjfdc", "web_100.42");
        BasicClientCookie aspCookie = new BasicClientCookie("ASP.NET_SessionId", "pi2jrr35ccx2jk0pq54trbqw");
        pagesCookie.setDomain("www.tjfdc.com.cn");
        pagesCookie.setPath("/Pages");
        aspCookie.setDomain("www.tjfdc.com.cn");
        aspCookie.setPath("/");

        CookieStore cookieStore = new BasicCookieStore();
        cookieStore.addCookie(pagesCookie);
        cookieStore.addCookie(aspCookie);
        CloseableHttpClient httpClient = HttpClients.custom().setProxy(new HttpHost(houseRequest.getProxyHost(), houseRequest.getProxyPort()))
                .setRetryHandler(getRetryHandler())
                .setDefaultCookieStore(cookieStore).build();
        String yzm = houseRequest.getYzm();
        String year = houseRequest.getYear();

        int length = "1000000".length();
        int s = houseRequest.getIndex();
        for(int i = s; i< 1000000; i++){
            String temp0 = "";
            for(int j =0; j< length - String.valueOf(i).length(); j++) {
                temp0 = temp0 + "0";
            }
            String zjhm2 = year + "-" + temp0 + i;
            /*String zjhm2 = "2018-0054";
            if (i < 10) {
                zjhm2 = zjhm2 + "00" + i;
            } else if (i < 100) {
                zjhm2 = zjhm2 + "0" + i;
            } else {
                zjhm2 = zjhm2 + i;
            }*/
            System.out.println(zjhm2);

            String content = HttpClientUtil.doPost(httpClient,
                    "http://www.tjfdc.com.cn/Pages/fcdt/data/SearchHandler.ashx?zjhm2=" + zjhm2 + "&type=2&yzm=" + yzm
                            + "&e=0.9896785756105548");
            if (StringUtils.isNotEmpty(content)) {
                Info info = JSONObject.parseObject(content, Info.class);

                if (info != null) {
                    House temp = new House();
                    temp.setContractno(zjhm2);
                    House house = houseMapper.selectOne(temp);

                    if(house != null) {
                        house.setBa_sj(info.getRow().get(12).getValue());
                        house.setBasj(info.getRow().get(9).getValue());
                        house.setBegindate(info.getRow().get(15).getValue());
                        house.setBuildarea(info.getRow().get(2).getValue());
                        house.setCardno(info.getRow().get(1).getValue());
                        house.setCostomer(info.getRow().get(0).getValue());
                        house.setCsdjsj(info.getRow().get(13).getValue());
                        house.setDj_date(info.getRow().get(22).getValue());
                        house.setDj_money(info.getRow().get(18).getValue());
                        house.setDy_sj(info.getRow().get(11).getValue());
                        house.setEnddate(info.getRow().get(16).getValue());
                        house.setFirstdate(info.getRow().get(21).getValue());
                        house.setFirstvalue(info.getRow().get(17).getValue());
                        //house.setHouseaddr(info.getRow().get(6).getValue());
                        house.setLastdate(info.getRow().get(24).getValue());
                        house.setLastvalue(info.getRow().get(20).getValue());
                        house.setPrice(info.getRow().get(3).getValue());
                        house.setQfdysj(info.getRow().get(10).getValue());
                        house.setSavedate(info.getRow().get(4).getValue());
                        house.setScmj(info.getRow().get(14).getValue());
                        house.setSeconddate(info.getRow().get(23).getValue());
                        house.setSecondvalue(info.getRow().get(19).getValue());
                        house.setState(info.getRow().get(8).getValue());
                        house.setUse(info.getRow().get(7).getValue());
                        house.setUpdateTime(new Date());

                        Wrapper wrapper = new EntityWrapper();
                        wrapper = wrapper.eq("Contractno", zjhm2);
                        houseMapper.update(house, wrapper);
                    }else {
                        house = new House();
                        house.setBa_sj(info.getRow().get(12).getValue());
                        house.setBasj(info.getRow().get(9).getValue());
                        house.setBegindate(info.getRow().get(15).getValue());
                        house.setBuildarea(info.getRow().get(2).getValue());
                        house.setCardno(info.getRow().get(1).getValue());
                        house.setCostomer(info.getRow().get(0).getValue());
                        house.setCsdjsj(info.getRow().get(13).getValue());
                        house.setDj_date(info.getRow().get(22).getValue());
                        house.setDj_money(info.getRow().get(18).getValue());
                        house.setDy_sj(info.getRow().get(11).getValue());
                        house.setEnddate(info.getRow().get(16).getValue());
                        house.setFirstdate(info.getRow().get(21).getValue());
                        house.setFirstvalue(info.getRow().get(17).getValue());
                        house.setHouseaddr(info.getRow().get(6).getValue());
                        house.setLastdate(info.getRow().get(24).getValue());
                        house.setLastvalue(info.getRow().get(20).getValue());
                        house.setPrice(info.getRow().get(3).getValue());
                        house.setQfdysj(info.getRow().get(10).getValue());
                        house.setSavedate(info.getRow().get(4).getValue());
                        house.setScmj(info.getRow().get(14).getValue());
                        house.setSeconddate(info.getRow().get(23).getValue());
                        house.setSecondvalue(info.getRow().get(19).getValue());
                        house.setState(info.getRow().get(8).getValue());
                        house.setUse(info.getRow().get(7).getValue());
                        house.setContractno(zjhm2);
                        houseMapper.insert(house);
                    }
                }
            }

        }
        return ResponseEntity.ok("请求成功!");
    }

    private HttpRequestRetryHandler getRetryHandler() {
        return new HttpRequestRetryHandler() {

            @Override
            public boolean retryRequest(IOException exception, int executionCount, HttpContext context) {
                if (executionCount > 3) {
                    return false;
                }
                if (exception instanceof UnknownHostException || exception instanceof ConnectTimeoutException
                        || !(exception instanceof SSLException) || exception instanceof NoHttpResponseException) {
                    return true;
                }
                HttpClientContext clientContext = HttpClientContext.adapt(context);
                HttpRequest request = clientContext.getRequest();
                boolean idempotent = !(request instanceof HttpEntityEnclosingRequest);
                if (idempotent) {
                    // 如果请求被认为是幂等的，那么就重试。即重复执行不影响程序其他效果的
                    return true;
                }
                return false;
            }

        };
    }
}
