import React from 'react';

class Post{
    constructor(id,title,body){
        this.id = id;
        this.title = title;
        this.body = body;
    }
}

class Posts extends React.Component{
    constructor(props){
        super(props);
        this.state = {
            posts: []
        };
        this.loadPosts = this.loadPosts.bind(this);
    }
    loadPosts(){
        fetch('https://jsonplaceholder.typicode.com/posts')
        .then(response => response.json())
        .then(data => {
            const posts = data.map(post => new Post(post.id, post.title, post.body));
            this.setState({posts: posts});
        });
    }
    componentDidMount(){
        this.loadPosts();

    }
    render(){
        return(
            <div>
                <h1>Posts</h1>
                <ul>
                    {this.state.posts.map(post => ( 
                        <li key={post.id}>
                            <h2>{post.title}</h2>
                            <p>{post.body}</p>
                        </li>
                    ))}
                </ul>
            </div>
        )
    }
    componentDidCatch(error, info){
        alert(`Error occurred: ${error}`);
        console.log("Error occurred: ", error);
        console.log("Error info: ", info);
    }
}

export default Posts;
