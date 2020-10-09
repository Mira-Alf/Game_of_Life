import java.util.*;
import java.util.stream.Collectors;

class TransactionCollector {

    public static Map<String, Long> getAccount2TransSum(List<Transaction> trans) {
        Map<String, Long> results = trans.stream()
                .collect(
                    Collectors.groupingBy(t->t.getAccount().getNumber(),
                        Collectors.summingLong(Transaction::getSum))
                );
        //results.keySet().forEach(k-> System.out.println(k+" : "+results.get(k)));
        return results;
    }

    static class Transaction {

        private final String uuid;
        private final Long sum;
        private final Account account;

        public Transaction(String uuid, Long sum, Account account) {
            this.uuid = uuid;
            this.sum = sum;
            this.account = account;
        }

        public String getUuid() {
            return uuid;
        }

        public Long getSum() {
            return sum;
        }

        public Account getAccount() {
            return account;
        }

        @Override
        public String toString() {
            return "Transaction{" +
                    "uuid='" + uuid + '\'' +
                    ", sum=" + sum +
                    '}';
        }
    }

    static class Account {
        private final String number;
        private final Long balance;

        public Account(String number, Long balance) {
            this.number = number;
            this.balance = balance;
        }

        public String getNumber() {
            return number;
        }

        public Long getBalance() {
            return balance;
        }

        @Override
        public String toString() {
            return "Account{" +
                    "number='" + number + '\'' +
                    ", balance=" + balance +
                    '}';
        }
    }

}

/*class Main {
    public static void main(String[] args) {
        List<TransactionCollector.Transaction> transactions =
                List.of(
                        new TransactionCollector.Transaction("0000", 35L, new TransactionCollector.Account("1234", 0L)),
                        new TransactionCollector.Transaction("1111", 49L, new TransactionCollector.Account("5678", 1000L)),
                        new TransactionCollector.Transaction("2222", 28L, new TransactionCollector.Account("5678", 1000L)),
                        new TransactionCollector.Transaction("3333", 100L, new TransactionCollector.Account("1234", 0L)),
                        new TransactionCollector.Transaction("4444", 150L, new TransactionCollector.Account("9012", 3000L)),
                        new TransactionCollector.Transaction("5555", 320L, new TransactionCollector.Account("3456", 4000L)),
                        new TransactionCollector.Transaction("6666", 250L, new TransactionCollector.Account("7890", 5000L))
                );
        Map<String, Long> results = TransactionCollector.getAccount2TransSum(transactions);

    }
}

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
        Account a1 = new Account("1", 518_976L);
        Account a2 = new Account("2", 525_666L);
        Account a3 = new Account("3", 149_938L);

        // Account 1 transactions worth $2,033
        Transaction t1 = new Transaction("dc339462-0c77-4103-b8e0-ed26bfa289f1", 670L, a1);
        Transaction t2 = new Transaction("5dbe4fdd-b368-4944-b486-8587a7dd78d7", 839L, a1);
        Transaction t3 = new Transaction("71fbd37e-adde-47ab-891d-9f57b002d04f", 524L, a1);

        // Account 2 transactions worth $1,162
        Transaction t4 = new Transaction("0aa3f539-60bb-4c8a-a626-85112a96e372", 360L, a2);
        Transaction t5 = new Transaction("e22d83f7-f99b-4265-a3db-b37e89490b82", 446L, a2);
        Transaction t6 = new Transaction("ec59c5cd-d253-4f84-bb64-0126f9123d8a", 356L, a2);

        // Account 3 transactions worth $1,968
        Transaction t7 = new Transaction("64208c87-01a1-4608-b9ab-c2024097e446", 860L, a3);
        Transaction t8 = new Transaction("477293c9-5eb3-468c-818c-e69f8234744f", 204L, a3);
        Transaction t9 = new Transaction("3c3013d2-3297-4a04-ac8e-84ec85fd7b68", 894L, a3);

        List<Transaction> transactions = List.of(t1, t2, t3, t4, t5, t6, t7, t8, t9);
        Map<String, Long> totalSumOfTransByEachAccount = transactions.stream().collect( Collectors.groupingBy(t->t.getAccount().getNumber(), Collectors.summingLong(Transaction::getSum)) );

        for (var element : totalSumOfTransByEachAccount.entrySet()) {
            System.out.println(element.getKey() + " => " + element.getValue());
        }
    }
}

class Account {
    String number;
    Long balance;

    public Account(String number, Long balance) {
        this.number = number;
        this.balance = balance;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }
}

class Transaction {
    String uuid;
    Long sum;
    Account account;

    public Transaction(String uuid, Long sum, Account account) {
        this.uuid = uuid;
        this.sum = sum;
        this.account = account;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Long getSum() {
        return sum;
    }

    public void setSum(Long sum) {
        this.sum = sum;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}*/
