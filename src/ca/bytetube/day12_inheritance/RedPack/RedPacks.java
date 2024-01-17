package ca.bytetube.day12_inheritance.RedPack;

public class RedPacks {
    public static void main(String[] args) {
        Host host = new Host("fang", 100);
        Member member1 = new Member("cs", 50);
        Member member2 = new Member("jun", 20);
        Member member3 = new Member("huan", 10);
        Member member4 = new Member("sheng", 0);

        host.sendMoney(50, 5);
        member1.receiveMoney(host);
        member2.receiveMoney(host);
        member3.receiveMoney(host);
        member4.receiveMoney(host);

        System.out.println(host.showUserInfo());
        System.out.println(member1.showUserInfo());
        System.out.println(member2.showUserInfo());
        System.out.println(member3.showUserInfo());
        System.out.println(member4.showUserInfo());

    }
}

