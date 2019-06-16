package sample.service;

import sample.socket.SocketClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewsService {

    private SocketClient socketClient;

    public NewsService(SocketClient socketClient){
        this.socketClient = socketClient;
    }

    public List<News> getNews(){
        String newsString = socketClient.sendEcho("news");
        List<News> newsList = new ArrayList<>();
        String[] outerMarkers = newsString.split("outerMarker");
        System.out.println("OUTERSIZE");
        System.out.println(outerMarkers.length);
        for(String i : outerMarkers)
        {
            String[] innerMarkers = i.split("innerMarker");
            System.out.println("SIZE");
            System.out.println(innerMarkers.length);
            innerMarkers[3] = innerMarkers[3].replaceAll("<p>", "");
            innerMarkers[3] = innerMarkers[3].replaceAll("</p>", "");
            innerMarkers[3] = innerMarkers[3].replaceAll("<img.*/>",  "");
            innerMarkers[3] = innerMarkers[3].replaceAll("<iframe.*iframe>",  "");
            innerMarkers[3] = innerMarkers[3].replaceAll("<strong>",  "");
            innerMarkers[3] = innerMarkers[3].replaceAll("</strong>",  "");
            innerMarkers[3] = innerMarkers[3].replaceAll("<blockquote.*</blockquote>",  "");
            innerMarkers[3] = innerMarkers[3].replaceAll("<script.*/script>",  "");
            News news = new News(innerMarkers[0],
                    innerMarkers[1],
                    innerMarkers[2],
                    innerMarkers[3],
                    innerMarkers[4]);

            newsList.add(news);

        }

        return newsList;

    }
}
