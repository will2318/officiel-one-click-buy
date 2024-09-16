package ca.ulaval.glo4002.mockexercise;

import ca.ulaval.glo4002.mockexercise.do_not_edit.CartFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class StartByTestingThisTest {

    public static final String UN_MAIL = "test@gmail.com";
    public static final String UN_PRODUCK_SKU = "12345";
    private StartByTestingThis service;
    private  CartFactory cartFactory;

    @BeforeEach
    public void setUp() {
        service = new StartByTestingThis();
        cartFactory=mock(CartFactory.class);
        service.setCartFactorty(cartFactory);
    }

    @Test
    void givenClientEmailAndProducSkuWhenOneClickBuyThenShouldCreateCart(){
        service.oneClickBuy(UN_MAIL, UN_PRODUCK_SKU);
        verify(cartFactory).create(any());
    }
}
