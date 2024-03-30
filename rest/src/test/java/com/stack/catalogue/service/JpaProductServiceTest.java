package com.stack.catalogue.service;

import com.stack.catalogue.dao.ProductRepository;
import com.stack.catalogue.model.BaseDto;
import com.stack.catalogue.model.PostProductPayload;
import com.stack.catalogue.model.Product;
import com.stack.catalogue.model.ProductResponseDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@ExtendWith(MockitoExtension.class)
class JpaProductServiceTest {

    private final int id = 1;
    private final int page = 0;
    private final int size = 10;
    private final String title = "product";
    private final String details = "details";
    Product product = new Product(1, title, details);
    private final PageRequest pageable = PageRequest.of(page, size);
    
    @Mock
    ProductRepository productRepository;

    @InjectMocks
    JpaProductService service;

    @Test
    void findAllProductsFilterIsNotSetReturnsProductsList() {
        List<Product> products = getProducts();
        Page<Product> pages = new PageImpl<>(products);

        doReturn(pages).when(productRepository).findAll(pageable);
        Iterable<Product> result = service.findAllProducts(null, page, size);

        assertEquals(products, result);
        verify(productRepository).findAll(pageable);
        verifyNoMoreInteractions(productRepository);
    }

    @Test
    void findAllProductsFilterIsSetReturnsFilteredProductsList() {
        List<Product> products = getProducts();
        String filter = "product";
        Page<Product> pages = new PageImpl<>(products);

        doReturn(pages).when(productRepository).findByTitleContaining(filter, pageable);
        Iterable<Product> result = service.findAllProducts(filter, page, size);

        assertEquals(products, result);
        verify(productRepository).findByTitleContaining(filter, pageable);
        verifyNoMoreInteractions(productRepository);
    }

    @Test
    void findProductProductExistsReturnsNotEmptyOptional() {
        doReturn(Optional.of(product)).when(this.productRepository).findById(id);
        var result = this.service.findProductById(id);

        assertNotNull(result);
        assertTrue(result.isPresent());
        assertEquals(product, result.orElseThrow());

        verify(this.productRepository).findById(id);
        verifyNoMoreInteractions(this.productRepository);
    }

    @Test
    void findProductProductDoesNotExistReturnsEmptyOptional() {
        Optional<Product> result = this.service.findProductById(id);

        assertNotNull(result);
        assertTrue(result.isEmpty());

        verify(this.productRepository).findById(1);
        verifyNoMoreInteractions(this.productRepository);
    }

//    @Test
    void createProductReturnsCreatedProduct() {
        doReturn(product).when(this.productRepository).save(new Product(null, "product", "Details"));
        PostProductPayload payload = new PostProductPayload("", 1D, title, details);
        ResponseEntity<BaseDto> result = this.service.createProduct(payload, UriComponentsBuilder.fromPath(""));
        ProductResponseDto createdProduct = (ProductResponseDto) result.getBody();
        assertEquals(HttpStatus.CREATED, result.getStatusCode());
        assertNotNull(createdProduct);
        assertEquals(product.getTitle(), createdProduct.getTitle());
        assertEquals(product.getDetails(), createdProduct.getDetails());
        verify(this.productRepository).save(new Product(null, "product", "Details"));
        verifyNoMoreInteractions(this.productRepository);
    }

    @Test
    void updateProductProductExistsUpdatesProduct() {
        PostProductPayload payload = new PostProductPayload("", 1D, title, details);

        doReturn(Optional.of(product)).when(this.productRepository).findById(1);
        this.service.updateProduct(id, payload);

        verify(this.productRepository).findById(id);
        verifyNoMoreInteractions(this.productRepository);
    }

    @Test
    void updateProductProductDoesNotExistThrowsNoSuchElementException() {
        PostProductPayload payload = new PostProductPayload("", 1D, title, details);

        assertThrows(NoSuchElementException.class, () -> this.service.updateProduct(id, payload));

        verify(this.productRepository).findById(id);
        verifyNoMoreInteractions(this.productRepository);
    }

    @Test
    void deleteProductDeletesProduct() {
        this.service.deleteProduct(id);
        verify(this.productRepository).deleteById(id);
        verifyNoMoreInteractions(this.productRepository);
    }

    private Product getProduct(int i) {
        return new Product(i, "product #%d".formatted(i), "Desc №%d".formatted(i));
    }

    private List<Product> getProducts() {
        return IntStream.range(1, 4)
                        .mapToObj(this::getProduct)
                        .toList();
    }
}
