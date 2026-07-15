import React from 'react';
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
import Home from './Home';
import TrainersList from './Trainerlist';
import TrainerDetails from './TrainerDetails';
import { trainers } from './TrainersMock';

function App() {
  return (
    <Router>
      <div style={{ padding: '20px', fontFamily: 'Arial, sans-serif' }}>
        <nav style={{ marginBottom: '20px', borderBottom: '1px solid #ccc', paddingBottom: '10px' }}>
          <Link to="/" style={{ marginRight: '15px', textDecoration: 'none', color: '#333', fontWeight: 'bold' }}>Home</Link>
          <Link to="/trainers" style={{ textDecoration: 'none', color: '#333', fontWeight: 'bold' }}>Trainers</Link>
        </nav>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/trainers" element={<TrainersList trainersList={trainers} />} />
          <Route path="/trainers/:id" element={<TrainerDetails />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;