import React,{useContext, useState, useRef} from 'react'
import {useParams} from 'react-router-dom'
import {DataContext} from './DataProvider'
import DetailsThumb from './DetailsThumb'
import {Link} from 'react-router-dom'

export default function Details() {
    const {id} = useParams();
    const value = useContext(DataContext)
    const [products] = value.products
    const addCart = value.addCart
    
    const [setIndex] = useState(0)
    const imgDiv = useRef();


    const details = products.filter((product, index) => {
        return product.productId === id
    })

    const handleMouseMove = e =>{
        const {left, top, width, height} = e.target.getBoundingClientRect();
        const x = (e.pageX - left) / width * 100
        const y = (e.pageY - top) / height * 100
        imgDiv.current.style.backgroundPosition = `${x}% ${y}%`
    }


    return (
        <>
           {
               details.map(product =>(
                   <div className="details" key={product.productId}>
                       <div className="img-container" onMouseMove={handleMouseMove}
                       style={{backgroundImage: `url(${product.productImageLink})`}} ref={imgDiv} 
                       onMouseLeave={() => imgDiv.current.style.backgroundPosition = `center`} />

                       <div className="box-details">
                           <h2 title={product.productTitle}>{product.productTitle}</h2>
                           <h3>${product.productPrice}</h3>
                           <p>{product.productDescription}</p>
                           <p>{product.productContent}</p>
                           <DetailsThumb images={product.productImageLink} setIndex={setIndex} />
                           <Link to="/cart" className="cart" onClick={() => addCart(product.productId)}>
                               Add to cart
                            </Link>
                       </div>

                   </div>
               ))
           }
        </>
    )
}
