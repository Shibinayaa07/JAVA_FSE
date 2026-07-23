import axios from 'axios';
import GitClient from './GitClient';

jest.mock('axios');

describe('Git Client Tests', () => {
  test('should return repository names for techiesyed', async () => {
    const dummyData = {
      data: [
        { name: 'repo-one' },
        { name: 'repo-two' },
        { name: 'repo-three' }
      ]
    };
    
    axios.get.mockResolvedValue(dummyData);

    const repos = await GitClient.getRepositories('techiesyed');
    
    expect(repos).toEqual(['repo-one', 'repo-two', 'repo-three']);
    expect(axios.get).toHaveBeenCalledWith('https://api.github.com/users/techiesyed/repos');
  });
});