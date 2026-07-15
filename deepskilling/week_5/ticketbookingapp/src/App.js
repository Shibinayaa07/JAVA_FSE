import React, { useState } from 'react';

function GuestPage() {
  const flights = [
    { id: 1, number: "AI-101", route: "Delhi to Mumbai", time: "10:00 AM" },
    { id: 2, number: "6E-502", route: "Bangalore to Chennai", time: "02:30 PM" },
    { id: 3, number: "UK-808", route: "Kolkata to Pune", time: "06:15 PM" }
  ];
  return (
    <div>
      <h3>Available Flight Details (Guest Mode)</h3>
      <table style={{ width: '80%', borderCollapse: 'collapse', textAlign: 'left', marginTop: '15px' }}>
        <thead>
          <tr style={{ backgroundColor: '#f2f2f2' }}>
            <th style={{ padding: '8px', border: '1px solid #ddd' }}>Flight Number</th>
            <th style={{ padding: '8px', border: '1px solid #ddd' }}>Route</th>
            <th style={{ padding: '8px', border: '1px solid #ddd' }}>Time</th>
          </tr>
        </thead>
        <tbody>
          {flights.map(f => (
            <tr key={f.id}>
              <td style={{ padding: '8px', border: '1px solid #ddd' }}>{f.number}</td>
              <td style={{ padding: '8px', border: '1px solid #ddd' }}>{f.route}</td>
              <td style={{ padding: '8px', border: '1px solid #ddd' }}>{f.time}</td>
            </tr>
          ))}
        </tbody>
      </table>
      <p style={{ color: '#888', marginTop: '10px' }}>Please log in to book tickets.</p>
    </div>
  );
}

function UserPage() {
  const [success, setSuccess] = useState(false);
  return (
    <div>
      <h3>Welcome Registered User!</h3>
      <p>Select your flight to book a ticket:</p>
      <button 
        onClick={() => setSuccess(true)} 
        style={{ padding: '8px 15px', background: '#28a745', color: '#fff', border: 'none', borderRadius: '4px', cursor: 'pointer' }}
      >
        Book Ticket: AI-101 (Delhi to Mumbai)
      </button>
      {success && (
        <p style={{ color: 'green', fontWeight: 'bold', marginTop: '10px' }}>
          Ticket Booked Successfully! Confirmation sent.
        </p>
      )}
    </div>
  );
}

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  return (
    <div style={{ padding: '20px', fontFamily: 'Arial, sans-serif' }}>
      <h2>Flight Ticket Booking Portal</h2>
      <div style={{ marginBottom: '20px' }}>
        {isLoggedIn ? (
          <button onClick={() => setIsLoggedIn(false)} style={{ padding: '8px 15px' }}>Logout</button>
        ) : (
          <button onClick={() => setIsLoggedIn(true)} style={{ padding: '8px 15px' }}>Login</button>
        )}
      </div>
      <hr style={{ margin: '20px 0' }} />
      {isLoggedIn ? <UserPage /> : <GuestPage />}
    </div>
  );
}

export default App;