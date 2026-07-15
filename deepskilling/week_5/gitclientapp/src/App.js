import React, { useState } from 'react';
import GitClient from './GitClient';

function App() {
  const [username, setUsername] = useState('techiesyed');
  const [repos, setRepos] = useState([]);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);

  const fetchRepos = async () => {
    setLoading(true);
    setError(null);
    try {
      const names = await GitClient.getRepositories(username);
      setRepos(names);
    } catch (err) {
      setError(err.message);
    } finally {
      setLoading(false);
    }
  };

  return (
    <div style={{ padding: '20px', fontFamily: 'Arial, sans-serif' }}>
      <h2>Git Client Repository List</h2>
      <div style={{ marginBottom: '15px' }}>
        <input 
          type="text" 
          value={username} 
          onChange={(e) => setUsername(e.target.value)} 
          style={{ padding: '8px', width: '200px' }} 
        />
        <button onClick={fetchRepos} style={{ padding: '8px 15px', marginLeft: '10px' }}>
          Fetch Repositories
        </button>
      </div>

      {loading && <p>Loading repositories...</p>}
      {error && <p style={{ color: 'red' }}>Error: {error}</p>}
      
      <ul style={{ marginTop: '15px' }}>
        {repos.map((name, index) => (
          <li key={index}>{name}</li>
        ))}
      </ul>
    </div>
  );
}

export default App;