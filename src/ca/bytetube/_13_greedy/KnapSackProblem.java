package ca.bytetube._13_greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class KnapSackProblem {
    public static void main(String[] args) {
        Article[] articles = new Article[]{new Article(35, 10),new Article(30, 40),
                new Article(40, 35),new Article(10, 40),
                new Article(60, 30),new Article(50, 50),
                new Article(25, 30)};
        select(articles, new Comparator<Article>() {
            @Override
            public int compare(Article a1, Article a2) {
                return a2.value - a1.value;//降序
            }
        });
        System.out.println("=========================================");

       select(articles, new Comparator<Article>() {
           @Override
           public int compare(Article a1, Article a2) {
               return a1.weight - a2.weight;//升序
           }
       });

        System.out.println("=========================================");

        select(articles, new Comparator<Article>() {
            @Override
            public int compare(Article a1, Article a2) {
                return Double.compare(a2.density, a1.density);
            }
        });

    }

    public static void select(Article[] articles, Comparator<Article> comparator){
        Arrays.sort(articles, comparator);
        int capacity = 150;
        int weight = 0;
        int value = 0;
        List<Article> selected = new LinkedList<>();
        for (int i = 0; i < articles.length; i++) {
            int newWeight = weight + articles[i].weight;
            if (newWeight <= capacity) {
                weight = newWeight;
                value += articles[i].value;
                selected.add(articles[i]);
            }
        }

        System.out.println("KnapSack total value:" + value);
        System.out.println(selected);
    }
}
