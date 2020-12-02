package com.greenfox.datastructure;

public class BlogPostMain {
    public static void main(String[] args) {
        BlogPost loremIpsum = new BlogPost();
       loremIpsum.authorName = "John Doe";
       loremIpsum.title = "Lorem Ipsum";
       loremIpsum.PublicationDate = "2000.05.04.";
       loremIpsum.text = "Lorem ipsum dolor sit amet.";

        BlogPost waitButWhy = new BlogPost();
        waitButWhy.authorName = "Tim Urban";
        waitButWhy.title = "Wait but why";
        waitButWhy.PublicationDate = "2010.10.10.";
        waitButWhy.text = "A popular long-form, stick-figure-illustrated blog about almost everything.";

        BlogPost oneEngineer = new BlogPost();
        oneEngineer.authorName = "William Turton";
        oneEngineer.title = "One Engineer Is Trying to Get IBM to Reckon With Trump";
        oneEngineer.PublicationDate = "2017.03.28.";
        oneEngineer.text = "Daniel Hanley, a cybersecurity engineer at IBM, doesn’t want to be the center of attention. " +
                "When I asked to take his picture outside one of IBM’s New York City offices, he told me that he wasn’t really into the whole organizer profile thing.";
    }
}
