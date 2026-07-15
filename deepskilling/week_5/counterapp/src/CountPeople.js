import React from 'react';

class CountPeople extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      entrycount: 0,
      exitcount: 0
    };
    // Binding methods
    this.UpdateEntry = this.UpdateEntry.bind(this);
    this.UpdateExit = this.UpdateExit.bind(this);
  }

  UpdateEntry() {
    this.setState(prevState => ({
      entrycount: prevState.entrycount + 1
    }));
  }

  UpdateExit() {
    this.setState(prevState => ({
      exitcount: prevState.exitcount + 1
    }));
  }

  render() {
    return (
      <div style={{ padding: '20px', fontFamily: 'Arial, sans-serif', textAlign: 'center' }}>
        <h2>People Counter</h2>
        <div style={{ display: 'inline-block', margin: '20px', border: '1px solid #ccc', padding: '20px', borderRadius: '8px' }}>
          <div style={{ margin: '15px' }}>
            <button onClick={this.UpdateEntry} style={{ padding: '8px 15px', fontSize: '16px' }}>Login (Enter)</button>
            <p style={{ fontSize: '18px', marginTop: '10px' }}>Entry Count: <strong>{this.state.entrycount}</strong></p>
          </div>
          <div style={{ margin: '15px' }}>
            <button onClick={this.UpdateExit} style={{ padding: '8px 15px', fontSize: '16px' }}>Exit</button>
            <p style={{ fontSize: '18px', marginTop: '10px' }}>Exit Count: <strong>{this.state.exitcount}</strong></p>
          </div>
        </div>
      </div>
    );
  }
}

export default CountPeople;