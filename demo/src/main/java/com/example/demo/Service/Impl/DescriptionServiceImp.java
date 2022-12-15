package com.example.demo.Service.Impl;
//modified by Victoria
import com.example.demo.Entity.Description;
import com.example.demo.Entity.Product;
import com.example.demo.Repository.DescriptionRepository;
import com.example.demo.Service.DescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service//set DescriptionServiceImp as a bean
public class DescriptionServiceImp implements DescriptionService {
    @Autowired//to achieve dependency injection(now DescriptionServiceImp can use all methods from DescriptionRepository)
    private DescriptionRepository repository;

    @Override
    public Description createDescription(Description description) {//我自己定义的接口里的abstract method
        return repository.save(description);////我在repository里让jpa帮忙实现的method
    }

    @Override
    public Description findDescriptionByDescriptionId(Integer id) {
        return repository.findById(id).orElse(null);//based on what I defined in Repository
    }

    @Override
    public Description findDescriptionByProductId(Integer id) {
        return repository.findByProduct(id).orElse(null);
    }

    @Override
    public List<Description> findAll() {
        return repository.findAll();
    }

    @Override
    public String deleteDescriptionByDescriptionId(Integer id) {
        repository.deleteById(id);
        return "Deleted" + id.toString();
    }

    //find by Manufacturer, Series, and Model
    @Override
    public List<Description> findDescriptionByManufacturer(String manufacturer) {
        return repository.findByManufacturer(manufacturer).orElse(null);
    }

    @Override
    public List<Description> findDescriptionBySeries(String series) {
        return repository.findBySeries(series).orElse(null);
    }

    @Override
    public List<Description> findDescriptionByModel(String model) {
        return repository.findByModel(model).orElse(null);
    }


}
