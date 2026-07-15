import React from 'react';

function ListofPlayers() {
  const players = [
    { name: "Virat Kohli", score: 98 },
    { name: "Rohit Sharma", score: 85 },
    { name: "KL Rahul", score: 45 },
    { name: "Shubman Gill", score: 110 },
    { name: "Shreyas Iyer", score: 30 },
    { name: "Hardik Pandya", score: 72 },
    { name: "Ravindra Jadeja", score: 65 },
    { name: "Rishabh Pant", score: 80 },
    { name: "Jasprit Bumrah", score: 12 },
    { name: "Mohammed Shami", score: 8 },
    { name: "Kuldeep Yadav", score: 5 }
  ];

  const filteredPlayers = players.filter(p => p.score >= 70);

  return (
    <div style={{ padding: '10px' }}>
      <h3>All Players List</h3>
      <ul>
        {players.map((p, index) => (
          <li key={index}>{p.name} - {p.score}</li>
        ))}
      </ul>
      <h3>Players Scoring 70 and Above</h3>
      <ul>
        {filteredPlayers.map((p, index) => (
          <li key={index}>{p.name} - {p.score}</li>
        ))}
      </ul>
    </div>
  );
}

export default ListofPlayers;