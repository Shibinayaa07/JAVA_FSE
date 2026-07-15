import React, { useContext } from 'react';
import ThemeContext from './ThemeContext';

function EmployeeCard({ employee }) {
  const theme = useContext(ThemeContext);
  
  const isDark = theme === 'dark';
  const cardStyle = {
    border: '1px solid #ccc',
    padding: '15px',
    margin: '10px',
    borderRadius: '6px',
    width: '200px',
    backgroundColor: isDark ? '#333' : '#fff',
    color: isDark ? '#fff' : '#000',
    transition: 'background-color 0.3s ease'
  };

  const buttonStyle = {
    padding: '6px 12px',
    backgroundColor: isDark ? '#fff' : '#000',
    color: isDark ? '#000' : '#fff',
    border: 'none',
    borderRadius: '4px',
    cursor: 'pointer',
    marginTop: '10px'
  };

  return (
    <div style={cardStyle}>
      <h4>{employee.name}</h4>
      <p>Role: {employee.role}</p>
      <button style={buttonStyle}>View Details</button>
    </div>
  );
}

export default EmployeeCard;