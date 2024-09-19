package com.example.test0914.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.test0914.dto.OrderDTO;
import com.example.test0914.dto.ProductDTO;
import com.example.test0914.entity.Recipt;
import com.example.test0914.entity.ReciptProducts;
import com.example.test0914.repository.ReciptProductsRepositiory;
import com.example.test0914.repository.ReciptRepository;

@Component
public class ReciptServiceImpl implements ReciptService {

    private ReciptRepository reciptRepository;
    private ReciptProductsRepositiory reciptProductsRepositiory;

    public ReciptServiceImpl(ReciptRepository reciptRepository, ReciptProductsRepositiory reciptProductsRepositiory) {
        this.reciptRepository = reciptRepository;
        this.reciptProductsRepositiory = reciptProductsRepositiory;
    }

    @Override
    public OrderDTO addRecipt(OrderDTO order) {
        OrderDTO result = new OrderDTO();

        Recipt recipt = new Recipt();
        recipt.setPurchase_date(new Date());
        recipt.setPurchase_type(1);
        recipt.setTax(10);
        recipt = reciptRepository.save(recipt);

        result.setId(recipt.getRctId());
        result.setPurchase_date(recipt.getPurchase_date());
        result.setPurchase_type(result.getPurchase_type());
        result.setTax(recipt.getTax());
        result.setSuccess(true);
        
        List<ReciptProducts> reciptProducts = new ArrayList<>();
        for (ProductDTO product : order.getProducts()) {
            ReciptProducts rProduct = new ReciptProducts();
            rProduct.setRecipt(recipt);
            rProduct.setProd_serial(product.getProd_serial());
            rProduct.setProd_quantity(product.getProd_quantity());
            rProduct.setPurchase_date(product.getPurchase_date());

            reciptProducts.add(rProduct);
        }

        reciptProductsRepositiory.saveAll(reciptProducts);

        List<ProductDTO> products = new ArrayList<>();
        for (ReciptProducts rProduct : reciptProducts) {
            ProductDTO product = new ProductDTO();
            product.setId(recipt.getRctId());
            product.setProd_serial(rProduct.getProd_serial());
            product.setProd_quantity(rProduct.getProd_quantity());
            product.setPurchase_date(rProduct.getPurchase_date());

            products.add(product);
        }

        result.setProducts(products);

        return result;
    }

    @Override
    public OrderDTO getRecipt(String recipt_id) throws Exception {
        OrderDTO result = new OrderDTO();

        Long id = Long.parseLong(recipt_id);
        Recipt recipt = reciptRepository.findById(id).get();
        result.setId(recipt.getRctId());
        result.setTax(recipt.getTax());
        result.setPurchase_date(recipt.getPurchase_date());
        result.setPurchase_type(recipt.getPurchase_type());

        List<ReciptProducts> rProducts = reciptProductsRepositiory.findByRecipt_rctId(id);
        List<ProductDTO> products = new ArrayList<>();
        for(ReciptProducts rProduct : rProducts) {
            ProductDTO product = new ProductDTO();
            product.setId(id);
            product.setProd_serial(rProduct.getProd_serial());
            product.setProd_quantity(rProduct.getProd_quantity());
            product.setPurchase_date(rProduct.getPurchase_date());

            products.add(product);
        }
        result.setProducts(products);
        result.setSuccess(true);

        return result;
    }

}
