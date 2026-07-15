import React from 'react';
import { mount, shallow } from 'enzyme';
import CohortDetails from './CohortDetails';
import { CohortData } from './Cohort';

describe('Cohort Details Component', () => {
  test('should create the component', () => {
    const wrapper = shallow(<CohortDetails cohort={CohortData[0]} />);
    expect(wrapper.exists()).toBe(true);
  });

  test('should initialize the props', () => {
    const cohortObj = CohortData[0];
    const wrapper = mount(<CohortDetails cohort={cohortObj} />);
    expect(wrapper.props().cohort).toEqual(cohortObj);
  });

  test('should display cohort code in h3', () => {
    const cohortObj = CohortData[0];
    const wrapper = mount(<CohortDetails cohort={cohortObj} />);
    const h3Text = wrapper.find('h3').text();
    expect(h3Text).toBe(cohortObj.code);
  });

  test('should always render same html', () => {
    const wrapper = shallow(<CohortDetails cohort={CohortData[0]} />);
    expect(wrapper).toMatchSnapshot();
  });
});