/*import java.util.*;
import java.util.function.Function;
import java.util.function.ToLongFunction;
import java.util.stream.Collectors;

class Monitor {

    public static Map<String, Long> getUrlToNumberOfVisited(List<LogEntry> logs) {
        return logs.stream()
                .collect(
                Collectors.groupingBy(LogEntry::getUrl, Collectors.summingLong(x->1))
                );
    }

    static class LogEntry {

        private Date created;
        private String login;
        private String url;

        public LogEntry(Date created, String login, String url) {
            this.created = created;
            this.login = login;
            this.url = url;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof LogEntry)) {
                return false;
            }

            LogEntry logEntry = (LogEntry) o;

            if (!login.equals(logEntry.login)) {
                return false;
            }
            return url.equals(logEntry.url);
        }

        @Override
        public int hashCode() {
            int result = login.hashCode();
            result = 31 * result + url.hashCode();
            return result;
        }

        @Override
        public String toString() {
            return "LogEntry{" +
                    ", created=" + created +
                    ", login='" + login + '\'' +
                    ", url='" + url + '\'' +
                    '}';
        }
    }
}*/
/*import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        int n = in.nextInt();
        int m = in.nextInt();
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.addLast(num);
        }
        Integer max = 0;
        LinkedList<Integer> consecutiveArray = new LinkedList<>();
        Set<Integer> hashSet = new HashSet<>();
        while(!deque.isEmpty()) {
            while(consecutiveArray.size()<m) {
                Integer elementToBeAdded = deque.removeFirst();
                consecutiveArray.add(elementToBeAdded);
                hashSet.add(elementToBeAdded);
            }
            max = Math.max(max, hashSet.size());
            Integer elementToBeRemoved = consecutiveArray.removeFirst();
            if(!consecutiveArray.contains(elementToBeRemoved))
                hashSet.remove(elementToBeRemoved);

        }
        System.out.println(max);

    }
}*/

import java.util.*;
import java.security.*;
interface Food {
    public String getType();
}
class Pizza implements Food {
    public String getType() {
        return "Someone ordered a Fast Food!";
    }
}

class Cake implements Food {

    public String getType() {
        return "Someone ordered a Dessert!";
    }
}
class FoodFactory {
    public Food getFood(String order) {

        switch(order) {
            case "cake":
                return new Cake();
            case "pizza":
                return new Pizza();
        }

    }//End of getFood method

}//End of factory class

public class Solution {

    public static void main(String args[]){
        Do_Not_Terminate.forbidExit();

        try{

            Scanner sc=new Scanner(System.in);
            //creating the factory
            FoodFactory foodFactory = new FoodFactory();

            //factory instantiates an object
            Food food = foodFactory.getFood(sc.nextLine());


            System.out.println("The factory returned "+food.getClass());
            System.out.println(food.getType());
        }
        catch (Do_Not_Terminate.ExitTrappedException e) {
            System.out.println("Unsuccessful Termination!!");
        }
    }

}
class Do_Not_Terminate {

    public static class ExitTrappedException extends SecurityException {

        private static final long serialVersionUID = 1L;
    }

    public static void forbidExit() {
        final SecurityManager securityManager = new SecurityManager() {
            @Override
            public void checkPermission(Permission permission) {
                if (permission.getName().contains("exitVM")) {
                    throw new ExitTrappedException();
                }
            }
        };
        System.setSecurityManager(securityManager);
    }
}





