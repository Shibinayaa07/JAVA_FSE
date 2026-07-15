import React, { useState } from 'react';
import ThemeContext from './ThemeContext';
import EmployeesList from './EmployeesList';

function App() {
  const [theme, setTheme] = useState('light');
  const employees = [
    { id: 1, name: "Alice Smith", role: "Software Engineer" },
    { id: 2, name: "Bob Johnson", role: "Product Manager" },
    { id: 3, name: "Charlie Brown", role: "UX Designer" }
  ];

  return (
    <ThemeContext.Provider value={theme}>
      <div style={{ 
        padding: '20px', 
        minHeight: '100vh', 
        backgroundColor: theme === 'dark' ? '#121212' : '#f9f9f9',
        color: theme === 'dark' ? '#ffffff' : '#000000',
        fontFamily: 'Arial, sans-serif'
      }}>
        <h2>Employee Management Portal</h2>
        <button 
          onClick={() => setTheme(theme === 'light' ? 'dark' : 'light')}
          style={{ padding: '8px 15px', cursor: 'pointer' }}
        >
          Toggle Theme to {theme === 'light' ? 'Dark' : 'Light'}
        </button>
        <EmployeesList employees={employees} />
      </div>
    </ThemeContext.Provider>
  );
}

export default App;