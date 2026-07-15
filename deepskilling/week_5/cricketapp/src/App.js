import React, { useState } from 'react';
import ListofPlayers from './ListofPlayers';
import IndianPlayers from './IndianPlayers';

function App() {
  const [flag, setFlag] = useState(true);

  return (
    <div style={{ padding: '20px', fontFamily: 'Arial, sans-serif' }}>
      <h2>Cricket Application</h2>
      <button onClick={() => setFlag(!flag)} style={{ padding: '8px 15px', marginBottom: '20px' }}>
        Toggle Flag (Current: {flag.toString()})
      </button>
      {flag ? <ListofPlayers /> : <IndianPlayers />}
    </div>
  );
}

export default App;