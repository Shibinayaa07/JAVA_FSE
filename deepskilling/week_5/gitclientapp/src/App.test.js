import { render, screen } from '@testing-library/react';
import App from './App';

test('renders git client repository list title', () => {
  render(<App />);
  const titleElement = screen.getByText(/Git Client Repository List/i);
  expect(titleElement).toBeInTheDocument();
});
