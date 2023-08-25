package com.demo.camera.common;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

public class PriceScraper {

    public static void main(String[] args) {
        String productUrl = "https://detail.zol.com.cn/1411/1410436/price.shtml"; // 替换为你要查询的商品链接
        try {
            Document document = Jsoup.connect(productUrl).get();
            Elements priceElements = document.select(".price-type"); // 根据实际网页元素选择器选择价格元素
            Elements priceElements1 = document.select(".brand-name");
            if (!priceElements.isEmpty()) {
                Element priceElement = priceElements.get(0);
                String price = priceElement.text();
                String text = priceElements1.text();
                System.out.println("商品价格：" + price+"; 供应商为：" + text);
            } else {
                System.out.println("未找到价格信息");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

