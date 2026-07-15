import React from 'react';

function App() {
  const headingText = "Office Space Rental Portal";
  const offices = [
    { Name: "Premium Office Suite", Rent: 75000, Address: "Downtown Plaza, Suite 400", Image: "https://images.unsplash.com/photo-1497366216548-37526070297c?auto=format&fit=crop&w=300&q=80" },
    { Name: "Shared Coworking Desk", Rent: 15000, Address: "Main Street Hub, Floor 2", Image: "https://images.unsplash.com/photo-1527192491265-7e15c55b1ed2?auto=format&fit=crop&w=300&q=80" },
    { Name: "Executive Private Room", Rent: 55000, Address: "Business District, Tower B", Image: "https://images.unsplash.com/photo-1497215728101-856f4ea42174?auto=format&fit=crop&w=300&q=80" },
    { Name: "Corporate Wing", Rent: 120000, Address: "Financial Center, Building A", Image: "https://images.unsplash.com/photo-1497366811353-6870744d04b2?auto=format&fit=crop&w=300&q=80" }
  ];

  return (
    <div style={{ padding: '20px', fontFamily: 'Arial, sans-serif' }}>
      <h1>{headingText}</h1>
      <div style={{ display: 'flex', flexWrap: 'wrap', gap: '20px', marginTop: '20px' }}>
        {offices.map((office, index) => (
          <div key={index} style={{ border: '1px solid #ccc', padding: '15px', borderRadius: '8px', width: '280px' }}>
            <img 
              src={office.Image} 
              alt={office.Name} 
              style={{ width: '100%', height: '160px', objectFit: 'cover', borderRadius: '4px', marginBottom: '10px' }} 
            />
            <h3>{office.Name}</h3>
            <p><strong>Address:</strong> {office.Address}</p>
            <p>
              <strong>Rent:</strong>{' '}
              <span style={{ color: office.Rent < 60000 ? 'red' : 'green', fontWeight: 'bold' }}>
                Rs. {office.Rent}/month
              </span>
            </p>
          </div>
        ))}
      </div>
    </div>
  );
}

export default App;