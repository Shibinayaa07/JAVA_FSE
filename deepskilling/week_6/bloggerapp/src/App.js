import React, { useState } from 'react';
import BookDetails from './BookDetails';
import BlogDetails from './BlogDetails';
import CourseDetails from './CourseDetails';

function App() {
  const [selectedTab, setSelectedTab] = useState('book');
  const [showBlog, setShowBlog] = useState(false);
  const [selectedSelect, setSelectedSelect] = useState('book');

  const renderBySwitch = (val) => {
    switch (val) {
      case 'book': return <BookDetails />;
      case 'blog': return <BlogDetails />;
      case 'course': return <CourseDetails />;
      default: return null;
    }
  };

  return (
    <div style={{ padding: '20px', fontFamily: 'Arial, sans-serif' }}>
      <h2>Blogger Application</h2>

      <div style={{ border: '1px solid #ccc', padding: '15px', margin: '15px 0', borderRadius: '6px' }}>
        <h3>Way 1: Tabs (Element Variables Conditional Rendering)</h3>
        <button onClick={() => setSelectedTab('book')}>Book Details</button>
        <button onClick={() => setSelectedTab('blog')} style={{ marginLeft: '10px' }}>Blog Details</button>
        <button onClick={() => setSelectedTab('course')} style={{ marginLeft: '10px' }}>Course Details</button>
        
        {selectedTab === 'book' && <BookDetails />}
        {selectedTab === 'blog' && <BlogDetails />}
        {selectedTab === 'course' && <CourseDetails />}
      </div>

      <div style={{ border: '1px solid #ccc', padding: '15px', margin: '15px 0', borderRadius: '6px' }}>
        <h3>Way 2: Toggle Visibility (Logical && Operator)</h3>
        <button onClick={() => setShowBlog(!showBlog)}>
          {showBlog ? "Hide Blog Details" : "Show Blog Details"}
        </button>
        {showBlog && <BlogDetails />}
      </div>

      <div style={{ border: '1px solid #ccc', padding: '15px', margin: '15px 0', borderRadius: '6px' }}>
        <h3>Way 3: Dropdown Switch-case Rendering</h3>
        <select value={selectedSelect} onChange={(e) => setSelectedSelect(e.target.value)} style={{ padding: '6px' }}>
          <option value="book">Book</option>
          <option value="blog">Blog</option>
          <option value="course">Course</option>
        </select>
        {renderBySwitch(selectedSelect)}
      </div>
    </div>
  );
}

export default App;