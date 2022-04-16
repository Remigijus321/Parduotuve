import React,{useContext, useState, useEffect} from 'react'
import {DataContext} from './DataProvider'
import {Link} from 'react-router-dom'
import ProductService from './services/ProductService'
import axios from 'axios'

export default function Cart() {
    const value = useContext(DataContext)
    const [cart, setCart] = value.cart;
    const [total, setTotal] = useState(0)

    useEffect(() => {
        axios.get('http://localhost:8080/api/cart').then(response => setCart(response.data))
    }, [setCart])

    useEffect(() => {
        const getTotal = () => {
            const res = cart.reduce((prev, item) => {
                return prev + (item.productPrice * item.productCount)
            },0)
            setTotal(res)
        }
        getTotal();
    },[cart])

    const reduction = id => {
        cart.forEach(item =>{
            if(item.productId === id){
                item.productCount === 1 ? item.productCount = 1 : item.productCount -= 1;
            }
        })
        setCart([...cart])
    }
    const increase = id => {
        cart.forEach(item => {
            if(item.productId === id){
                item.productCount += 1 ;
            }
        })
        setCart([...cart])
    }

    const removeProduct = id => {
            cart.forEach((item, index) => {
                if(item.productId === id){
                    cart.splice(index, 1)
                    ProductService.removeItemFromCart(item);
                }
            })
            setCart([...cart])
        }
    

    if(cart.length === 0)
        return <h2 style={{textAlign: "center", fontSize: "25px", paddingBottom: "20px", color: "#555"}}>Cart is Empty</h2>

    return (
        <>
           {
               cart.map(product =>(
                   <div className="details cart" key={product.productId}>
                       <div className="img-container" 
                       style={{backgroundImage: `url(${product.productImageLink})`}} />

                       <div className="box-details">
                           <h2 title={product.productTitle}>{product.productTitle}</h2>
                           <h3 style ={{marginTop: "10px"}}>${product.productPrice}</h3>
                           <p>{product.productDescription}</p>
                           <p>{product.productContent}</p>
                           
                           <div className="amount">
                               <button className="count" onClick={() => reduction(product.productId)}> - </button>
                               <span>{product.productCount}</span>
                               <button className="count" onClick={() => increase(product.productId)}> + </button>
                           </div>

                           <div className="delete" onClick={() => removeProduct(product.productId)}>X</div>
                       </div>

                   </div>
               ))
           }

           <div className="total">
               <Link to="/payment">Payment</Link>
               <h3>Total: ${total}</h3>
           </div>
        </>
    )
}
