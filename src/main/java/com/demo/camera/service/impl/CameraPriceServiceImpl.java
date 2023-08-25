package com.demo.camera.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.camera.common.ApiResponse;
import com.demo.camera.common.ParameterCondition;
import com.demo.camera.entity.CameraInfo;
import com.demo.camera.entity.CameraPrice;
import com.demo.camera.entity.CameraUrl;
import com.demo.camera.mapper.CameraInfoMapper;
import com.demo.camera.mapper.CameraPriceMapper;
import com.demo.camera.mapper.CameraUrlMapper;
import com.demo.camera.service.ICameraPriceService;
import com.demo.camera.utils.JsonUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
public class CameraPriceServiceImpl extends ServiceImpl<CameraPriceMapper, CameraPrice> implements ICameraPriceService {

    @Value("${url.data}") // 读取配置中的文件上传路径
    private String useUrl;
    @Autowired
    private CameraPriceMapper cameraPriceMapper;

    @Autowired
    private CameraInfoMapper cameraInfoMapper;

    @Autowired
    private CameraUrlMapper cameraUrlMapper;

    @Override
    public ApiResponse<List<CameraPrice>> queryByCondition(ParameterCondition param) {
        CameraPrice cameraPrice = JsonUtil.getEntityClazz(param.getFilter(),CameraPrice.class);
        PageHelper.startPage(param.getPageIndex(),param.getPageSize());
        List<CameraPrice> pages = cameraPriceMapper.selectCameraPriceByCondition(cameraPrice);

//        stdCodeUtils.changeValue(pages);
        PageInfo<CameraPrice> pageInfo = new PageInfo<>(pages);
        return ApiResponse.success(pageInfo.getList(),pageInfo.getTotal());
    }

    @Override
    public void queryNewPrice(List<Integer> camIds) {
        CameraUrl cameraUrl = new CameraUrl();
        cameraUrl.setCamIds(camIds);
        cameraUrl.setUseUrl(useUrl);
        List<CameraUrl> cameraUrls = cameraUrlMapper.selectCameraUrlByCondition(cameraUrl);
        for (CameraUrl camUrl : cameraUrls){
            try {
                String url = camUrl.getUrl();
                Document document = Jsoup.connect(url).get();
                Elements priceElements = document.select(".price-type"); // 根据实际网页元素选择器选择价格元素
                Elements priceElements1 = document.select(".brand-name");
                if (!priceElements.isEmpty()) {
                    CameraPrice cameraPrice = new CameraPrice();
                    Element priceElement = priceElements.get(0);
                    String price = priceElement.text();
                    String supplier = priceElements1.text();
                    cameraPrice.setCamId(camUrl.getCamId());
                    cameraPrice.setPrice(Double.parseDouble(price));
                    cameraPrice.setSupplier(supplier);
                    cameraPrice.setAddTime(new Date());
                    cameraPriceMapper.insert(cameraPrice);
                    CameraInfo cameraInfo = cameraInfoMapper.selectById(camUrl.getCamId());
                    cameraInfo.setNowPrice(Double.parseDouble(price));
                    cameraInfoMapper.updateById(cameraInfo);
                } else {
                    System.out.println(camUrl + "链接未找到价格信息");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
