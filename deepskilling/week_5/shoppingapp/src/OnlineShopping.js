import React from 'react';
import Cart from './Cart';

class OnlineShopping extends React.Component {
  render() {
    const items = [
      { Itemname: "Laptop", Price: 55000 },
      { Itemname: "Smartphone", Price: 25000 },
      { Itemname: "Bluetooth Headphones", Price: 3500 },
      { Itemname: "Wireless Mouse", Price: 1200 },
      { Itemname: "Mechanical Keyboard", Price: 4500 }
    ];

    return (
      <div style={{ padding: '20px', fontFamily: 'Arial, sans-serif' }}>
        <h2>Online Shopping</h2>
        <table style={{ width: '50%', borderCollapse: 'collapse', textAlign: 'left' }}>
          <thead>
            <tr style={{ backgroundColor: '#f2f2f2' }}>
              <th style={{ padding: '8px', border: '1px solid #ddd' }}>Item Name</th>
              <th style={{ padding: '8px', border: '1px solid #ddd' }}>Price</th>
            </tr>
          </thead>
          <tbody>
            {items.map((item, index) => (
              <Cart key={index} Itemname={item.Itemname} Price={item.Price} />
            ))}
          </tbody>
        </table>
      </div>
    );
  }
}

export default OnlineShopping;