import React from 'react'
import Middle from './Middle';
import Left from './Left';
import Right from './Right';
import Header from './Header';
import "./MainPage.css";
export default function 
() {
  return (
    <div>
        <Header />
    <main>
       <div className='container'>
          <Left />
          <Middle />
          <Right />
       </div>
    </main>
    </div>
    
  )
}
