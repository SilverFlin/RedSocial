package edu.itson.webapp.business.impl;

import edu.itson.dominio.Post;
import edu.itson.dominio.TipoPost;
import java.util.LinkedList;
import java.util.List;

/**
 *
 */
public final class PostSorter {

    private PostSorter() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Acomoda los posts respecto a su fecha y si es anclado o no.
     *
     * @param posts
     * @return los posts ordenados.
     */
    public static List<Post> sortPosts(final List<Post> posts) {
        List<Post> orderedPosts = new LinkedList<>(List.copyOf(posts));
        orderedPosts.sort((o1, o2) -> -1);
        orderedPosts = splitByType(orderedPosts);
        return orderedPosts;
    }

    private static List<Post> splitByType(final List<Post> posts) {
        List<Post> sortedPosts = new LinkedList<>();

        List<Post> anchoredPosts = new LinkedList<>();
        List<Post> normalPosts = new LinkedList<>();

        for (Post post : posts) {
            if (post.getTipoPost() == null) {
                continue;
            }

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
