import React, {createContext, useState, useEffect} from 'react'
import ProductService from './services/ProductService';

export const DataContext = createContext();

export const DataProvider = (props) => {
    const [products, setProducts] = useState([]);

    useEffect(() => {
        ProductService.getProducts().then((response) => {
        setProducts(response.data)
        })
    }, [setProducts])

    const [cart, setCart] = useState([])

    const addCart = (id) => {
        const check = cart.every(item => {
            return item.productId !== id
        })
        if(check){
            const data = products.filter(product => {
                return product.productId === id
            })
            setCart([...cart, ...data])
    }
}

    useEffect(() => {
        localStorage.setItem('dataCart', JSON.stringify(cart))
    },[cart])


    const value = {
        products: [products, setProducts],
        cart: [cart, setCart],
        addCart: addCart
    }

    return (
        <DataContext.Provider value={value}>
            {props.children}
        </DataContext.Provider>
    )
}
