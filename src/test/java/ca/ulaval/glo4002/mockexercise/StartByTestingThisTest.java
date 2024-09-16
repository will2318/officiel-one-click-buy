package ca.ulaval.glo4002.mockexercise;

import ca.ulaval.glo4002.mockexercise.do_not_edit.CartFactory;
import ca.ulaval.glo4002.mockexercise.do_not_edit.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class StartByTestingThisTest {

    public static final String UN_MAIL = "test@gmail.com";
    public static final String SKU = "000";
    public static final String NAME = "produit1";
    public static final double PRICE = 30.0;
    private StartByTestingThis service;
    private  CartFactory cartFactory;
    private ProductRepository productRepository;

    @BeforeEach
    public void setUp() {
        service = new StartByTestingThis();
        cartFactory=mock(CartFactory.class);
        productRepository=mock(ProductRepository.class);
        service.setCartFactorty(cartFactory);
        service.setProductRepository(productRepository);
    }

    @Test
    void givenClientEmailAndProducSkuWhenOneClickBuyThenShouldCreateCart(){
        service.oneClickBuy(UN_MAIL, SKU);
        verify(cartFactory).create(any());
    }

    @Test
    void givenClientEmailAndProducSkuWhenOneClickBuyThenShouldFindTheProduct(){

        Product product= new Product(SKU, NAME, PRICE);
        when(productRepository.findBySku(SKU)).thenReturn(product);

        service.oneClickBuy(UN_MAIL, SKU);

        verify(productRepository).findBySku(SKU);
    }
}
