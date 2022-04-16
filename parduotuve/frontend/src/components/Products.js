import React, {useContext} from 'react'
import {DataContext} from './DataProvider'
import {Link} from 'react-router-dom'
import ProductService from './services/ProductService'

export default function Products() {
    const value = useContext(DataContext)
    const [products] = value.products

    return (
        <div className="products">
            {
                products.map(product =>(
                    <div className="card" key={product.productId}>
                        <Link to={`/products/${product.productId}`}>
                            <img src={product.productImageLink} alt=""/>
                        </Link>
                        <div className="box">
                        <h3 title={product.productTitle}>
                            <Link to={`/products/${product.productId}`}>{product.productTitle}</Link>
                        </h3>
                        <p>{product.productDescription}</p>
                        <h4>${product.productPrice}</h4>
                        <button onClick={
                            () => ProductService.addToCart(product)}>
                            Add to cart 
                        </button>
                        </div>
                    </div>
                ))
            }
          
          
        </div>
    )
}
