package constants_new;

import static constants_new.Constants.Path.SWAPI_PATH;
import static constants_new.Constants.Servers.*;

public class Constants {

    public static class RunVeriable {
//                public static String server = SWAPI_URL;
//        public static String server = JSON_PLACEHOLDERS_URL;
        public static String server = REQUSTE_BIN_URL;
//                public static String path = SWAPI_PATH;
        public static String path ="";

    }
//    https://swapi.dev/api/people/
//    https://jsonplaceholder.typicode.com/comments?postId=1

    public static class Servers {
        public static String SWAPI_URL = "https://swapi.dev/";
        public static String GOOGLE_PLACE_URL;
        public static String JSON_PLACEHOLDERS_URL = "https://jsonplaceholder.typicode.com/";
        public static String REQUSTE_BIN_URL = "https://eoh2rag8vberqzu.m.pipedream.net";


    }

    public static class Path {
        public static String SWAPI_PATH = "api/";
        public static String GOOGLE_PLACE_PATH;

    }

    public static class Action {
        //        swapi
        public static String SWAPI_GET_PEOPLE = "people/";
//        public static String GOOGLE_PLACE_PATH;
//        //        jsonPlaceholder
        public static String JSON_PLACEHOLDER_GET = "comments/";
//        //        jsonPlaceholder
        public static String JSON_PLACEHOLDER_PUT = "posts/1/";
//        //        jsonPlaceholder
        public static String JSON_PLACEHOLDER_DELETE = "posts/1/";
//        //        jsonPlaceholder
        public static String JSON_PLACEHOLDER_POST = "posts";
    }
}

