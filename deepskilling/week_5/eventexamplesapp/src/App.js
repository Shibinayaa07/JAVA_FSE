import React from 'react';
import CurrencyConvertor from './CurrencyConvertor';

class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      counter: 0
    };
  }

  increment = () => {
    this.setState(prev => ({ counter: prev.counter + 1 }));
  };

  sayHello = () => {
    alert("Hello! This is a static welcome message.");
  };

  handleIncrement = () => {
    this.increment();
    this.sayHello();
  };

  decrement = () => {
    this.setState(prev => ({ counter: prev.counter - 1 }));
  };

  sayWelcome = (msg) => {
    alert(`Greeting: ${msg}`);
  };

  handleSyntheticClick = (e) => {
    alert(`Synthetic Event Type: ${e.type}. Display: "I was clicked"`);
  };

  render() {
    return (
      <div style={{ padding: '20px', fontFamily: 'Arial, sans-serif' }}>
        <h2>Event Examples Application</h2>
        
        <div style={{ border: '1px solid #ddd', padding: '15px', borderRadius: '5px', marginBottom: '15px', maxWidth: '400px' }}>
          <h3>Counter: {this.state.counter}</h3>
          <button onClick={this.handleIncrement} style={{ padding: '6px 12px' }}>Increment (Multi-method)</button>
          <button onClick={this.decrement} style={{ padding: '6px 12px', marginLeft: '10px' }}>Decrement</button>
        </div>

        <div style={{ marginBottom: '15px' }}>
          <button onClick={() => this.sayWelcome("welcome")} style={{ padding: '8px 15px' }}>Say Welcome</button>
        </div>

        <div style={{ marginBottom: '15px' }}>
          <button onClick={this.handleSyntheticClick} style={{ padding: '8px 15px' }}>Test Synthetic Event</button>
        </div>

        <CurrencyConvertor />
      </div>
    );
  }
}

export default App;