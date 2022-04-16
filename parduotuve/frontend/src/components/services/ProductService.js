import axios from 'axios';

class ProductService {

    getProducts() {
        return axios.get('http://localhost:8080/api/products');
    }

    addToCart(product) {
        return axios.post('http://localhost:8080/api/cart', product)
    }

    getCartItems() {
        return axios.get('http://localhost:8080/api/cart');
    }

    removeItemFromCart(product) {
        return axios.delete(`http://localhost:8080/api/cart/${product.productId}`, product)
    }
}

export default new ProductService();