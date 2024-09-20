package com.example.test0914.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.test0914.dto.OrderDTO;
import com.example.test0914.dto.ProductDTO;
import com.example.test0914.entity.Products;
import com.example.test0914.entity.Recipt;
import com.example.test0914.entity.ReciptProducts;
import com.example.test0914.repository.ProductsRepository;
import com.example.test0914.repository.ReciptProductsRepository;
import com.example.test0914.repository.ReciptRepository;
import com.example.test0914.util.Converter;

@Component
public class ReciptServiceImpl implements ReciptService {

    private ReciptRepository reciptRepository;
    private ReciptProductsRepository reciptProductsRepositiory;
    private ProductsRepository productsRepository;

    public ReciptServiceImpl(ReciptRepository reciptRepository,
                            ReciptProductsRepository reciptProductsRepositiory,
                            ProductsRepository productsRepository) {
        this.reciptRepository = reciptRepository;
        this.reciptProductsRepositiory = reciptProductsRepositiory;
        this.productsRepository = productsRepository;
    }

    @Override
    public OrderDTO addRecipt(OrderDTO order) {
        OrderDTO result = new OrderDTO();

        Recipt recipt = new Recipt();
        recipt.setTable_number(order.getTable_number());
        recipt.setPurchase_date(new Date());
        recipt.setPurchase_type(1);
        recipt.setTax(10);
        recipt = reciptRepository.save(recipt);

        result.setId(recipt.getRctId());
        result.setTable_number(recipt.getTable_number());
        result.setPurchase_date(Converter.dateToDMY(recipt.getPurchase_date()));
        result.setPurchase_type(result.getPurchase_type());
        result.setTax(recipt.getTax());
        result.setSuccess(true);
        
        List<ReciptProducts> reciptProducts = new ArrayList<>();
        for (ProductDTO product : order.getProducts()) {
            ReciptProducts rProduct = new ReciptProducts();
            rProduct.setRecipt(recipt);
            rProduct.setProd_serial(product.getProd_serial());
            rProduct.setProd_quantity(product.getProd_quantity());
            rProduct.setPurchase_date(new Date());

            reciptProducts.add(rProduct);
        }

        reciptProductsRepositiory.saveAll(reciptProducts);

        List<ProductDTO> products = new ArrayList<>();
        for (ReciptProducts rProduct : reciptProducts) {
            ProductDTO product = new ProductDTO();
            product.setId(recipt.getRctId());
            product.setProd_serial(rProduct.getProd_serial());
            product.setProd_quantity(rProduct.getProd_quantity());
            product.setPurchase_date(Converter.dateToDMY(rProduct.getPurchase_date()));

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
        result.setTable_number(recipt.getTable_number());
        result.setTax(recipt.getTax());
        result.setPurchase_date(Converter.dateToDMY(recipt.getPurchase_date()));
        result.setPurchase_type(recipt.getPurchase_type());

        List<ReciptProducts> rProducts = reciptProductsRepositiory.findByRecipt_rctId(id);
        List<ProductDTO> products = new ArrayList<>();
        for(ReciptProducts rProduct : rProducts) {
            ProductDTO product = new ProductDTO();
            product.setId(id);
            product.setProd_serial(rProduct.getProd_serial());
            product.setProd_quantity(rProduct.getProd_quantity());
            product.setPurchase_date(Converter.dateToDMY(rProduct.getPurchase_date()));

            products.add(product);
        }
        result.setProducts(products);
        result.setSuccess(true);

        return result;
    }

    @Override
    public List<OrderDTO> getReciptList() throws Exception {
        List<OrderDTO> result = new ArrayList<>();
        
        List<Recipt> recipts = reciptRepository.findByIsDone(false);

        for (Recipt recipt : recipts) {
            OrderDTO order = new OrderDTO();
            order.setId(recipt.getRctId());
            order.setTable_number(recipt.getTable_number());
            order.setTax(recipt.getTax());
            order.setPurchase_date(Converter.dateToDMY(recipt.getPurchase_date()));
            order.setPurchase_type(recipt.getPurchase_type());
            order.setDone(recipt.isDone());

            Long tPrice = 0L;
            List<ReciptProducts> rProducts = reciptProductsRepositiory.findByRecipt_rctId(order.getId());
            List<ProductDTO> products = new ArrayList<>();
            for (ReciptProducts rProduct : rProducts) {
                ProductDTO product = new ProductDTO();
                Products prod_name = productsRepository.findByProdSerial(rProduct.getProd_serial());

                product.setId(order.getId());
                product.setProd_serial(rProduct.getProd_serial());
                product.setProd_name(prod_name.getProd_name());
                product.setProd_price(prod_name.getProd_price());
                product.setProd_quantity(rProduct.getProd_quantity());
                product.setPurchase_date(Converter.dateToDMY(rProduct.getPurchase_date()));

                products.add(product);

                tPrice = tPrice + prod_name.getProd_price() * rProduct.getProd_quantity();
            }

            order.setTotal_price(tPrice);

            order.setProducts(products);
            order.setSuccess(true);

            result.add(order);
        }

        return result;
    }

}
