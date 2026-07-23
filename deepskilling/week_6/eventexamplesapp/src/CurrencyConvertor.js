import React, { useState } from 'react';

function CurrencyConvertor() {
  const [inr, setInr] = useState('');
  const [euro, setEuro] = useState(0);

  const handleSubmit = (e) => {
    e.preventDefault();
    // Exchange rate: 1 EUR = 90 INR
    const conversion = parseFloat(inr) / 90;
    setEuro(conversion.toFixed(2));
  };

  return (
    <div style={{ border: '1px solid #ccc', padding: '20px', marginTop: '25px', borderRadius: '6px', maxWidth: '400px' }}>
      <h3>Currency Convertor</h3>
      <form onSubmit={handleSubmit}>
        <div style={{ marginBottom: '10px' }}>
          <label style={{ display: 'block', marginBottom: '5px' }}>Indian Rupees (INR):</label>
          <input 
            type="number" 
            value={inr} 
            onChange={(e) => setInr(e.target.value)} 
            required 
            style={{ width: '100%', padding: '8px', boxSizing: 'border-box' }}
          />
        </div>
        <button type="submit" style={{ padding: '8px 15px', background: '#007bff', color: '#fff', border: 'none', borderRadius: '4px' }}>
          Convert
        </button>
      </form>
      <p style={{ marginTop: '15px', fontSize: '18px' }}>
        <strong>Euro (EUR):</strong> € {euro}
      </p>
    </div>
  );
}

export default CurrencyConvertor;