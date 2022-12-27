package com.example.demo.Service.Impl;

import com.example.demo.Entity.TechnicalDetail;
import com.example.demo.Service.TechnicalDetailService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TechnicalDetailServiceImplTest {

    @Autowired
    private TechnicalDetailService service;
    @Test
    void createDetail() {
        TechnicalDetail detailA = new TechnicalDetail(5000, 50, 220, 100);
        service.createDetail(detailA);
        Assertions.assertEquals(5000, service.findDetailById(1).getAirflow());
    }

    @Test
    void deleteDetailById() {
        TechnicalDetail detailB = new TechnicalDetail(5000, 60, 220, 90);
        service.createDetail(detailB);
        service.deleteDetailById(1);
        Assertions.assertNull(service.findDetailById(1));
    }

    @Test
    void findDetailById() {
        TechnicalDetail detailC = new TechnicalDetail(4800, 60, 240, 110);
        service.createDetail(detailC);
        assertEquals(detailC.getAirflow(), service.findDetailById(1).getAirflow());
    }

    @Test
    void findProductByAirflowBetween() {
        TechnicalDetail detailD = new TechnicalDetail(5100, 50, 240, 100);
        TechnicalDetail detailE = new TechnicalDetail(5200, 50, 220, 100);
        service.createDetail(detailD);
        service.createDetail(detailE);
        List<TechnicalDetail> list = new ArrayList<>();
        list.add(detailD);
        list.add(detailE);
        Assertions.assertEquals(list, service.findProductByAirflowBetween(5100, 5200));
    }

    @Test
    void findProductByPowerBetween() {
        TechnicalDetail detailF = new TechnicalDetail(5100, 70, 110, 90);
        TechnicalDetail detailG = new TechnicalDetail(5200, 80, 220, 110);
        service.createDetail(detailF);
        service.createDetail(detailG);
        List<TechnicalDetail> list = new ArrayList<>();
        list.add(detailF);
        list.add(detailG);
        Assertions.assertEquals(list, service.findProductByPowerBetween(70, 80));
    }

    @Test
    void findProductByOperatingVoltageBetween() {
        TechnicalDetail detailH = new TechnicalDetail(5000, 60, 240, 90);
        TechnicalDetail detailI = new TechnicalDetail(5300, 50, 220, 100);
        service.createDetail(detailH);
        service.createDetail(detailI);
        List<TechnicalDetail> list = new ArrayList<>();
        list.add(detailH);
        list.add(detailI);
        Assertions.assertEquals(list, service.findProductByOperatingVoltageBetween(220, 240));
    }

    @Test
    void findProductByFanSpeedBetween() {
        TechnicalDetail detailJ = new TechnicalDetail(4900, 70, 110, 120);
        TechnicalDetail detailK = new TechnicalDetail(5000, 80, 110, 115);
        service.createDetail(detailJ);
        service.createDetail(detailK);
        List<TechnicalDetail> list = new ArrayList<>();
        list.add(detailJ);
        list.add(detailK);
        Assertions.assertEquals(list, service.findProductByFanSpeedBetween(110, 130));
    }
}