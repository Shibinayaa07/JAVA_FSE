import React from 'react';

class Cart extends React.Component {
  render() {
    return (
      <tr>
        <td style={{ padding: '8px', border: '1px solid #ddd' }}>{this.props.Itemname}</td>
        <td style={{ padding: '8px', border: '1px solid #ddd' }}>Rs. {this.props.Price}</td>
      </tr>
    );
  }
}

export default Cart;