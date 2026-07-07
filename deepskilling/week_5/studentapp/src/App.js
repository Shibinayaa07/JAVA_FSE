import logo from './logo.svg';
import './App.css';
import Home from './Component/Home';
import About from './Component/About';
import Contact from './Component/Contact';

function App() {
  return (
    <div className="container" style = {{alignItems:'center',textAlign:'center'}}>
      <Home/>
      <About/>
      <Contact/>
    </div>
  );
}

export default App;
