import React from 'react';

function IndianPlayers() {
  const players = [
    "Virat Kohli", "Rohit Sharma", "KL Rahul", "Shubman Gill", 
    "Shreyas Iyer", "Hardik Pandya", "Ravindra Jadeja", "Rishabh Pant", 
    "Jasprit Bumrah", "Mohammed Shami", "Kuldeep Yadav"
  ];

  // Destructuring Odd and Even team players
  const [p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11] = players;
  const oddTeam = [p1, p3, p5, p7, p9, p11];
  const evenTeam = [p2, p4, p6, p8, p10];

  const T20players = ["Hardik Pandya", "Suryakumar Yadav", "Ishan Kishan"];
  const RanjiTrophyPlayers = ["Cheteshwar Pujara", "Ajinkya Rahane", "Hanuma Vihari"];
  
  // Merging arrays using Spread
  const mergedPlayers = [...T20players, ...RanjiTrophyPlayers];

  return (
    <div style={{ padding: '10px' }}>
      <h3>Odd Team Players</h3>
      <ul>
        {oddTeam.map((p, index) => <li key={index}>{p}</li>)}
      </ul>
      <h3>Even Team Players</h3>
      <ul>
        {evenTeam.map((p, index) => <li key={index}>{p}</li>)}
      </ul>
      <h3>Merged T20 and Ranji Players</h3>
      <ul>
        {mergedPlayers.map((p, index) => <li key={index}>{p}</li>)}
      </ul>
    </div>
  );
}

export default IndianPlayers;