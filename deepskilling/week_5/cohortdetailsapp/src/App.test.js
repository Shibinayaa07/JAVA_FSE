import React from 'react';
import { shallow } from 'enzyme';
import App from './App';

test('renders cohort dashboard title', () => {
  const wrapper = shallow(<App />);
  expect(wrapper.find('h1').text()).toBe('Cohort Dashboard');
});
