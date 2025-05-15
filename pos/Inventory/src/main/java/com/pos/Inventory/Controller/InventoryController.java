package com.pos.Inventory.Controller;

import com.pos.Inventory.DTO.ProductDto;
import com.pos.Inventory.Model.Product;
import com.pos.Inventory.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/products",produces = MediaType.APPLICATION_JSON_VALUE)
public class InventoryController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    private List<ProductDto> getAllProducts(){
        return productService.getAllProducts();
    }


//    @GetMapping("/{id}")
//    private ResponseEntity<String> getProduct(@PathVariable String productId){
//        Optional<Product> optionalProduct = productService.findById(productId);
//        return null;
//    }

    @PostMapping("/saveProduct")
    private ProductDto createProduct(@RequestBody ProductDto productDto){
        return productService.saveProduct(productDto);
    }

    @DeleteMapping("/deleteProduct")
    private String deleteProduct(@PathVariable String productId){
        return productService.deleteProduct(productId);
    }

    @PutMapping("/updateProduct")
    private ProductDto updateProduct(@RequestBody ProductDto productDto){
        return productService.updateProduct(productDto);
    }

}
