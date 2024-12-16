package ait.lesson10.shop_javapro.controler;

import ait.lesson10.shop_javapro.model.dto.ProductDTO;
import ait.lesson10.shop_javapro.model.entity.Product;
import ait.lesson10.shop_javapro.service.interfaces.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

//настройка уровня доступа к приложению
//1. получение всех продуктов- доступна всем пользователям, включая не зарегистрированых
//2. получение продуктов по id - доступна только пользователям зарегестрированным
//3. добавление продукта в БД - доступно только администратору


@RestController
@RequestMapping("/products")
@Tag(name= "Product controller", description = "controller for operations with products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @Operation(summary = "Create product", description = "Add new product", tags = {"Product"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                    @Content(mediaType = "application/json",schema = @Schema(implementation = ProductDTO.class)),
                    @Content(mediaType = "application/xml",schema = @Schema(implementation = ProductDTO.class))
            }),
    })
    @PostMapping
        //create
        public ProductDTO saveProduct(@RequestBody ProductDTO productDTO) {
            // todo обращаемся к сервису для сохранения продукта
            return productService.saveProduct(productDTO);
        }

        // Get
        @Operation(summary = "Get product dy Id", tags = {"Product"})
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200", description = "successful operation", content = {
                        @Content(mediaType = "application/json", schema = @Schema(implementation = ProductDTO.class)),
                        @Content(mediaType = "application/xml", schema = @Schema(implementation = ProductDTO.class)) }),
                @ApiResponse(responseCode = "400", description = "Invalid id supplied", content = @Content),
                @ApiResponse(responseCode = "404", description = "Product not found", content = @Content) })
        @GetMapping("/{id}")
        public ProductDTO getProduct(
                @Parameter(description = "The Id that must to be Fetch", required = true)
                @PathVariable Long id) {
            return productService.getProductById(id);
        }

        @GetMapping
        public List<ProductDTO> getAll() {
            return productService.getAllActiveProducts();
        }

    //          public List<Product> getAll(@RequestParam(required = false) int limit) {
    //          if (limit == null){
    //          return List.of();
    //          }
    //
    //        }

        //Update
        @PutMapping("/{id}")
        public ProductDTO updProduct(@PathVariable Long id,@RequestBody ProductDTO productDTO) {
            return productService.updateProduct(id, productDTO);
        }

        //Delete
        @DeleteMapping("/{id}")
         public ProductDTO deleteProduct(@PathVariable Long id) {
            return productService.deleteProduct(id);
          }

    @DeleteMapping("by-title")
    public ProductDTO deleteProductByTitle(@RequestParam String title) {
        return productService.deleteProductByTitle(title);
    }

    @PutMapping("/restore/{id}")
    public ProductDTO restoreProductById(@PathVariable Long id) {
        return productService.restoreProductById(id);
    }

    @GetMapping("/count")
    public long getProductCount() {
        return productService.getProductCount();
    }

    @GetMapping("/total-price")
    public BigDecimal getTotalPrice() {
        return productService.getTotalPrice();
    }

    @GetMapping("/average-price")
    public BigDecimal getAveragePrice() {
        return productService.getAveragePrice();
    }
}
