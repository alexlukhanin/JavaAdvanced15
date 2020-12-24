package org.alex;

import org.alex.model.Comment;
import org.alex.model.Post;
import org.alex.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class App {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        System.out.println("-------------------------------------------------");
        System.out.println("Java Advanced - Lesson 15 - Homework: ");
        System.out.println("[application started at " + new Date().toString() + " successfully till this line...]" ); // just for fun!!!
        System.out.println(":) :) :)");  // just for fun!!!


        Post post = new Post();
        post.setTitle("New post with interesting title!");

        Comment comment1 = new Comment();
        comment1.setAuthorName("Nick Hartman");
        comment1.setPost(post);

        Comment comment2 = new Comment();
        comment2.setAuthorName("Dart Weider");
        comment2.setPost(post);

        Set<Comment> comments1 = new HashSet<>();
        comments1.add(comment1);
        comments1.add(comment2);
        post.setComments(comments1);

        Post post1 = new Post();
        post1.setTitle("Corona virus post info");

        Comment comment3 = new Comment();
        comment3.setAuthorName("Frank Sinatra III");
        comment3.setPost(post1);

        Comment comment4 = new Comment();
        comment4.setAuthorName("Stiven Burger");
        comment4.setPost(post1);

        Set<Comment> comments2 = new HashSet<>();
        comments2.add(comment3);
        comments2.add(comment4);
        post1.setComments(comments2);


        // save to DB
        Transaction transaction = session.beginTransaction();
        session.save(post);
        session.save(post1);
        transaction.commit();

        // read from DB
        System.out.println("Post #1");
        Post postFromDB = (Post) session.get(Post.class, 1);
        System.out.println( postFromDB + " ---> " + postFromDB.getComments() );

        System.out.println("Post #2");
        Post postFromDB2 = (Post) session.get(Post.class, 2);
        System.out.println( postFromDB2 + " ---> " + postFromDB.getComments() );
        System.out.println("Comment #1");
        Comment commentFromDB1 = (Comment) session.get(Comment.class, 1);
        System.out.println(commentFromDB1 + "--->" + commentFromDB1.getPost());
        System.out.println("Comment #2");
        Comment commentFromDB2 = (Comment) session.get(Comment.class, 2);
        System.out.println(commentFromDB2 + "--->" + commentFromDB2.getPost());
        System.out.println("Comment #3");
        Comment commentFromDB3 = (Comment) session.get(Comment.class, 3);
        System.out.println(commentFromDB3 + "--->" + commentFromDB3.getPost());
        System.out.println("Comment #4");
        Comment commentFromDB4 = (Comment) session.get(Comment.class, 4);
        System.out.println(commentFromDB4 + "--->" + commentFromDB4.getPost());




    }
}
