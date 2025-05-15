package com.pos.Inventory.Service;

import com.pos.Inventory.DTO.ProductDto;
import com.pos.Inventory.Model.Product;
import com.pos.Inventory.Repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<ProductDto> getAllProducts() {
        List<Product> userList = productRepository.findAll();
        return modelMapper.map(userList, new TypeToken<List<ProductDto>>() {}.getType());
    }

    public ProductDto saveProduct(ProductDto userDTO) {
        productRepository.save(modelMapper.map(userDTO, Product.class));
        return userDTO;
    }

    public ProductDto updateProduct(ProductDto userDTO) {
        productRepository.save(modelMapper.map(userDTO, Product.class));
        return userDTO;
    }

    public String deleteProduct(String productId) {
        productRepository.deleteById((productId));
        return "Product deleted";

}}
