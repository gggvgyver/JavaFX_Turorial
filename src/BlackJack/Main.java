package BlackJack;
import java.util.*;
public class Main {
    private static int cash;//cash the user bets with
    private static int bet;//how much the user wants to bet
    private static int AceCounter;//how many aces are in the user's hand
    private static ArrayList<Card> hand;//represents the user's hand
    private static int handvalue;//the value of the user's hand
    private static String name;//name of the user

    public static void main(String[] args) {
        System.out.println("이름을 입력해 주세요!");
        Scanner scan = new Scanner(System.in);
        name = scan.nextLine();
        System.out.println("안녕, " + name + ", 블랙잭 하자!");
        System.out.println("돈얼마 가지고 있어?");
        Scanner money = new Scanner(System.in);
        cash = money.nextInt();
        System.out.println("게임시작 금액: " + cash);
        while (cash > 0) {
            Deck deck = new Deck();//initialize deck, dealer, hands, and set the bet.
            deck.shuffle();
            AceCounter = 0;
            Dealer dealer = new Dealer(deck);
            List<Card> hand = new ArrayList<>();
            hand.add(deck.drawCard());
            hand.add(deck.drawCard());
            System.out.println("배팅 얼마 걸거니?");
            bet = Bet(cash);
            System.out.println("Cash:" + (cash - bet));
            System.out.println("테이블에 놓인 배팅금액:" + bet);
            System.out.println("너의 패: ");
            System.out.println(hand);
            int handvalue = calcHandValue(hand);
            System.out.println("딜러 오픈: ");
            dealer.showFirstCard();
            if (hasBlackJack(handvalue) && dealer.hasBlackJack())//check if both the user and dealer have blackjack.
            {
                Push();
            } else if (hasBlackJack(handvalue))//check if the user has blackjack.
            {
                System.out.println("축하해 블랙잭이야!");
                System.out.println("You win 2x your money back!");
                cash = cash + bet;
                Win();
            } else if (dealer.hasBlackJack())//check if the dealer has blackjack.
            {
                System.out.println("딜러 패:");
                dealer.showHand();
                Lose();
            } else {
                if (2 * bet < cash)//check if the user can double down.
                {
                    System.out.println("더블다운 할거니?");//allows the user to double down.
                    Scanner doubledown = new Scanner(System.in);
                    String doubled = doubledown.nextLine();
                    while (!isyesorno(doubled)) {
                        System.out.println("yes 혹은 no 을 입력해도!");
                        doubled = doubledown.nextLine();
                    }
                    if (doubled.equals("yes")) {
                        System.out.println("더블다운배팅중!");
                        bet = 2 * bet;
                        System.out.println("Cash:" + (cash - bet));
                        System.out.println("테이블에 놓인돈:" + bet);
                    }
                }
                System.out.println("hit 혹은 stand 결정해도!");//ask if the user will hit or stand
                Scanner hitorstand = new Scanner(System.in);
                String hitter = hitorstand.nextLine();
                while (!isHitorStand(hitter)) {
                    System.out.println("hit 혹은 stand 를 입력해!");
                    hitter = hitorstand.nextLine();
                }
                while (hitter.equals("hit"))//hits the user as many times as he or she pleases.
                {
                    Hit(deck, hand);
                    System.out.println("현재 너의 패는:");
                    System.out.println(hand);
                    handvalue = calcHandValue(hand);
                    if (checkBust(handvalue))//checks if the user busted
                    {
                        Lose();
                        break;
                    }
                    if (handvalue <= 21 && hand.size() == 5)//checks for a five card trick.
                    {
                        fivecardtrick();
                        break;
                    }
                    System.out.println("hit 할래? stand 할래? hit 혹은 stand 입력해라!!!");
                    hitter = hitorstand.nextLine();
                }
                if (hitter.equals("stand"))//lets the user stand.
                {
                    int dealerhand = dealer.takeTurn(deck);//takes the turn for the dealer.
                    System.out.println("");
                    System.out.println("현재 딜러의 패:");
                    dealer.showHand();
                    if (dealerhand > 21)//if the dealer busted, user wins.
                    {
                        Win();
                    } else {
                        int you = 21 - handvalue;//check who is closer to 21 and determine winner
                        int deal = 21 - dealerhand;
                        if (you == deal) {
                            Push();
                        }
                        if (you < deal) {
                            Win();
                        }
                        if (deal < you) {
                            Lose();
                        }
                    }
                }
            }
            System.out.println("다시할래?");//ask if the user wants to keep going
            Scanner yesorno = new Scanner(System.in);
            String answer = yesorno.nextLine();
            while (!isyesorno(answer)) {
                System.out.println("yes or no 입력해도!!");
                answer = yesorno.nextLine();
            }
            if (answer.equals("no")) {
                break;
            }
        }
        System.out.println("너의 돈: " + cash);//if user doesn't want to play or runs out of cash, either congratulates them on their winnings or lets them know
        if (cash == 0) {
            System.out.println("너 오링!");
        } else {
            System.out.println("축하해 이겼어!, " + name + "!");
        }
    }

    /*
     * Checks if the user has blackjack.
     */
    public static boolean hasBlackJack(int handValue) {
        if (handValue == 21) {
            return true;
        }
        return false;
    }

    /*
     * Calculates the value of a player's hand.
     */
    public static int calcHandValue(List<Card> hand) {
        Card[] aHand = new Card[]{};
        aHand = hand.toArray(aHand);
        int handvalue = 0;
        for (int i = 0; i < aHand.length; i++) {
            handvalue += aHand[i].getValue();
            if (aHand[i].getValue() == 11) {
                AceCounter++;
            }
            while (AceCounter > 0 && handvalue > 21) {
                handvalue -= 10;
                AceCounter--;
            }
        }
        return handvalue;
    }

    /*
     * Asks the user how much he or she would like to bet.
     */
    public static int Bet(int cash) {
        Scanner sc = new Scanner(System.in);
        int bet = sc.nextInt();
        while (bet > cash) {
            System.out.println("기본 배팅돈도 없네!");
            System.out.println("얼마 걸래?");
            bet = sc.nextInt();
        }
        return bet;
    }

    /*
     * Called if the user wins.
     */
    public static void Win() {
        System.out.println("니가 이겼다 축하해!");
        cash = cash + bet;
        System.out.println("현금: " + cash);
    }

    /*
     * Called if the user loses.
     */
    public static void Lose() {
        System.out.println("니가 졌다!");
        cash = cash - bet;
        System.out.println("현금: " + cash);
    }

    /*
     * Called if the user pushes
     */
    public static void Push() {
        System.out.println("푸시!");
        System.out.println("돈 다시 갖고 가라.");
        System.out.println("현금: " + cash);
    }

    /*
     * Adds a card to user's hand and calculates the value of that hand. Aces are taken into account.
     */
    public static void Hit(Deck deck, List<Card> hand) {
        hand.add(deck.drawCard());
        Card[] aHand = new Card[]{};
        aHand = hand.toArray(aHand);
        handvalue = 0;
        for (int i = 0; i < aHand.length; i++) {
            handvalue += aHand[i].getValue();
            if (aHand[i].getValue() == 11) {
                AceCounter++;
            }
            while (AceCounter > 0 && handvalue > 21) {
                handvalue -= 10;
                AceCounter--;
            }
        }
    }

    /*
     * Determines if a user has input hit or stand.
     */
    public static boolean isHitorStand(String hitter) {
        if (hitter.equals("hit") || hitter.equals("stand")) {
            return true;
        }
        return false;
    }

    /*
     * Determines if a user has busted.
     */
    public static boolean checkBust(int handvalue) {
        if (handvalue > 21) {
            System.out.println("버스트!");
            return true;
        }
        return false;
    }

    /*
     * Determines if a user has input yes or no.
     */
    public static boolean isyesorno(String answer) {
        if (answer.equals("yes") || answer.equals("no")) {
            return true;
        }
        return false;
    }

    /*
     * Called if the user has a five card trick.
     */
    public static void fivecardtrick() {
        System.out.println("카드 다섯장이네! 니가 이겼어!");
        Win();
    }
}