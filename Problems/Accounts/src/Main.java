import java.util.Scanner;
import java.util.*;
import java.util.stream.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Main {


    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);
        final int n = Integer.parseInt(scanner.nextLine());
        final List<Account> accounts = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            final String[] values = scanner.nextLine().split("\\s+");
            final Account acc = new Account(
                    values[0], Long.parseLong(values[1]), Boolean.parseBoolean(values[2])
            );
            accounts.add(acc);
        }

        //Don't change the code above
        List<Account> nonEmptyAccounts = accounts.stream()
                                .filter(a->a.getBalance()>0)
                                .collect(Collectors.toList());

        List<Account> accountsWithTooMuchMoney = accounts.stream()
                                                .filter(a->!a.isLocked() && a.getBalance() >= 100000000)
                                                .collect(Collectors.toList());

        //Don't change the code below

        nonEmptyAccounts.forEach(a -> System.out.print(a.getNumber() + " "));
        accountsWithTooMuchMoney.forEach(a -> System.out.print(a.getNumber() + " "));
    }

    public static <T> List<T> filter(List<T> elems, Predicate<T> predicate) {
        return elems.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    static class Account {
        private String number;
        private long balance;
        private boolean isLocked;

        public Account(String number, long balance, boolean isLocked) {
            this.number = number;
            this.balance = balance;
            this.isLocked = isLocked;
        }

        public long getBalance() {
            return balance;
        }

        public void setBalance(long balance) {
            this.balance = balance;
        }

        public boolean isLocked() {
            return isLocked;
        }

        public void setLocked(boolean locked) {
            isLocked = locked;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        @Override
        public String toString() {
            return "Account{" +
                    "number='" + number + '\'' +
                    ", balance=" + balance +
                    ", isLocked=" + isLocked +
                    '}';
        }
    }
}