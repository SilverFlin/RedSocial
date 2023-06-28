package edu.itson.webapp.business.impl;

import edu.itson.dominio.Post;
import edu.itson.dominio.TipoPost;
import edu.itson.webapp.business.interfaces.IPostSorter;
import java.util.LinkedList;
import java.util.List;

/**
 *
 */
public final class PostSorter implements IPostSorter {

    @Override
    public List<Post> sortPosts(final List<Post> posts) {
        List<Post> orderedPosts = new LinkedList<>(List.copyOf(posts));
        orderedPosts = sortByType(orderedPosts);
        orderedPosts.sort((o1, o2) -> 0);
        return orderedPosts;
    }

    private List<Post> sortByType(final List<Post> posts) {
        List<Post> sortedPosts = new LinkedList<>();

        List<Post> anchoredPosts = new LinkedList<>();
        List<Post> normalPosts = new LinkedList<>();

        for (Post post : posts) {

            if (post.getTipoPost().equals(TipoPost.ANCLADO)) {
                anchoredPosts.add(post);
            } else {
                normalPosts.add(post);
            }
        }

        sortedPosts.addAll(anchoredPosts);
        sortedPosts.addAll(normalPosts);

        return sortedPosts;
    }

}
