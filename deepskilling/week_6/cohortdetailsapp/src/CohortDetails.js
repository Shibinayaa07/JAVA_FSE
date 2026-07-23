import React from 'react';
import styles from './CohortDetails.module.css';

function CohortDetails({ cohort }) {
  if (!cohort) return null;
  const isOngoing = cohort.status === 'ongoing';
  const h3Style = {
    color: isOngoing ? 'green' : 'blue'
  };

  return (
    <div className={styles.box}>
      <h3 style={h3Style}>{cohort.code}</h3>
      <dl>
        <dt>Status</dt>
        <dd>{cohort.status}</dd>
        <dt>Start Date</dt>
        <dd>{cohort.startDate}</dd>
        <dt>End Date</dt>
        <dd>{cohort.endDate}</dd>
        <dt>Course</dt>
        <dd>{cohort.course}</dd>
      </dl>
    </div>
  );
}

export default CohortDetails;