import java.util.ArrayList;

public class PostList {
    private ArrayList<Post> posts;

    public PostList() {
        posts = new ArrayList<>();
    }

    public void addPost(Post post) {
        posts.add(post);
    }

    public ArrayList<Post> getPosts() {

        return posts;
    }

    //make method to show all post
    public void showAllPost(){
        for(Post post : posts){
            System.out.println(post.getCaption());
            System.out.println(post.getUrl());
            System.out.println(post.getUsername());
        }
    }

    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }

    public Post getPost(int index) {
        return posts.get(index);
    }

    public int getSize() {
        return posts.size();
    }


}
