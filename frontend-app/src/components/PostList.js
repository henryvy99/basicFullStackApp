import React, { Component } from 'react';
import axios from 'axios'

class PostList extends Component{
    constructor(props){
        super(props)

        this.state = {
            posts: [],
            errorMsg: ""
        }
    }

    componentDidMount(){
        axios.get('http://localhost:8080/api/v2/blog')
            .then(response => {
                console.log(response)
                // assign the response data to the posts variable 
                this.setState({posts: response.data})
            })
            .catch(error => {
                console.log(error)
                this.setState({errorMsg: 'Error retrieving data'})
            })
    }

    render(){
        const { posts, errorMsg } = this.state // response data
        return (
            <div>
                List of blogs
                {
                    posts.length ?
                        posts.map(post => 
                            <div key={post.id}>{post.title}</div>
                            ) :
                        null
                }

                {errorMsg ? 
                    <div>{errorMsg}</div> :
                    null}
            </div>
        )
    }
}

export default PostList