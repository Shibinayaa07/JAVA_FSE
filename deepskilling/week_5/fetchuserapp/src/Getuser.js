import React from 'react';

class Getuser extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      user: null,
      loading: true,
      error: null
    };
  }

  async componentDidMount() {
    try {
      const response = await fetch('https://api.randomuser.me/');
      if (!response.ok) {
        throw new Error('Network response was not ok');
      }
      const data = await response.json();
      this.setState({
        user: data.results[0],
        loading: false
      });
    } catch (err) {
      this.setState({
        error: err.message,
        loading: false
      });
    }
  }

  render() {
    const { user, loading, error } = this.state;

    if (loading) return <p style={{ textAlign: 'center' }}>Loading user details...</p>;
    if (error) return <p style={{ textAlign: 'center', color: 'red' }}>Error: {error}</p>;
    if (!user) return null;

    const { title, first, last } = user.name;
    const { large } = user.picture;

    return (
      <div style={{ 
        border: '1px solid #ccc', 
        padding: '20px', 
        borderRadius: '8px', 
        width: '260px', 
        margin: '20px auto', 
        textAlign: 'center',
        boxShadow: '0 4px 8px rgba(0,0,0,0.1)'
      }}>
        <img 
          src={large} 
          alt={first} 
          style={{ borderRadius: '50%', marginBottom: '15px', border: '2px solid #007bff' }} 
        />
        <h2>{title} {first} {last}</h2>
        <p style={{ color: '#666' }}>Email: {user.email}</p>
        <p style={{ color: '#666' }}>Phone: {user.phone}</p>
      </div>
    );
  }
}

export default Getuser;