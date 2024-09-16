package ca.ulaval.glo4002.mockexercise;

import ca.ulaval.glo4002.mockexercise.do_not_edit.CartFactory;
import ca.ulaval.glo4002.mockexercise.do_not_edit.Invoice;
import ca.ulaval.glo4002.mockexercise.do_not_edit.ProductRepository;

public class StartByTestingThis {

    private CartFactory cartFactory;
    private ProductRepository productRepository;
    private Product product;

    public Cart getCart() {
        return cart;
    }

    private Cart cart;

    public Invoice oneClickBuy(String clientEmail, String productSku) {
        // Étape 1 : Créer le cart avec le CartFactory
        cart = cartFactory.create(clientEmail);
        // Étape 2 : Trouver le produit avec le ProductRepository
        product=productRepository.findBySku(productSku);
        // Étape 3 : Ajouter le produit au cart
        cart.addProduct(product);
        // Étape 4 : Pour chaque item du cart, ajouter une ligne sur l'invoice
        // Étape 5 : Retourner l'invoice
        return null;
    }

    public void setCartFactorty(CartFactory cartFactory) {
        this.cartFactory=cartFactory;
    }

    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository=productRepository;
    }
}
