import React from 'react';
import { Link } from 'react-router-dom';

function TrainersList({ trainersList }) {
  return (
    <div>
      <h2>Trainers List</h2>
      <ul>
        {trainersList.map(t => (
          <li key={t.TrainerId} style={{ margin: '10px 0' }}>
            <Link to={`/trainers/${t.TrainerId}`} style={{ fontSize: '18px', textDecoration: 'none', color: '#007bff' }}>
              {t.Name}
            </Link>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default TrainersList;