import React, { useState } from 'react';

function Register() {
  const [formData, setFormData] = useState({ name: '', email: '', password: '' });
  const [errors, setErrors] = useState({});
  const [isSuccess, setIsSuccess] = useState(false);

  const validate = (name, value) => {
    let errorMsg = '';
    if (name === 'name') {
      if (value.trim().length < 5) {
        errorMsg = 'Name should have at least 5 characters.';
      }
    } else if (name === 'email') {
      if (!value.includes('@') || !value.includes('.')) {
        errorMsg = 'Email should contain @ and .';
      }
    } else if (name === 'password') {
      if (value.length < 8) {
        errorMsg = 'Password should have at least 8 characters.';
      }
    }
    return errorMsg;
  };

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
    const err = validate(name, value);
    setErrors(prev => ({ ...prev, [name]: err }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    const nameErr = validate('name', formData.name);
    const emailErr = validate('email', formData.email);
    const passErr = validate('password', formData.password);

    if (nameErr || emailErr || passErr) {
      setErrors({ name: nameErr, email: emailErr, password: passErr });
      setIsSuccess(false);
    } else {
      setErrors({});
      setIsSuccess(true);
      alert('Form registered successfully!');
    }
  };

  return (
    <div style={{ maxWidth: '400px', margin: '20px auto', padding: '20px', border: '1px solid #ccc', borderRadius: '8px' }}>
      <h3>Mail Registration</h3>
      <form onSubmit={handleSubmit}>
        <div style={{ marginBottom: '15px' }}>
          <label style={{ display: 'block', marginBottom: '5px' }}>Name:</label>
          <input 
            type="text" 
            name="name" 
            value={formData.name} 
            onChange={handleChange}
            style={{ width: '100%', padding: '8px', boxSizing: 'border-box' }}
          />
          {errors.name && <span style={{ color: 'red', fontSize: '12px' }}>{errors.name}</span>}
        </div>

        <div style={{ marginBottom: '15px' }}>
          <label style={{ display: 'block', marginBottom: '5px' }}>Email:</label>
          <input 
            type="text" 
            name="email" 
            value={formData.email} 
            onChange={handleChange}
            style={{ width: '100%', padding: '8px', boxSizing: 'border-box' }}
          />
          {errors.email && <span style={{ color: 'red', fontSize: '12px' }}>{errors.email}</span>}
        </div>

        <div style={{ marginBottom: '15px' }}>
          <label style={{ display: 'block', marginBottom: '5px' }}>Password:</label>
          <input 
            type="password" 
            name="password" 
            value={formData.password} 
            onChange={handleChange}
            style={{ width: '100%', padding: '8px', boxSizing: 'border-box' }}
          />
          {errors.password && <span style={{ color: 'red', fontSize: '12px' }}>{errors.password}</span>}
        </div>

        <button 
          type="submit" 
          style={{ 
            width: '100%', 
            padding: '10px', 
            background: '#28a745', 
            color: '#fff', 
            border: 'none', 
            borderRadius: '4px', 
            cursor: 'pointer' 
          }}
        >
          Register
        </button>
      </form>
      {isSuccess && <p style={{ color: 'green', marginTop: '10px', fontWeight: 'bold' }}>Registration Complete!</p>}
    </div>
  );
}

export default Register;