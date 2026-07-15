import React from 'react';
import { useParams, Link } from 'react-router-dom';
import { trainers } from './TrainersMock';

function TrainerDetails() {
  const { id } = useParams();
  const trainer = trainers.find(t => t.TrainerId.toString() === id);

  if (!trainer) {
    return (
      <div>
        <h3>Trainer Not Found</h3>
        <Link to="/trainers">Back to Trainers List</Link>
      </div>
    );
  }

  return (
    <div style={{ border: '1px solid #ccc', padding: '20px', borderRadius: '8px', maxWidth: '400px' }}>
      <h3>Trainer Details: {trainer.Name}</h3>
      <p><strong>T-ID:</strong> {trainer.TrainerId}</p>
      <p><strong>Email:</strong> {trainer.Email}</p>
      <p><strong>Phone:</strong> {trainer.Phone}</p>
      <p><strong>Technology:</strong> {trainer.Technology}</p>
      <p><strong>Skills:</strong> {trainer.Skills.join(', ')}</p>
      <Link to="/trainers" style={{ display: 'inline-block', marginTop: '15px' }}>Back to Trainers List</Link>
    </div>
  );
}

export default TrainerDetails;